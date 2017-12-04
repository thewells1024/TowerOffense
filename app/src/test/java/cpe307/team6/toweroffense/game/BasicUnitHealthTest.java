package cpe307.team6.toweroffense.game;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

// Ian Watts
public class BasicUnitHealthTest {
   @Test
   public void testGetDistance() {
      BasicUnit testUnit = new BasicUnit(asList(new Location(0,0), new Location(0,1)));
      testUnit.takeDamage(5);

      assertEquals(995, testUnit.getHealth());
   }
}