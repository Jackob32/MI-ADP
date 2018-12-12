package model;

/**
 *
 * @author Ondrej Stuchlik
 */
public class ModelInfo extends GameObject{

    private GameModel model;
    
    public ModelInfo(GameModel model){
        this.model=model;
    this.setX(10);
    this.setY(10);
    }

    
    public String getInfoLine(){
    return "Cannon Y:"+this.model.getCannon().getY();
    
    
    }

    @Override
    public 
}
