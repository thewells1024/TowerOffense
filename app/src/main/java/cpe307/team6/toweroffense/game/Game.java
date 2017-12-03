package cpe307.team6.toweroffense.game;

import static java.util.Arrays.stream;

import cpe307.team6.toweroffense.game.interfaces.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class Game {
   private static final int STARTING_HEALTH = 1000;

   private final Map map;
   @Getter(AccessLevel.NONE)
   private final PlayerStatus[] playerStatuses = new PlayerStatus[2];

   public Game(final Player player1, final Player player2, final Map map, final List<Location> path) {
      this.map = map;
      playerStatuses[0] = new PlayerStatus(player1, new Base(STARTING_HEALTH, path.get(0), path),
         new ArrayList<>(), new ArrayList<>(), Result.IN_PROGRESS);
      final List<Location> flippedPath = new ArrayList<>(path);
      Collections.reverse(flippedPath);
      playerStatuses[1] = new PlayerStatus(player2, new Base(STARTING_HEALTH, flippedPath.get(0), flippedPath),
         new ArrayList<>(), new ArrayList<>(), Result.IN_PROGRESS);
   }

   public PlayerStatus getPlayerStatus(final Player player) {
      return stream(playerStatuses).
         filter(playerStatus ->
            playerStatus.getPlayer().getUsername().equals(player.getUsername())).
         findFirst().
         orElse(null);
   }
}
