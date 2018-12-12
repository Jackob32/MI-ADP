package model;

import abstractFactory.IGameObjectsFactory;
import config.GameConfig;
import visitor.IVisitor;

public class Cannon extends GameObject {

    private IGameObjectsFactory goFact;
    private float angle = GameConfig.INIT_ANGLE;
    private float force = GameConfig.INIT_FORCE;

    @Override
    public void accept(IVisitor visitor) {
        visitor.visitCannon(this);
    }

    public float getAngle() {

        return this.angle;
    }

    public float getForce() {

        return this.force;
    }

    public List<Missle> shoot(IVisitor visitor) {
        shootBatch.add(goFact.createMissile(this.getX(), this.getY(), angle, force));

        return shootBatch;
    }

    void incForce() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void aimDown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void aimUp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
