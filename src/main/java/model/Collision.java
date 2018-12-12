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

    
 

}
