package cpe307.team6.toweroffense.game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasicUnitTest {
   @Test
   public void testGetDistance() {
      BasicUnit testUnit = new BasicUnit();
      testUnit.takeDamage(5);

      assertEquals(995, testUnit.getHealth());
   }
}