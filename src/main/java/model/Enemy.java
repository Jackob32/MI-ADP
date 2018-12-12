package model;

import visitor.IVisitor;

/**
 *
 * @author Ondrej Stuchlik
 */
public class Enemy extends GameObject {

    private Boolean bMoveFlag = false;
    private int moveStep = 10;

    public void move() {
        this.setX(this.getX() + (this.bMoveFlag ? this.moveStep : -this.moveStep));
        this.setY(this.getY() + (!this.bMoveFlag ? this.moveStep : -this.moveStep));
        this.bMoveFlag = !this.bMoveFlag;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitEnemy(this);
    }

}
