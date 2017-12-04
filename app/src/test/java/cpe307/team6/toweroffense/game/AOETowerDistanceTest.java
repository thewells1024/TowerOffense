package cpe307.team6.toweroffense.game;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import cpe307.team6.toweroffense.game.interfaces.Tower;
import cpe307.team6.toweroffense.game.interfaces.Unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Annamarie Roger on 12/3/17.
 */

public class AOETowerDistanceTest {
   private Tower.Priority priority;
   private int x, y;
   private Location loc;
   Unit unit1, unit2, unit3;

   @Before
   public void setup() {
      priority = Tower.Priority.HEALTH;
      x = 3;
      y = 4;
      loc = new Location(x, y);
      unit1 = mock(Unit.class);
      unit2 = mock(Unit.class);
      unit3 = mock(Unit.class);
   }

   @Test
   public void testAOETowerSelectTargetsByDistance() {
      AOETower testTower = new AOETower(loc);
      when(unit1.getLocation()).thenReturn(new Location(0, 0));
      when(unit1.getHealth()).thenReturn(1);

      when(unit2.getLocation()).thenReturn(new Location(2, 3));
      when(unit2.getHealth()).thenReturn(2);
      List<Unit> units = Arrays.asList(unit1, unit2);
      testTower.setPriority(Tower.Priority.DISTANCE);

      assertEquals(testTower.selectTargets(units).get(0).getHealth(),
            unit2.getHealth());
   }

   @Test
   public void testAOETowerSelectTargetsByDistanceThree() {
      AOETower testTower = new AOETower(loc);
      when(unit1.getLocation()).thenReturn(new Location(0, 0));
      when(unit1.getHealth()).thenReturn(1);

      when(unit2.getLocation()).thenReturn(new Location(2, 3));
      when(unit2.getHealth()).thenReturn(2);

      when(unit3.getLocation()).thenReturn(new Location(10, 10));
      when(unit3.getHealth()).thenReturn(3);
      List<Unit> units = Arrays.asList(unit1, unit2);
      testTower.setPriority(Tower.Priority.DISTANCE);

      assertEquals(testTower.selectTargets(units).get(0).getHealth(),
            unit2.getHealth());
   }
}

