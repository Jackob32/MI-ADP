package model;

import config.GameConfig;
import visitor.IVisitor;


/**
 *
 * @author Jakub Trhlík
 */
public abstract class GameObject {

    private int x = 100;
    private int y = 100;

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

        public boolean collidesWith(GameObject obj2)
    {
        boolean bCollides = true;

        bCollides = bCollides && (Math.abs(this.getX() - obj2.getX()) < GameConfig.COLLISION_MARGIN);
        bCollides = bCollides && (Math.abs(this.getY() - obj2.getY()) < GameConfig.COLLISION_MARGIN);

        return bCollides;
    }
        
    public abstract void accept(IVisitor visitor);
 }
