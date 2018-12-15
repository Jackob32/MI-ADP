package model;

import state.DoubleShootingMode;
import state.IShootingMode;
import state.SingleShootingMode;
import abstractFactory.IGameObjectsFactory;
import config.GameConfig;
import java.util.ArrayList;
import java.util.List;
import visitor.IVisitor;

public class Cannon extends GameObject {

    private IGameObjectsFactory goFact;
    private float angle = GameConfig.INIT_ANGLE;
    private float force = GameConfig.INIT_FORCE;
    private IShootingMode shootingMode;
    private List<Missile> shootBatch;

    private boolean moveUP = false;
    private boolean moveDOWN = false;

    public Cannon(IGameObjectsFactory goFact) {
        this.goFact = goFact;
        this.setSingleMode();
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitCannon(this);
    }

    public void move() {

        if(this.moveDOWN && !this.moveUP) this.moveDown();
        if(this.moveUP && !this.moveDOWN) this.moveUp();
        
    }

    public List<Missile> shoot() {
        this.shootBatch = new ArrayList<Missile>();

        // delegate event reaction to current ShootingMode (calls primitiveShoot)
        this.shootingMode.shoot(this);

        return shootBatch;

    }

    public void toggleMode() {
        this.shootingMode.toggleMode(this);
    }

    public void primitiveShoot() {
        shootBatch.add(goFact.createMissile(this.getX(), this.getY(), angle, force));
    }

    public void setSingleMode() {
        this.shootingMode = SingleShootingMode.getInstance();
    }

    public String getShootingModeName() {
        return this.shootingMode.getName();
    }

    public void setDoubleMode() {
        this.shootingMode = DoubleShootingMode.getInstance();
    }

    public float getAngle() {
        return this.angle;
    }

    public float getForce() {
        return this.force;
    }

    public void decForce() {
        this.force -= GameConfig.FORCE_STEP;
    }

    public void incForce() {
        this.force += GameConfig.FORCE_STEP;
    }

    public void aimDown() {
        this.angle += GameConfig.ANGLE_STEP;
    }

    public void aimUp() {
        this.angle -= GameConfig.ANGLE_STEP;
    }

    public void moveUp() {
        this.setY(this.getY() - GameConfig.MOVE_STEP);
    }

    public void setmoveUp(boolean move) {
        this.moveUP = move;
    }

    public void moveDown() {
        this.setY(this.getY() + GameConfig.MOVE_STEP);
    }

    public void setmoveDown(boolean move) {
        this.moveDOWN = move;
    }

    @Override
    public Cannon clone() {
    Cannon obj=new Cannon(this.goFact);
    obj.setX(this.getX());
    obj.setY(this.getY());
    return obj;
}

}
