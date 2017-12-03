package cpe307.team6.toweroffense.game;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

// Ian Watts
public class BasicUnitNegativeYTest {
   @Test
   public void testNegativeY() {
      Location ending = null;
      List path = new ArrayList();
      path.add(new Location(1, 3));
      path.add(new Location(1, 2));
      path.add(new Location(1, 1));

      BasicUnit testUnit = new BasicUnit(path, new Location(1, 3), new Location(1, 3), 1000);

      for (int i = 0; i < 20; i++) {
         ending = testUnit.move();
      }

      assertEquals(1, ending.getY(), .01);
   }
}