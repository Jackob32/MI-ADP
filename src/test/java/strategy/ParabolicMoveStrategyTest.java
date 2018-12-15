/*
 * Copyright (c) 2018 Jakub.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Jakub - initial API and implementation and/or initial documentation
 */
package strategy;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jakub
 */
public class ParabolicMoveStrategyTest {
    
    public ParabolicMoveStrategyTest() {
    }
    

    /**
     * Test of nextPositionY method, of class ParabolicMoveStrategy.
     */
    @Test
    public void testNextPositionY() {
        
                Random random = new Random();
        System.out.println("nextPositionY");
        int initY = 0;
        float initAngle = (float)(random.nextFloat()-0.5)*random.nextInt(20);
        float initForce = (float)(random.nextFloat()-0.5)*random.nextInt(20);
        long lifetime = random.nextInt(200);
        ParabolicMoveStrategy instance = new ParabolicMoveStrategy();
        int expResult = (int)(initY +(initForce * lifetime * Math.sin(initAngle)) + lifetime*lifetime/1000);
        int result = instance.nextPositionY(initY, initAngle, initForce, lifetime);
        assertEquals(expResult, result);

    }

    /**
     * Test of nextPositionX method, of class ParabolicMoveStrategy.
     */
    @Test
    public void testNextPositionX() {
        Random random = new Random();
        System.out.println("nextPositionX");
        int initX = 0;
        float initAngle = (float)(random.nextFloat()-0.5)*random.nextInt(20);
        float initForce = (float)(random.nextFloat()-0.5)*random.nextInt(20);
        long lifetime = random.nextInt(200);
        ParabolicMoveStrategy instance = new ParabolicMoveStrategy();
        int expResult = (int)(initX +(initForce * lifetime * Math.cos(initAngle)));
        int result = instance.nextPositionX(initX, initAngle, initForce, lifetime);
        assertEquals(expResult, result);

    }
    
}
