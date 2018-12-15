
package state;

import model.Cannon;

/**
 *
 * @author Jakub Trhlík
 */
public class SingleShootingMode implements IShootingMode{
private static class Holder {
 private static final SingleShootingMode INSTANCE = new SingleShootingMode();
 }
    public static SingleShootingMode getInstance() {
 return Holder.INSTANCE;
 }
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
