/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
