/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visitor;

import model.Cannon;
import model.Collision;
import model.Enemy;
import model.Missile;
import model.ModelInfo;

/**
 *
 * @author Jakub Trhlík
 */
public interface IVisitor {
    void visitEnemy(Enemy enemy);
    void visitCollision(Collision collision);
    void visitMissile(Missile missile);
    void visitCannon(Cannon cannon);
    void visitInfo(ModelInfo info);
    
}
