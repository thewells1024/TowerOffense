package com.cpe307.group6.toweroffense.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

// Ian Watts
public class BasicUnitPositiveXTest {
   @Test
   public void testPositiveX() {
      Location ending = null;
      List path = new ArrayList();
      path.add(new Location(1, 1));
      path.add(new Location(2, 1));
      path.add(new Location(3, 1));

      BasicUnit testUnit = new BasicUnit(path);

      ending = testUnit.move();

      assertEquals(1.1, ending.getX(), .01);
   }
}