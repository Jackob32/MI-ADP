package model;

import strategy.IMoveStrategy;
import strategy.SimpleMoveStrategy;
import visitor.IVisitor;

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

  public Missile(int x, int y, float angle, float force, IMoveStrategy moveStrategy) {
    this.initX = x;
    this.initY = y;
    this.initAngle = angle;
    this.initForce = force;
    this.moveStrategy = moveStrategy;
  }
  
  public void move()
  {
    long lifetime = this.getLifetime();

    int newX = this.moveStrategy.nextPositionX(initX, initAngle, initForce, lifetime);
    int newY = this.moveStrategy.nextPositionY(initY, initAngle, initForce, lifetime);

    this.setX(newX);
    this.setY(newY);
  }

	@Override
    public void accept(IVisitor visitor) {
		visitor.visitMissile(this);
	}

    @Override
    public Missile clone() {
        Missile obj=new Missile(    this.initX,
    this.initY,
    this.initAngle,
    this.initForce,
    this.moveStrategy);
return obj;
    }
    
}
