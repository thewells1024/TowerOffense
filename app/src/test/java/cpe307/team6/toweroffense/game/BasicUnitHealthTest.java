package cpe307.team6.toweroffense.game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// Ian Watts
public class BasicUnitHealthTest {
   @Test
   public void testGetDistance() {
      BasicUnit testUnit = new BasicUnit(null, null, null, 1000);
      testUnit.takeDamage(5);

      assertEquals(995, testUnit.getHealth());
   }
}