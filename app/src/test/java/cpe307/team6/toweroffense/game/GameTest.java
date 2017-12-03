package cpe307.team6.toweroffense.game;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import cpe307.team6.toweroffense.game.interfaces.Player;

import java.util.List;

import org.junit.Test;

public class GameTest {
   @Test
   public void testGetPlayerStatus() {
      final List<Location> path = asList(new Location(0,0), new Location(0,1));
      Map map = new Map(2, 2, path);
      Player player1 = mock(Player.class);
      when(player1.getUsername()).thenReturn("Alice");
      Player player2 = mock(Player.class);
      when(player2.getUsername()).thenReturn("Bob");
      Game game = new Game(player1, player2, map, path);
   }
}
