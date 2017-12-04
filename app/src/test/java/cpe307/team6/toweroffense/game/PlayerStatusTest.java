package cpe307.team6.toweroffense.game;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import cpe307.team6.toweroffense.game.interfaces.Player;
import cpe307.team6.toweroffense.game.interfaces.Tower;
import cpe307.team6.toweroffense.game.interfaces.Unit;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
      base = new Base(100, new Location(0,0), asList(new Location(0,0),
         new Location(0,1),
         new Location(0,2),
         new Location(1,2),
         new Location(1,3)));
      units = new ArrayList<>();
      towers = new ArrayList<>();
      result = Result.IN_PROGRESS;
      playerStatus = new PlayerStatus(player, base, units, towers, result);
   }

   @Test
   public void testRemoveInvalidUnitsWithInvalidUnits() {
      Unit unit1 = mock(Unit.class);
      Unit unit2 = mock(Unit.class);
      Unit unit3 = mock(Unit.class);
      when(unit1.getHealth()).thenReturn(0);
      when(unit1.getLocation()).thenReturn(new Location(0,2));
      when(unit2.getHealth()).thenReturn(100);
      when(unit2.getLocation()).thenReturn(new Location(1,2));
      when(unit3.getHealth()).thenReturn(100);
      when(unit3.getLocation()).thenReturn(new Location(1,3));
      units.addAll(asList(unit1, unit2));
      playerStatus.removeInvalidUnits();
      final List<Unit> afterUnits = playerStatus.getUnits();
      assertTrue(afterUnits.size() == 1 && afterUnits.get(0).getHealth() == 100);
   }

   @Test
   public void testRemoveInvalidUnitsWithoutInvalidUnits() {
      Unit unit1 = mock(Unit.class);
      Unit unit2 = mock(Unit.class);
      when(unit1.getHealth()).thenReturn(20);
      when(unit1.getLocation()).thenReturn(new Location(0,2));
      when(unit2.getHealth()).thenReturn(100);
      when(unit2.getLocation()).thenReturn(new Location(1,2));
      units.addAll(asList(unit1, unit2));
      playerStatus.removeInvalidUnits();
      final List<Unit> afterUnits = playerStatus.getUnits();
      assertEquals(2, afterUnits.size());
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
      playerStatus.removeTower(tower1.getLocation());
      assertEquals(1, playerStatus.getTowers().size());
   }

   @Test
   public void testRemoveTowerWithoutLocationMatch() {
      Tower tower1 = mock(Tower.class);
      Tower tower2 = mock(Tower.class);
      when(tower1.getLocation()).thenReturn(new Location(1,1));
      when(tower2.getLocation()).thenReturn(new Location(2, 7));
      towers.addAll(asList(tower1, tower2));
      playerStatus.removeTower(new Location(7, 21));
      assertEquals(2, playerStatus.getTowers().size());
   }
}
