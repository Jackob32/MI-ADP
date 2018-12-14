package proxy;

import java.util.List;

import command.AbsGameCommand;
import model.Cannon;
import model.Enemy;
import model.GameObject;
import model.Missile;
import model.ModelInfo;
import observer.IObserver;
import strategy.IMoveStrategy;

public class GameModelProxy implements IGameModel {

    private int shootCnt = 0;
    private IGameModel subject;

    public GameModelProxy(IGameModel subject)
    {
        this.subject = subject;
    }

    @Override
    public int getScore() {
        return this.subject.getScore();
    }

    @Override
    public int getMaxX() {
        return this.subject.getMaxX();
    }

    @Override
    public int getMaxY() {
        return this.subject.getMaxY();
    }

    @Override
    public Cannon getCannon() {
        return this.subject.getCannon();
    }

    @Override
    public ModelInfo getInfo() {
        return this.subject.getInfo();
    }

    @Override
    public List<Enemy> getEnemies() {
        return this.subject.getEnemies();
    }

    @Override
    public List<Missile> getMissiles() {
        return this.subject.getMissiles();
    }

    @Override
    public void attachObserver(IObserver obs) {
        this.subject.attachObserver(obs);
    }

    @Override
    public void detachObserver(IObserver obs) {
        this.subject.detachObserver(obs);
    }

    @Override
    public void notifyMyObservers() {
        this.subject.notifyMyObservers();
    }

    @Override
    public List<GameObject> getGameObjects() {
        return this.subject.getGameObjects();
    }

    @Override
    public IMoveStrategy getActiveMovementStrategy() {
        return this.subject.getActiveMovementStrategy();
    }

    @Override
    public void toggleShootingMode() {
        this.subject.toggleShootingMode();
    }

    @Override
    public void cannonDecForce() {
        this.subject.cannonDecForce();
    }

    @Override
    public void cannonIncForce() {
        this.subject.cannonIncForce();
    }

    @Override
    public void cannonAimDown() {
        this.subject.cannonAimDown();
    }

    @Override
    public void cannonAimUp() {
        this.subject.cannonAimUp();
    }

    @Override
    public void cannonShoot() {
        if((this.shootCnt++ % 5) != 0)
            this.subject.cannonShoot();
    }

	@Override
	public void moveCannonUp() {
		this.subject.moveCannonUp();
	}

	@Override
	public void moveCannonDown() {
		this.subject.moveCannonDown();
    }
    
    @Override
    public void registerCmd(AbsGameCommand cmd){
        this.subject.registerCmd(cmd);
    }

    @Override
    public void setMemento(Object memento)
    {
        this.subject.setMemento(memento);
    }

    @Override
    public Object createMemento()
    {
        return this.subject.createMemento();
    }

    @Override
    public void undoLastCmd()
    {
        this.subject.undoLastCmd();
    }
@Override
        public void stopMoveCannonUp()
    {
        this.subject.stopMoveCannonUp();
    }
@Override
    public void stopMoveCannonDown()
    {
        this.subject.stopMoveCannonDown();
    }

}