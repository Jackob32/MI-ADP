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

/**
 *
 * @author Jakub Trhlík
 */
public interface IShootingMode{
    
    String getName();

    void shoot(Cannon cannon);
    void toggleMode(Cannon cannon);
}