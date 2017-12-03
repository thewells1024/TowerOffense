package cpe307.team6.toweroffense.game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasicUnitTurnTest {
   @Test
   public void testGetDistance() {
      BasicUnit testUnit = new BasicUnit(null, null, 1000);
      testUnit.takeDamage(5);

      assertEquals(995, testUnit.getHealth());
   }
}