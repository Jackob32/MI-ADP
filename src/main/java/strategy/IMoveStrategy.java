/*
abstrakce strategie pohybu
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
