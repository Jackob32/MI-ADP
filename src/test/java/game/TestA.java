
package game;

import model.Cannon;
import model.CannonTest;
import model.MissileTest;
import model.ModelTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import model.MovingEnemyTest;
/*
 * Copyright (c) 2018 Jakub.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jakub - initial API and implementation and/or initial documentation

/**
 *
 * @author Jakub
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
   MovingEnemyTest.class,
   ModelTest.class,
    MissileTest.class,
    CannonTest.class,
})

public class TestA {
        
}
