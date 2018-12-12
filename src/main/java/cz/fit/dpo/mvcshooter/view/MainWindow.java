package cz.fit.dpo.mvcshooter.view;

import controller.GameController;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.GameModel;

/**
 *
 * @author Ondrej Stuchlik
 */
public class MainWindow extends JFrame {


 
    
    public MainWindow(final GameController controller) {
        try {
            
            GameModel model=controller.getModel();
            Canvas view = new Canvas(0, 0, model.getMaxX(), model.getMaxY());

            view.setModel(controller.getModel());
           // controller.setView(view);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setTitle("MyShooter");
            this.setResizable(false);

            Dimension obrazovka = Toolkit.getDefaultToolkit().getScreenSize();
            this.setLocation(
                  (int) (obrazovka.getWidth() / 2 - 250),
                  (int) (obrazovka.getHeight() / 2 - 250));

            this.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent evt) {
                    // delegate to controller
                    
                    //odsud dal resit na controller
                    //vypisuje stisk klavesy
                   controller.onKeyPress(evt);
                }
            });

            this.add(view);
            this.pack();
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
    
    public void showHelp() {
        JOptionPane.showMessageDialog(this, 
              "Controls: \n"
              + "here goes some description...");
    }
}
