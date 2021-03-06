package model;
import java.util.Random;
import visitor.IVisitor;

/**
 *
 * @author Jakub Trhlik
 */
public abstract class Enemy extends GameObject {

    private Boolean bMoveFlag = false;
    private int bMove = 0;
    private int moveStep = 1;
    private Random random = new Random();
        private int distance = this.random.nextInt(200);
    private double direction = this.random.nextFloat()-0.5;
    
    abstract public void move();

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitEnemy(this);
    }
   public abstract Enemy clone();
}
