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
    
    int nextPositionX(int initY, float initAngle,, float initForce, float lifetime);
    int nextpositionY(int initX, float initAngle,, float initForce, float lifetime);
    
}
