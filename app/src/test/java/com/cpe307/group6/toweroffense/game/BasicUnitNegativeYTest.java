package com.cpe307.group6.toweroffense.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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

      BasicUnit testUnit = new BasicUnit(path);
      ending = testUnit.move();

      assertEquals(2.9, ending.getY(), .01);
   }
}