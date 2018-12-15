package model;
import java.util.Random;
import visitor.IVisitor;

/**
 *
 * @author Jakub Trhlik
 */
public class MovingEnemy extends Enemy {

    private Boolean bMoveFlag = false;
    private int bMove = 0;
    private int moveStep = 1;
    private Random random = new Random();
    private int distance = this.random.nextInt(200);
    private double direction = this.random.nextFloat()-0.5;
    
    public void move() {
        
        if(this.bMoveFlag){
            this.bMove++;
            moveStep=1;
        }
        if(!this.bMoveFlag){
            this.bMove--; 
            moveStep=-1;
        }
        
        this.setX(this.getX() + (int)(this.moveStep *3* Math.sin(direction)));
        this.setY(this.getY() + (int)(this.moveStep *3* Math.cos(direction)));
        
        if(bMove<=0){
        this.bMoveFlag = true;
        this.direction = this.random.nextFloat()-0.5;
        this.moveStep = this.random.nextInt(2);
        this.distance = this.random.nextInt(200);
        }else if(bMove>distance){
        this.bMoveFlag = false;
        }
        
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitEnemy(this);
    }

    @Override
    public MovingEnemy clone() {
                MovingEnemy enemy = new MovingEnemy();
        enemy.setX(this.getX());
        enemy.setY(this.getY());
enemy.direction=this.direction;
enemy.distance=this.distance;
  enemy.moveStep=this.moveStep;      
  enemy.bMove=this.bMove;   
    enemy.bMoveFlag=this.bMoveFlag;   
        return enemy;    
            }

}
