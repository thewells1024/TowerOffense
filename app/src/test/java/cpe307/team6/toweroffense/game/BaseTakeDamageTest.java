package cpe307.team6.toweroffense.game;

import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

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
