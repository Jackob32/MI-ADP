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
import abstractFactory.IGameObjectsFactory;
import config.GameConfig;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import visitor.IVisitor;

/**
 *
 * @author Jakub
 */
@RunWith(MockitoJUnitRunner.class)
public class CannonTest {

    public CannonTest() {
    }

    public Cannon toTest;

    @Before
    public void prepare() {
        GameModel model = new GameModel();
        GameObjectsFactory goFact = new GameObjectsFactory(model);
        toTest = new Cannon(goFact);
    }

    /**
     * Test of move method, of class Cannon.
     */
    @Test
    public void testMove() {
        System.out.println("move");

        int beforeMoveY = toTest.getY();

        toTest.setmoveDown(true);

        toTest.move();
        toTest.move();
        // test if moved
        Assert.assertSame("Cannon moved Accordingly",
                beforeMoveY + GameConfig.MOVE_STEP + GameConfig.MOVE_STEP,
                toTest.getY()
        );
    }

    /**
     * Test of shoot method, of class Cannon.
     */
    @Test
    public void testShoot() {
        System.out.println("shoot");
        Cannon instance = toTest;

        List<Missile> result = instance.shoot();
        assertEquals(1, result.size());

    }

    /**
     * Test of getAngle method, of class Cannon.
     */
    @Test
    public void testGetAngle() {
        System.out.println("getAngle");
        Cannon instance = toTest;
        float expResult = GameConfig.INIT_ANGLE;

        float result = instance.getAngle();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of getForce method, of class Cannon.
     */
    @Test
    public void testGetForce() {
        System.out.println("getForce");
        Cannon instance = toTest;
        float expResult = GameConfig.INIT_FORCE;
        float result = instance.getForce();
        assertEquals(expResult, result, 0.0);

    }

    /**
     * Test of decForce method, of class Cannon.
     */
    @Test
    public void testDecForce() {
        System.out.println("decForce");
        Cannon instance = toTest;
        float expResult = GameConfig.INIT_FORCE - GameConfig.FORCE_STEP;
        instance.decForce();
        float result = instance.getForce();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of incForce method, of class Cannon.
     */
    @Test
    public void testIncForce() {
        System.out.println("incForce");
        Cannon instance = toTest;
        float expResult = GameConfig.INIT_FORCE + GameConfig.FORCE_STEP;
        instance.incForce();
        float result = instance.getForce();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of aimDown method, of class Cannon.
     */
    @Test
    public void testAimDown() {
        System.out.println("aimDown");
        Cannon instance = toTest;
        float expResult = GameConfig.INIT_ANGLE + GameConfig.ANGLE_STEP;
        instance.aimDown();
        float result = instance.getAngle();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of aimUp method, of class Cannon.
     */
    @Test
    public void testAimUp() {
        System.out.println("aimUp");
        Cannon instance = toTest;
        float expResult = GameConfig.INIT_ANGLE - GameConfig.ANGLE_STEP;
        instance.aimUp();
        float result = instance.getAngle();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of moveUp method, of class Cannon.
     */
    @Test
    public void testMoveUp() {
        System.out.println("moveUp");
        Cannon instance = toTest;
        float expResult = toTest.getY() - GameConfig.MOVE_STEP;
        instance.moveUp();
        float result = instance.getY();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setmoveUp method, of class Cannon.
     */
    @Test
    public void testSetmoveUp() {
        System.out.println("setmoveUp");
        boolean move = false;
        Cannon instance = toTest;
        instance.setmoveUp(move);

    }

    /**
     * Test of moveDown method, of class Cannon.
     */
    @Test
    public void testMoveDown() {
        System.out.println("moveDown");

        int beforeMoveY = toTest.getY();

        toTest.moveDown();

        // test if moved
        Assert.assertSame("Cannon moved Accordingly",
                beforeMoveY + GameConfig.MOVE_STEP,
                toTest.getY()
        );

    }

    /**
     * Test of setmoveDown method, of class Cannon.
     */
    @Test
    public void testSetmoveDown() {
        System.out.println("setmoveDown");
        boolean move = false;
        Cannon instance = toTest;
        instance.setmoveDown(move);

    }

    /**
     * Test of clone method, of class Cannon.
     */
    @Test
    public void testClone() {
        System.out.println("clone");
        Cannon expResult = toTest;
        Cannon result = toTest.clone();
        assertEquals(expResult.getForce(), result.getForce(),0.0);

    }

}
