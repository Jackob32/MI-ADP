package model;

import visitor.IVisitor;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Enemy extends GameObject{


    public void move(){
    
    this.setX(this.getX()+50);
    
    }

        @Override
    public void accept(IVisitor visitor){
        visitor.visitCollision
    }
    
}
