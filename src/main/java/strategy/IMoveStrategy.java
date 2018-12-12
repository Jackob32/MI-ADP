/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategy;

/**
 *
 * @author Jakub
 */
public interface IMoveStrategy {
    
    int nextPositionY(int initY, float initAngle, float initForce, long lifetime);
    int nextPositionX(int initX, float initAngle, float initForce, long lifetime);
    
}
