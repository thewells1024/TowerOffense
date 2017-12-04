package com.cpe307.group6.toweroffense.game;

import static java.util.Arrays.copyOf;
import static java.util.Arrays.stream;

import com.cpe307.group6.toweroffense.game.interfaces.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import android.os.Handler;
import android.os.Message;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class Game {
   public enum GameLogicState {
      RUNNING,
      ENDED
   }

   private static final String TAG = "GAME";
   private static final int CORE_POOL_SIZE = 8;
   private static final int MAXIMUM_POOL_SIZE = 8;
   private static final long KEEP_ALIVE_TIME = Long.MAX_VALUE;
   private static final TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;

   private static final int STARTING_HEALTH = 1000;
   private static final int MAX_PLAYERS = 2;

   private final Map map;
   private final PlayerStatus[] playerStatuses = new PlayerStatus[MAX_PLAYERS];
   @Getter(AccessLevel.NONE)
   private final GameLogic logic;
   @Getter(AccessLevel.NONE)
   private final Handler mainHandler;

   public Game(final Player player1, final Player player2, final Map map, final List<Location> path,
      final Handler mainHandler) {
      this.map = map;
      playerStatuses[0] = new PlayerStatus(player1, new Base(STARTING_HEALTH, path.get(0), path),
         new ArrayList<>(), new ArrayList<>(), Result.IN_PROGRESS);
      final List<Location> flippedPath = new ArrayList<>(path);
      Collections.reverse(flippedPath);
      playerStatuses[1] = new PlayerStatus(player2, new Base(STARTING_HEALTH, flippedPath.get(0), flippedPath),
         new ArrayList<>(), new ArrayList<>(), Result.IN_PROGRESS);
      logic = new GameLogic(this);
      logic.setRunning(true);
      this.mainHandler = mainHandler;
      final BlockingQueue<Runnable> logicRunner = new LinkedBlockingQueue<>();
      final ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE,
         KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT, logicRunner);
      executor.execute(logic);
   }

   public PlayerStatus[] getPlayerStatuses() {
      return copyOf(playerStatuses, MAX_PLAYERS);
   }

   public boolean isOver() {
      return stream(playerStatuses).anyMatch(status -> status.getBase().isDead());
   }

   public void end() {
      if (!isOver()) {
         return;
      }
      if (stream(playerStatuses).allMatch(status -> status.getBase().isDead())) {
         for (PlayerStatus status: playerStatuses) {
            status.setResult(Result.TIE);
         }
      } else {
         if (playerStatuses[0].getBase().isDead()) {
            playerStatuses[0].setResult(Result.LOSE);
            playerStatuses[1].setResult(Result.WIN);
         } else {
            playerStatuses[0].setResult(Result.WIN);
            playerStatuses[1].setResult(Result.LOSE);
         }
      }
   }

   public void handleLogicState(final GameLogicState state) {
      final Message completeMessage = mainHandler.obtainMessage(state.ordinal(), this);
      completeMessage.sendToTarget();
   }
}
