package model;

import visitor.IVisitor;

/**
 *
 * @author Jakub Trhlík
 */
public class Collision extends TimedGameObject{
    @Override
    public void accept(IVisitor visitor) {
		visitor.visitCollision(this);
	}

    @Override
    public Collision clone() {
        Collision obj = new Collision();
        obj.setX(this.getX());
        obj.setY(this.getY());
        return obj;
    }

    
 

}
