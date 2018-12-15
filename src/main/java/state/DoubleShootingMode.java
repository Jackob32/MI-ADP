/*
 * Copyright (c) 2018 Jakub Trhlík.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jakub Trhlík - initial API and implementation and/or initial documentation
 */
package state;

import model.Cannon;
import state.IShootingMode;

/**
 *
 * @author Jakub Trhlík
 */
public class DoubleShootingMode implements IShootingMode {

private static class Holder {
 private static final DoubleShootingMode INSTANCE = new DoubleShootingMode();
 }
    public static DoubleShootingMode getInstance() {
 return Holder.INSTANCE;
 }
    
     @Override
    public void shoot(Cannon cannon) {
        cannon.aimUp();
        cannon.primitiveShoot();
        
        
        
        cannon.aimDown();
        
        
        cannon.aimDown();
        
        
        cannon.primitiveShoot();
        cannon.aimUp();
    }

    @Override
    public void toggleMode(Cannon cannon) {
        cannon.setSingleMode();
    }

    @Override
    public String getName() {
        return "Double";
    }

    
}
