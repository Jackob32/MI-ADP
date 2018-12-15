/*
AbstractFactory
Class of the Game Objects factory
 */
package abstractFactory;

import java.util.Random;
import model.Cannon;
import model.Collision;
import model.Enemy;
import model.GameModel;
import model.Missile;
import model.ModelInfo;
import model.SimpleEnemy;

/**
 *
 * @author Jakub
 */
public class SimpleGameObjectsFactory implements IGameObjectsFactory{

    private GameModel model;
    private Random random = new Random();

    public SimpleGameObjectsFactory(GameModel model)
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
        
        int X = canX + this.random.nextInt( this.model.getMaxX() - canX );
        int Y = this.random.nextInt( this.model.getMaxY() );

        Enemy enemy = new SimpleEnemy();
        enemy.setX(X);
        enemy.setY(Y);

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
