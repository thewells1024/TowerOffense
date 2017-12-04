package cpe307.team6.toweroffense.game;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import cpe307.team6.toweroffense.game.players.EasyBot;
import cpe307.team6.toweroffense.game.interfaces.Player;
import cpe307.team6.toweroffense.game.interfaces.Tower;
import cpe307.team6.toweroffense.game.interfaces.Unit;
import cpe307.team6.toweroffense.game.Location;
import cpe307.team6.toweroffense.game.BasicUnit;
import cpe307.team6.toweroffense.game.Result;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Created by Annamarie Roger on 12/3/17.
 */

public class PlayerStatusUnitIntegrationTest {
   Unit unit1, unit2, unit3;
   Location loc1, loc2, loc3, loc4, loc5, loc6;
   List path1, path2;
   PlayerStatus playerStatus;
   Tower tower;
   Base base;
   Player player;

   @Before
   public void setup() {
      loc1 = new Location(0, 0);
      loc2 = new Location(0, 0);
      loc3 = new Location(0, 0);
      loc4 = new Location(0, 0);
      loc5 = new Location(0, 0);
      loc6 = new Location(0, 0);

      path1 = new ArrayList<Location>();
      path1.add(loc1);
      path1.add(loc2);
      path1.add(loc3);

      path2 = new ArrayList<Location>();
      path2.add(loc4);
      path2.add(loc5);
      path2.add(loc6);
      unit1 = new BasicUnit(path1);
      unit2 = new BasicUnit(path2);

      player = mock(EasyBot.class);
      base = mock(Base.class);
      tower = mock(Tower.class);

      playerStatus = new PlayerStatus(player, base, Arrays.asList(unit1), Arrays.asList(tower), Result.TIE);
   }

   public void testPlayerStatusAddUnits() {
      boolean success1 = false;
      success1 = playerStatus.addUnits(unit1);
      assertTrue(success1);
      assertEquals(playerStatus.getUnits().size(), path1.size() + path2.size());

   }

}
