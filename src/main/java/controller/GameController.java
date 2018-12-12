/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import cz.fit.dpo.mvcshooter.view.Canvas;
import java.awt.event.KeyEvent;
import model.GameModel;

/**
 *
 * @author Jakub
 */
public class GameController {

    private GameModel model;
    private Canvas view;

    public GameController(GameModel model) {
        this.model = model;
    }

    /*
    public void setView(Canvas view) {
        this.view = view;
    }
     */
    public void onKeyPress(KeyEvent e) {
        System.out.println("key pressed: " + e.getKeyChar() + "code " + e.getKeyCode() + " up " + KeyEvent.VK_UP);

        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.model.moveCannonUp();
                break;
            case KeyEvent.VK_DOWN:
                this.model.moveCannonDown();
                break;
            case KeyEvent.VK_SPACE:
                this.model.moveCannonShoot();
                    case KeyEvent.VK_LEFT:
                this.model.moveCannonAimUp();
                break;
            case KeyEvent.VK_RIGHT:
                this.model.moveCannonAimDown();
                break;    
      case KeyEvent.VK_PLUS:
                this.model.moveCannonIncForce();
                break;   
      case KeyEvent.VK_MINUS:
                this.model.moveCannonDecForce();
                break;   
            default: //nothing
        }

        /// misto tohodle, pouzijeme observer
        ///view.thisIsHowYouForceGuiToRepaint();
    }

    public GameModel getModel() {
        return this.model;
    }

}
