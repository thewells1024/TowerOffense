package cpe307.team6.toweroffense.game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LocationTest {
   @Test
   public void testGetDistance() {
      final Location loc1 = new Location(0, 3);
      final Location loc2 = new Location(4, 0);

      assertEquals(5, loc1.getDistance(loc2), .01);
   }
}
