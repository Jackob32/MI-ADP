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
class MoveStrategy implements IMoveStrategy{

    @Override
    public int nextPositionX(int initY, float initAngle,, float initForce, float lifetime) {
       return (int)(initX * (initForce * lifetime * Math.sin(initAngle)));
    }

    @Override
    public int nextpositionY(int initY, float initAngle,, float initForce, float lifetime) {
      return (int)(initY * (initForce * lifetime * Math.cos(initAngle)));  }
    
}
