package com.cpe307.group6.toweroffense.game;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.cpe307.group6.toweroffense.game.interfaces.Tower;
import com.cpe307.group6.toweroffense.game.interfaces.Unit;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Annamarie Roger on 12/3/17.
 */

public class AOETowerHealthTest {
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
   public void testAOETowerSelectTargetsByHealthOfEqual() {
      when(unit1.getHealth()).thenReturn(10);
      when(unit2.getHealth()).thenReturn(6);
      when(unit3.getHealth()).thenReturn(6);

      List<Unit> units = Arrays.asList(unit1, unit2, unit3);
      AOETower testTower = new AOETower(loc);
      testTower.setPriority(Tower.Priority.HEALTH);
      assertEquals(testTower.selectTargets(units).get(0).getHealth(),
            unit2.getHealth());
   }

   @Test
   public void testAOETowerSelectTargetsByHealthOfThree() {
      when(unit1.getHealth()).thenReturn(10);
      when(unit2.getHealth()).thenReturn(6);
      when(unit3.getHealth()).thenReturn(8);
      List<Unit> units = Arrays.asList(unit1, unit2, unit3);

      AOETower testTower = new AOETower(loc);
      testTower.setPriority(Tower.Priority.HEALTH);

      assertEquals(testTower.selectTargets(units).get(0).getHealth(),
            unit2.getHealth());
   }
}


