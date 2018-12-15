package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.matchers.GreaterThan;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class MovingEnemyTest {

     public MovingEnemy toTest;
    
    @Before
    public void prepare() {
        toTest = new MovingEnemy();
    }
     
    @Test
    public void testMove() {
        
        int beforeMoveY=toTest.getX();
        int beforeMoveX=toTest.getY();
        
        toTest.move();
        
        // test if moved
        Assert.assertNotSame("MovingEnemy hasnt moved", beforeMoveX+" "+beforeMoveY, toTest.getX()+" "+toTest.getY());
        // test if moved properly
        Assert.assertTrue("MovingEnemy didnt move properly",
           Math.hypot(beforeMoveX-toTest.getX(),beforeMoveY-toTest.getY())<10);

    }

}
