package view;

import model.Cannon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import model.Enemy;
import model.GameModel;
import model.GameObject;
import observer.IObserver;
import proxy.IGameModel;

/**
 *
 * @author Jakub Trhlík
 */
public class Canvas extends JPanel implements IObserver{ 
GraphicsDrawer drawer = new GraphicsDrawer();
    IGameModel model;

    public Canvas(int x, int y, int width, int height) {
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.setLocation(x, y);
        this.setPreferredSize(new Dimension(width,height));
        this.setVisible(true);        
    }

    public void setModel(IGameModel model)
    {
        if(this.model != null && model != this.model)
            this.model.detachObserver(this);

        this.model = model;
        this.model.attachObserver(this);
    }
    
    public void update() {        
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(this.model instanceof IGameModel)
        {
            drawer.setGraphics(g);
            
            for(GameObject go : this.model.getGameObjects() )
                go.accept(drawer);
        }
    }
    
}
