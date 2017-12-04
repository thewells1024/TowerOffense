package cpe307.team6.toweroffense.game;

import static org.junit.Assert.assertEquals;

import java.util.Collections;

import org.junit.Test;

/* Caleb Kim */
public class BaseGetPathTest {
   @Test
   public void getEmptyPath() {
      Base base = new Base(300, new Location(0,0), Collections.<Location>emptyList());
      assertEquals(Collections.<Location>emptyList(), base.getPath());
   }
}
