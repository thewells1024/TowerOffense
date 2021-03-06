package com.cpe307.group6.toweroffense.game;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;

public class BaseTakeDamageTest {
   @Test
   public void testTakeDamage() {
      Base base = new Base(300, new Location(0,0), Collections.<Location>emptyList());
      assertEquals(200, base.takeDamage(100));
   }

   @Test
   public void testTakeDamageLargerThanHealth() {
      Base base = new Base(300, new Location(0,0), Collections.<Location>emptyList());
      assertEquals(0, base.takeDamage(400));
   }
}
