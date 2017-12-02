package cpe307.team6.toweroffense.game;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import cpe307.team6.toweroffense.game.interfaces.Player;
import cpe307.team6.toweroffense.game.interfaces.Tower;
import cpe307.team6.toweroffense.game.interfaces.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PlayerStatusTest {
   private Player player;
   private Base base;
   private List<Unit> units;
   private List<Tower> towers;
   private Result result;
   private PlayerStatus playerStatus;

   @Before
   public void setup() {
      player = mock(Player.class);
      base = new Base(100, new Location(0,0), Collections.emptyList());
      units = new ArrayList<>();
      towers = new ArrayList<>();
      result = Result.IN_PROGRESS;
      playerStatus = new PlayerStatus(player, base, units, towers, result);
   }

   @Test
   public void testRemoveInvalidUnitsWithInvalidUnits() {
      Unit unit1 = mock(Unit.class);
      Unit unit2 = mock(Unit.class);
      when(unit1.getHealth()).thenReturn(0);
      when(unit2.getHealth()).thenReturn(100);
      units.addAll(asList(unit1, unit2));
      playerStatus.removeInvalidUnits();
      assertTrue(units.size() == 1 && units.get(1).getHealth() == 100);
   }

   @Test
   public void testRemoveInvalidUnitsWithoutInvalidUnits() {
      Unit unit1 = mock(Unit.class);
      Unit unit2 = mock(Unit.class);
      when(unit1.getHealth()).thenReturn(20);
      when(unit2.getHealth()).thenReturn(100);
      units.addAll(asList(unit1, unit2));
      playerStatus.removeInvalidUnits();
      assertEquals(2, units.size());
   }

   @Test
   public void testRemoveTowerWithEmpty() {
      playerStatus.removeTower(new Location(1, 1));
      assertEquals(0, towers.size());
   }

   @Test
   public void testRemoveTowerWithLocationMatch() {
      Tower tower1 = mock(Tower.class);
      Tower tower2 = mock(Tower.class);
      when(tower1.getLocation()).thenReturn(new Location(1,1));
      when(tower2.getLocation()).thenReturn(new Location(2, 7));
      towers.addAll(asList(tower1, tower2));
      playerStatus.removeTower(new Location(1, 1));
      assertEquals(1, towers.size());
   }

   @Test
   public void testRemoveTowerWithoutLocationMatch() {
      Tower tower1 = mock(Tower.class);
      Tower tower2 = mock(Tower.class);
      when(tower1.getLocation()).thenReturn(new Location(1,1));
      when(tower2.getLocation()).thenReturn(new Location(2, 7));
      towers.addAll(asList(tower1, tower2));
      playerStatus.removeTower(new Location(7, 21));
      assertEquals(2, towers.size());
   }
}
