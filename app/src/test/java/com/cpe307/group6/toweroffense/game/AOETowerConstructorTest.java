package com.cpe307.group6.toweroffense.game;

import static org.junit.Assert.assertEquals;

import com.cpe307.group6.toweroffense.game.interfaces.Tower;

import org.junit.Before;
import org.junit.Test;

public class AOETowerConstructorTest {

   private Tower.Priority priority;
   private int x, y;
   private Location loc;

   @Before
   public void setup() {
      priority = Tower.Priority.HEALTH;
      x = 3;
      y = 4;
      loc = new Location(x, y);
   }

   @Test
   public void testAOETowerConstructorPriority() {
      AOETower testTower = new AOETower(loc, priority);
      assertEquals(testTower.getPriority(), priority);
   }

   @Test
   public void testAOETowerConstructorLocationX() {
      AOETower testTower = new AOETower(loc);
      assertEquals(testTower.getLoc().getX(), x, .005);
   }

   @Test
   public void testAOETowerConstructorLocationY() {
      AOETower testTower = new AOETower(loc);
      assertEquals(testTower.getLoc().getY(), y, .005);
   }

   @Test
   public void testAOETowerConstructor() {
      AOETower testTower = new AOETower(loc);
      assertEquals(testTower.getPriority(), Tower.Priority.DISTANCE);
   }
}
