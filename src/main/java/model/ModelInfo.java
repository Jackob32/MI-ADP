package model;

import visitor.IVisitor;

/**
 *
 * @author Jakub Trhlík
 */
public class ModelInfo extends GameObject{
    private GameModel model;

    public ModelInfo(GameModel model)
    {
        this.model = model;
        this.setX(10);
        this.setY(10);
    }
    
    public String getInfoLine()
    {
        return "Cannon Y: " + this.model.getCannon().getY()
                + " score: " + this.model.getScore()
                + " angle: " + this.model.getCannon().getAngle()
                + " force: " + this.model.getCannon().getForce()
                + " Missile.cnt: " + this.model.getMissiles().size()
                + " shootingMode: " + this.model.getCannon().getShootingModeName()
                ;
    }

    @Override
    public void accept(IVisitor visitor) {
		visitor.visitInfo(this);
	}

    @Override
    public GameObject clone() {
       GameObject obj=new ModelInfo(this.model);
       return obj;
    }
}
