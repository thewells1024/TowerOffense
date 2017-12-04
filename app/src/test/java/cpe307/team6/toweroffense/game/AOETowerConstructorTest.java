package cpe307.team6.toweroffense.game;

import org.junit.Before;
import org.junit.Test;

import cpe307.team6.toweroffense.game.interfaces.Tower;

import static org.junit.Assert.assertEquals;

/**
 * Created by Annamarie Roger on 12/3/17.
 */

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
      assertEquals(testTower.loc.getX(), x, .005);
   }

   @Test
   public void testAOETowerConstructorLocationY() {
      AOETower testTower = new AOETower(loc);
      assertEquals(testTower.loc.getY(), y, .005);
   }

   @Test
   public void testAOETowerConstructor() {
      AOETower testTower = new AOETower(loc);
      assertEquals(testTower.getPriority(), Tower.Priority.DISTANCE);
   }
}
