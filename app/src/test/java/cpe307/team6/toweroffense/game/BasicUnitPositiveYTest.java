package cpe307.team6.toweroffense.game;

import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BasicUnitPositiveYTest {
   @Test
   public void testPositiveY() {
      Location ending = null;
      List path = new ArrayList();
      path.add(new Location(1, 1));
      path.add(new Location(1, 2));
      path.add(new Location(1, 3));

      BasicUnit testUnit = new BasicUnit(path, new Location(1, 1), 1000);

      for (int i = 0; i < 20; i++) {
         ending = testUnit.move();
      }

      assertEquals(3, ending.getY());
   }
}