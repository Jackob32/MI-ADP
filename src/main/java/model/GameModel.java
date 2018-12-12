/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import abstractFactory.*;
import config.GameConfig;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import observer.IObservable;
import observer.IObserver;

/**
 *
 * @author Jakub
 */
public class GameModel implements IObservable {

    private int moveStep = 10;
    private Cannon cannon = new Cannon();
    private Collision collision = new Collision();
    private ModelInfo info = new ModelInfo(this);
    private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    private Enemy enemy = new Enemy();

   
    private Missile missile = new Missile();
    
            List<Missile> Missiles= new ArrayList<Missile>();
    private int cofMaxEnemies = 10;
    private int confMoveStep = 10;
    private int confMoveTick = 10;
    private int confMaxX = 500;
    private int confMaxY = 500;
        
    
    
   
    private Timer timer;

    private ArrayList<IObserver> myObservers = new ArrayList<IObserver>();

    private IGameObjectsFactory goFact = new GameObjectFactory(this);

    public GameModel() {
        for (int i = 0; i < this.cofMaxEnemies; i++) {
            this.enemies.add(this.goFact.createEnemy());
        }

    }

    public void moveGameObjects() {
        this.moveEnemies();
    }

    private void moveEnemies() {
        for (Enemy e : this.getEnemies()) {
            e.move();
        }
    }

    
        private void moveMissiles() {
            Set<Missile> toRemove=new HashSet<Missile>();
            
            
            
        for (Missile m : this.getMissiles()) {
            m.move();
            
            if(m.getX()<0 || m.getX()>this.getMaxX())
                toRemove.add(m);
             if(m.getY()<0 || m.getY()>this.getMaxY())
                toRemove.add(m);
                    
            
            
        }
        
         for (Missile r : toRemove) {

            this.Missiles.remove(r);
            
        }
    }
    
    public void initTimer() {
        this.timer = new Timer();
        this.timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //executed every tick
                moveGameObjects();
            }
        }, 0, this.confMoveTick);

    }

    public int getMaxX() {
        return GameConfig.MAX_X;
    }

    public int getMaxY() {
        return GameConfig.MAX_Y;
    }

    public void moveCannonUp() {
        System.out.println(" up ");

        int y = this.cannon.getY();
        y -= moveStep;
        this.cannon.setY(y);
        this.notifyMyObservers();
    }

    public void moveCannonDown() {
        System.out.println(" down ");
        int y = this.cannon.getY();
        y += moveStep;
        this.cannon.setY(y);
        this.notifyMyObservers();

    }

    public void moveCannonLeft() {

        int x = this.cannon.getX();
        x -= moveStep;
        this.cannon.setY(x);

    }

    public void moveCannonRight() {
        int x = this.cannon.getX();
        x += moveStep;
        this.cannon.setY(x);

    }

    public void attachObserver(IObserver obs) {
        this.myObservers.add(obs);
    }

    public void detachObserver(IObserver obs) {
        this.myObservers.remove(obs);
    }

    public void notifyMyObservers() {
        for (IObserver o : this.myObservers) {
            o.update();
        }

    }

    public Cannon getCannon() {
        return cannon;
    }

    public ModelInfo getModelInfo() {
        return info;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }
    public List<Missile> getMissiles() {
    
        return Missiles;
    }
    
    public List<GameObject> getGameObjects(){
    List<GameObject> allGO = new ArrayList<GameObject>();
    
    allGO.addAll(this.enemies);
    allGO.add(this.cannon);
    allGO.add(this.info);
    
    return allGO;
    }

    public void moveCannonAimUp() {
        this.cannon.aimUp();
    }

    public void moveCannonAimDown() {
         this.cannon.aimDown();}

    public void moveCannonIncForce() {
              this.cannon.incForce();}

    public void moveCannonDecForce() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void moveCannonShoot() {
        //add new missile
       this.Missiles.add(new Missile(confMaxX, confMaxY, moveStep, moveStep));
               }
}

