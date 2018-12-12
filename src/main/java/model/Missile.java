package model;

import strategy.IMoveStrategy;
import strategy.MoveStrategy;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Missile extends TimedGameObject {

    private int initX;
    private int initY;
    private float initAngle;
    private float initForce;
private IMoveStrategy moveStrategy;
    
    
    public Missile(int x, int y, float angle, float force,IMoveStrategy movestrategy) {
        initX = x;
        initY = y;
        initAngle = angle;
        initForce = force;
        moveStrategy=movestrategy;
    }

    public void move() {
        long lifetime = this.getLifetime();

       // int newX = (int)(initX * (initForce * lifetime * Math.sin(initAngle)));
       int newX = this.moveStrategy.nextPositionX(initX,initAngle,initForce,lifetime);
        int newY = this.moveStrategy.nextPositionX(initY,initAngle,initForce,lifetime);
        //int newY = (int)(initY * (initForce * lifetime * Math.cos(initAngle)));

        
        //strategy
        
        
        this.setX(newX);
        this.setY(newX);
      }

    @Override
    public void accept() {
        visitor.visitMissile(this);
    }

}
