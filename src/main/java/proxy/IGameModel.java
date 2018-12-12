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

public interface IGameModel
{
    // getters & setters
    public int getScore();
    public int getMaxX();
    public int getMaxY();
    public Cannon getCannon();
    public ModelInfo getInfo();
    public List<Enemy> getEnemies();
    public List<Missile> getMissiles();

    // observer
    public void attachObserver(IObserver obs);
    public void detachObserver(IObserver obs);
    public void notifyMyObservers();

    // visitor
    public List<GameObject> getGameObjects();

    // strategy
    public IMoveStrategy getActiveMovementStrategy();

    // state
    public void toggleShootingMode();
    
    // business methods
	public void cannonDecForce();
	public void cannonIncForce();
	public void cannonAimDown();
	public void cannonAimUp();
	public void cannonShoot();
    public void moveCannonUp();
    public void moveCannonDown();

    // command
    public void registerCmd(AbsGameCommand cmd);
    public void undoLastCmd();
    
    // memento
    public void setMemento(Object memento);
    public Object createMemento();
	
	
	
}