package model;
/*
Game Model nezavisly na Contolleru a na view
slouží jako fasáda
testovatelný, spustitelný i bez view a controlleru
neobsahuje herní logiku, logika je rozmístěna do příslušných tříd (missile.move() etc)
*/

import strategy.SimpleMoveStrategy;
import strategy.IMoveStrategy;

import abstractFactory.GameObjectsFactory;
import abstractFactory.IGameObjectsFactory;
import config.GameConfig;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;
import observer.IObservable;
import observer.IObserver;
import proxy.IGameModel;
import command.AbsGameCommand;

/**
 *
 * @author Jakub Trhlík
 */

    public class GameModel implements IObservable, IGameModel
{
    private Cannon cannon = null;
    private ModelInfo info = null;
    private List<Enemy> enemies = new ArrayList<Enemy>();
    private List<Missile> missiles = new ArrayList<Missile>();
    private List<Collision> collisions = new ArrayList<Collision>();

    

    private int score = GameConfig.INIT_SCORE;
    private float gravity = GameConfig.INIT_GRAVITY;
    // ..
    
    private ArrayList<IObserver> myObservers = new ArrayList<IObserver>();
    private IGameObjectsFactory goFact = new GameObjectsFactory(this);
    private Timer timer;
    private IMoveStrategy activeMovementStrategy;
    private Queue<AbsGameCommand> unexecutedCmds = new LinkedBlockingQueue<AbsGameCommand>();
    private Stack<AbsGameCommand> executedCmds = new Stack<AbsGameCommand>();
    
    

    public GameModel()
    {
        this.activeMovementStrategy = new SimpleMoveStrategy();
        this.cannon = this.goFact.createCannon();
        this.info = this.goFact.createModelInfo();

        for(int i=0; i < GameConfig.MAX_ENEMIES; i++)
            this.enemies.add( this.goFact.createEnemy() );
        
        this.initTimer();
    }

    private void initTimer()
    {
        this.timer = new Timer();
        this.timer.schedule(new TimerTask() {
            @Override
            public void run()
            {
                // this is executed every Tick
                moveGameObjects();
                
                executeCmds();
            }
        }, 0, GameConfig.TIME_TICK);
    }

    private void executeCmds()
    {
        while(!this.unexecutedCmds.isEmpty())
        {
            AbsGameCommand c = this.unexecutedCmds.poll();
            
            this.executedCmds.add(c);

            //c.execute();
            c.extExecute();
        }
        
    }

    public void undoLastCmd()
    {
        this.executedCmds.pop(); // remove UndoCommand
        if(this.executedCmds.empty()) return;
        
        AbsGameCommand cmd = this.executedCmds.pop();
        cmd.unexecute();
    }

    public void setMemento(Object memento)
    {
        Memento m = (Memento)memento;
        this.score = m.score;
        // TODO ...
    }

 
    private class Memento {
        public int score;
        // TODO ...
    }

    public Object createMemento()
    {
        Memento memento = new Memento();

        memento.score = this.score;
        //memento.cannon = /*clone*/ this.cannon;
        // TODO ...

        return memento;
    }

    private void moveGameObjects()
    {
        this.moveCannon();
        this.moveEnemies();
        this.moveMissiles();
        this.handleCollisions();
        this.notifyMyObservers();
    }

    private void handleCollisions()
    {
        Set<Missile> missilesToRemove = new HashSet<Missile>();
        Set<Enemy> enemiesToRemove = new HashSet<Enemy>();
        Set<Collision> collisionsToRemove = new HashSet<Collision>();

        for(Enemy e : this.getEnemies())
        {
            for(Missile m : this.getMissiles())
            {
                if(m.collidesWith(e))
                {
                    this.score++;
                    missilesToRemove.add(m);
                    enemiesToRemove.add(e);
                    this.collisions.add( this.goFact.createCollision(e.getX(), e.getY()) );
                }
            }
        }

        // remove destroyed enemies & missiles
        for(Enemy e : enemiesToRemove)
            this.enemies.remove(e);
        for(Missile m : missilesToRemove)
            this.missiles.remove(m);

        // remove old collision
        for(Collision c : this.collisions)
            if(c.getLifetime() > GameConfig.COLLISION_LIFETIME)
                collisionsToRemove.add(c);
        for(Collision c : collisionsToRemove)
            this.collisions.remove(c);
    }

    private void moveEnemies()
    {
        for(Enemy e : this.getEnemies())
        {
            e.move();
        }
    }
    private void moveCannon()
    {
            cannon.move();
    }
    private void moveMissiles()
    {
        Set<Missile> toRemove = new HashSet<Missile>();
        for(Missile m : this.getMissiles())
        {
            m.move();

            if(m.getX() < 0 || m.getX() > this.getMaxX())
                toRemove.add(m);
            if(m.getY() < 0 || m.getY() > this.getMaxY())
                toRemove.add(m);
        }

        for(Missile m : toRemove)
            this.missiles.remove(m);
    }

    public int getMaxX() { return GameConfig.MAX_X; }
    public int getMaxY() { return GameConfig.MAX_Y; }

    public Cannon getCannon()
    {
        return this.cannon;
    }

    public ModelInfo getInfo()
    {
        return this.info;
    }

    public List<Enemy> getEnemies()
    {
        return this.enemies;
    }

    public List<Missile> getMissiles()
    {
        return this.missiles;
    }

    
    public void registerCmd(AbsGameCommand cmd){
        this.unexecutedCmds.add(cmd);
    }

    // IObservable implementation
    public void attachObserver(IObserver obs)
    {
        if(!this.myObservers.contains(obs))
            this.myObservers.add(obs);
    }

    public void detachObserver(IObserver obs)
    {
        this.myObservers.remove(obs);
    }

    public void notifyMyObservers()
    {
        for(IObserver o : this.myObservers)
            o.update();
    }

	public List<GameObject> getGameObjects() {
        List<GameObject> allGO = new ArrayList<GameObject>();

        allGO.addAll(this.enemies);
        allGO.addAll(this.missiles);
        allGO.addAll(this.collisions);
        allGO.add(this.cannon);
        allGO.add(this.info);
        
        return allGO;
	}

	public void cannonDecForce() {
        this.cannon.decForce();
        this.notifyMyObservers();
	}

	public void cannonIncForce() {
        this.cannon.incForce();
        this.notifyMyObservers();
	}

	public void cannonAimDown() {
        this.cannon.aimDown();
        this.notifyMyObservers();
	}

	public void cannonAimUp() {
        this.cannon.aimUp();
        this.notifyMyObservers();
	}

	public void cannonShoot() {
        this.missiles.addAll( this.cannon.shoot() );
        this.notifyMyObservers();
    }
    
    public void moveCannonUp()
    {
        this.cannon.setmoveUp(true);
        this.notifyMyObservers();
    }

    public void moveCannonDown()
    {
        this.cannon.setmoveDown(true);
        this.notifyMyObservers();
    }
        public void stopMoveCannonUp()
    {
        this.cannon.setmoveUp(false);
        this.notifyMyObservers();
    }

    public void stopMoveCannonDown()
    {
        this.cannon.setmoveDown(false);
        this.notifyMyObservers();
    }
    
	public IMoveStrategy getActiveMovementStrategy() {
		return this.activeMovementStrategy;
	}

	public void toggleShootingMode() {
        this.cannon.toggleMode();
        this.notifyMyObservers();
	}

	public int getScore() {
		return this.score;
	}
}