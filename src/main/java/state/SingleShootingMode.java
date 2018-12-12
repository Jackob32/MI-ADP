
package state;

import model.Cannon;

/**
 *
 * @author Jakub Trhlík
 */
public class SingleShootingMode implements IShootingMode{

    @Override
    public void shoot(Cannon cannon) {
        cannon.primitiveShoot();
    }

    @Override
    public void toggleMode(Cannon cannon) {
        cannon.setDoubleMode();
    }

    @Override
    public String getName() {
        return "Single";
    }
    
}
