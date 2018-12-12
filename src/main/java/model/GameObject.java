package model;

import visitor.IVisitor;

/**
 *
 * @author Ondrej Stuchlik
 */
public class GameObject {

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

    
    public abstract void accept(IVisitor visitor);
 }
