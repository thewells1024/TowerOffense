package com.cpe307.group6.toweroffense.game;

import com.cpe307.group6.toweroffense.game.interfaces.Tower;
import com.cpe307.group6.toweroffense.game.interfaces.Unit;

import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// Kent Kawahara
public class GameLogicTest {
   @Test
   public void testAttackUnits() {
      Game game = mock(Game.class);
      List<Location> path = asList(new Location(0,0),
         new Location(0,1),
         new Location(0,2));
      GameLogic logic = new GameLogic(game);
      PlayerStatus offense = mock(PlayerStatus.class);
      Tower tower = mock(Tower.class);
      List<Tower> towers = Collections.singletonList(tower);
      when(offense.getTowers()).thenReturn(towers);
      Unit unit = new BasicUnit(path);
      List<Unit> units = Collections.singletonList(unit);
      when(tower.selectTargets(units)).thenReturn(units);
      when(tower.getDamage()).thenReturn(50);
      PlayerStatus defense = mock(PlayerStatus.class);
      when(defense.getUnits()).thenReturn(units);
      logic.attackUnits(offense, defense);
      assertEquals(950, unit.getHealth());
   }

   @Test
   public void testMoveUnits() {
      Game game = mock(Game.class);
      List<Location> path = asList(new Location(0,0),
         new Location(0,1),
         new Location(0,2));
      GameLogic logic = new GameLogic(game);
      PlayerStatus offense = mock(PlayerStatus.class);
      Base base = new Base(100, new Location(0,2), path);
      Unit unit = mock(Unit.class);
      List<Unit> units = Collections.singletonList(unit);
      PlayerStatus defense = mock(PlayerStatus.class);
      when(unit.move()).thenReturn(new Location(0,2));
      when(unit.getAttack()).thenReturn(5);
      when(offense.getUnits()).thenReturn(units);
      when(defense.getBase()).thenReturn(base);
      logic.moveUnits(offense, defense);
      assertEquals(95, base.getHealth());
   }
}
