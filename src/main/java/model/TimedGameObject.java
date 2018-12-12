/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Jakub
 */
public abstract class TimedGameObject extends GameObject{
    
    private long created=System.currentTimeMillis();
    
    public long getLifetime(){
    return System.currentTimeMillis()-this.created;
    }
    
}
