/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abstractFactory;

import java.util.Random;
import model.Cannon;
import model.Collision;
import model.Enemy;
import model.GameModel;
import model.Missile;
import model.ModelInfo;

/**
 *
 * @author Jakub
 */
public class GameObjectFactory implements IGameObjectsFactory{

    Random random = new Random();
    private GameModel model;

    public GameObjectFactory(GameModel model) {
        this.model = model;
    }

    public Cannon createCannon() {
        return new Cannon();
    }

    public Enemy createEnemy() {

        int canX = this.model.getCannon().getX();
        //int canY = this.getCannon().getY();
        int posX = canX + random.nextInt(this.model.getMaxX() - canX);
        int posY = random.nextInt(this.model.getMaxY());

        Enemy enemy = new Enemy();
        enemy.setX(posX);
        enemy.setY(posY);

        return enemy;
    }

    public Missile createMissile(int x, int y, float angle, float force) {
        return new Missile(int x, int y, float angle, float force);
    }

    public Collision createCollision() {
        return new Collision();
    }

    public ModelInfo createModelInfo() {
        return new ModelInfo(this.model);
    }

}
