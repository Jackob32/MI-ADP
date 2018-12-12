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
public class GameObjectsFactory implements IGameObjectsFactory{

       private GameModel model;
    private Random random = new Random();

    public GameObjectsFactory(GameModel model)
    {
        this.model = model;
    }

    public Cannon createCannon()
    {
        return new Cannon(this);
    }

    public Enemy createEnemy()
    {
        int canX = this.model.getCannon().getX();
        
        int posX = canX + this.random.nextInt( this.model.getMaxX() - canX );
        int posY = this.random.nextInt( this.model.getMaxY() );

        Enemy enemy = new Enemy();
        enemy.setX(posX);
        enemy.setY(posY);

        return enemy;        
    }

    public Missile createMissile(int x, int y, float angle, float force)
    {
        return new Missile(x, y, angle, force / 10.0f, this.model.getActiveMovementStrategy());
    }
    
    public Collision createCollision(int x, int y)
    {
        Collision c = new Collision();
        c.setX(x);
        c.setY(y);
        return c;
    }

    public ModelInfo createModelInfo()
    {
        return new ModelInfo(this.model);
    }

}
