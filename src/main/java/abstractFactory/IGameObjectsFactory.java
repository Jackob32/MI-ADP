/*
AbstractFactory
Abstract Class of the Game Objects factory
 */
package abstractFactory;

import model.Cannon;
import model.Collision;
import model.Enemy;
import model.Missile;
import model.ModelInfo;

/**
 *
 * @author Jakub Trhlík
 */
public interface IGameObjectsFactory {
    
    Cannon createCannon();
    Enemy createEnemy();
    Missile createMissile(int x,int y, float angle, float force);
    Collision createCollision(int x, int y);
    ModelInfo createModelInfo();
    
}
