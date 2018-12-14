/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import command.MoveCannonDownCommand;
import command.MoveCannonUpCommand;
import command.StopMoveCannonDownCommand;
import command.StopMoveCannonUpCommand;
import command.UndoCommand;
import java.awt.event.KeyEvent;
import proxy.IGameModel;

/**
 *
 * @author Jakub
 */
public class GameController {

    private IGameModel model;
    //private Canvas view;
    
    public GameController(IGameModel model)
    {
        this.model = model;
    }
    public IGameModel getModel()
    {
        return this.model;
    }

    public void onKeyPress(KeyEvent evt)
    {
        switch(evt.getKeyCode())
        {
            case KeyEvent.VK_W:
                this.model.registerCmd( new MoveCannonUpCommand(this.model) );
                break;
            case KeyEvent.VK_S:
                this.model.registerCmd( new MoveCannonDownCommand(this.model) );
                break;
            case KeyEvent.VK_SPACE:
                this.model.cannonShoot();
                break;
            case KeyEvent.VK_A:
                this.model.cannonAimUp();
                break;
            case KeyEvent.VK_D:
                this.model.cannonAimDown();
                break;
            case KeyEvent.VK_Z:
                if((evt.getModifiers() & KeyEvent.CTRL_MASK) != 0)
                {
                    this.model.registerCmd( new UndoCommand(this.model) );
                }
                break;
            case KeyEvent.VK_J:
                this.model.cannonIncForce();
                break;
            case KeyEvent.VK_K:
                this.model.cannonDecForce();
                break;
            case KeyEvent.VK_Q:
                this.model.toggleShootingMode();
                break;
            default:
                //nothing
        }
         //if(this.view instanceof Canvas)
        //{
        //    this.view.thisIsHowYouForceGuiToRepaint();
        //}
    }

    
        public void onKeyRelease(KeyEvent evt)
    {
        switch(evt.getKeyCode())
        {
             case KeyEvent.VK_W:
                this.model.registerCmd( new StopMoveCannonUpCommand(this.model) );
                break;
            case KeyEvent.VK_S:
                this.model.registerCmd( new StopMoveCannonDownCommand(this.model) );
                break;
            default:
                //nothing
        }

        //if(this.view instanceof Canvas)
        //{
        //    this.view.thisIsHowYouForceGuiToRepaint();
        //}
    }
    
        
        
}
