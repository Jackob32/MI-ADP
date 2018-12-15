package model;
import java.util.Random;
import visitor.IVisitor;

/**
 *
 * @author Jakub Trhlik
 */
public class SimpleEnemy extends Enemy {

    private Boolean bMoveFlag = false;
    private int bMove = 0;
    private int moveStep = 1;
    private Random random = new Random();
    private int distance = this.random.nextInt(200);
    private double direction = this.random.nextFloat()-0.5;
    
    public void move() {
        this.setX(this.getX());
        this.setY(this.getY());
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitEnemy(this);
    }

    @Override
    public SimpleEnemy clone() {
                SimpleEnemy enemy = new SimpleEnemy();
        enemy.setX(this.getX());
        enemy.setY(this.getY());

        return enemy;    
            }

}
