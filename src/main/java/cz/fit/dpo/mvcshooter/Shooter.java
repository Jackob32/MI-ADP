package cz.fit.dpo.mvcshooter;

import controller.GameController;
import cz.fit.dpo.mvcshooter.view.MainWindow;
import javax.swing.SwingUtilities;
import model.GameModel;

/**
 *
 * @author stue
 */
public class Shooter {
    
    public static void main(String[] args) {     
        
        final GameModel model=new GameModel();
        final GameController controller=new GameController(model);
        
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
               new MainWindow(controller).setVisible(true);
            }
        });
    }
}
