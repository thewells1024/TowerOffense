package com.cpe307.group6.toweroffense.game;

import static org.junit.Assert.assertEquals;

import com.cpe307.group6.toweroffense.game.interfaces.Tower;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Annamarie Roger on 12/3/17.
 */

public class AOETowerPriorityTest {
   private Location loc;
   private int x, y;

   @Before
   public void setup() {
      loc = new Location(x, y);
   }

   @Test
   public void testAOETowerDefaultPriority() {
      AOETower testTower = new AOETower(loc);
      assertEquals(testTower.getPriority(), Tower.Priority.DISTANCE);
   }

   @Test
   public void testAOETowerSetPriority() {
      Tower.Priority newPriority = Tower.Priority.FIRST;
      AOETower testTower = new AOETower(loc);
      testTower.setPriority(newPriority);
      assertEquals(testTower.getPriority(), newPriority);
   }
}
