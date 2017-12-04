package cpe307.team6.toweroffense.game;

import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MapTest {
   @Test
   public void testCreateMap() {
      List<List<Map.Tile>> createdMap = Map.createMap(2, 2, asList(new Location(0,0),
         new Location(0,1)));
      assertEquals(2, createdMap.size());
      createdMap.forEach(row -> assertEquals(2, row.size()));
      assertFalse(createdMap.get(0).get(0).canHoldTower());
      assertFalse(createdMap.get(0).get(1).canHoldTower());
      assertTrue(createdMap.get(1).get(0).canHoldTower());
      assertTrue(createdMap.get(1).get(1).canHoldTower());
   }
}
