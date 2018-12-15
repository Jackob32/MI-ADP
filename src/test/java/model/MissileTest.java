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
package model;

import abstractFactory.GameObjectsFactory;
import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import strategy.ParabolicMoveStrategy;
import visitor.IVisitor;

/**
 *
 * @author Jakub
 */
public class MissileTest {
    
        private Random random = new Random();
    private int x = this.random.nextInt(200);
    private int y = this.random.nextInt(200);
     private int force = this.random.nextInt(20);
     private float angle = (float)(this.random.nextFloat()-0.5);
    
          public Missile toTest;
    public MissileTest() {
        
        
    }
    
    
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {

        toTest=new Missile(x,y,angle,force,new ParabolicMoveStrategy());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of move method, of class Missile.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        Missile instance = toTest;
          int beforeMoveY=toTest.getX();
        int beforeMoveX=toTest.getY();
        instance.move();
        instance.move();
         // test if moved
        Assert.assertNotSame("Missile hasnt moved", beforeMoveX+" "+beforeMoveY, toTest.getX()+" "+toTest.getY());
        // test if moved properly
        Assert.assertTrue("Missile didnt move properly",
           Math.hypot(beforeMoveX-toTest.getX(),beforeMoveY-toTest.getY())<100);
    }

    /**
     * Test of clone method, of class Missile.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        Missile instance = toTest;
        Missile result = instance.clone();
        System.out.println(instance.toString());
         System.out.println(result.toString());
        
        assertEquals(instance.getLifetime()+" "+instance.getX()+" "+instance.getY(), 
                result.getLifetime()+" "+result.getX()+" "+result.getY()
        );

    }
    
}
