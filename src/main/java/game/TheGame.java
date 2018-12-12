package game;

import javax.swing.SwingUtilities;

import controller.GameController;
import model.GameModel;
import proxy.GameModelProxy;
import proxy.IGameModel;
import view.MainWindow;

public class TheGame {
    
    public static void main(String[] args) {      
        
        // create and wire MC
        IGameModel model =  new GameModel();
        IGameModel proxy = new GameModelProxy(model);
        final GameController controller = new GameController(proxy);

        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
               new MainWindow(controller).setVisible(true);
            }
        });
    }
}
