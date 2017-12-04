/* Adam is responsible for these tests*/

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class MapTest {
    @Test
    public void testCreateMap() {
        List<List<Map.Tile>> createdMap = Map.createMap(2, 2, asList(new Location(0, 0),
                new Location(0, 1)));
        createdMap.forEach(row -> assertEquals(2, row.size()));
    }

    @Test
    public void testMapCreate_2() {
        List<List<Map.Tile>> createdMap = Map.createMap(2,2,asList(new Location(0,0),
                new Location(0,1)));
        assertEquals(2, createdMap.size());
    }

    @Test
    public void testMapCreate_2() {
        List<List<Map.Tile>> createdMap = Map.createMap(2,2,asList(new Location(0,0),
                new Location(0,1)));
        assertEquals(2, createdMap.get(0).size());
    }
    
    @Test
    public void testMapCreate() {
        List<List<Map.Tile>> createdMap = Map.createMap(2,2,asList(new Location(0,0), 
                new Location(0,1)));
        assertEquals(createdMap.get(0).get(0).canHoldTower, false);
    }
    
    @Test 
    public void testMapCreate_3() {
        List<List<Map.Tile>> createdMap = Map.createMap(5,5,asList(new Location(0,0),
                new Location(0,1)));
        assertEquals(createdMap.get(1).get(0).canHoldTower, true);
    }
    @Test
    public void testMapCreate_4() {
        List<List<Map.Tile>> createdMap = Map.createMap(5,5,asList(new Location(0,0),
                new Location(0,1)));
        assertEquals(createdMap.get(1).get(1).canHoldTower, true);
    }
    
    @Test
    public void testMapCreate_5() {
        List<List<Map.Tile>> createdMap = Map.createMap(5,5,asList(new Location(0,0),
                new Location(0,1)));
        assertEquals(createdMap.get(0).get(1).canHoldTower, false);
    }
}
