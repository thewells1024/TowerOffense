package com.cpe307.group6.toweroffense.game;

import static java.lang.Thread.sleep;
import static java.util.Arrays.stream;

import com.cpe307.group6.toweroffense.game.factories.TowerFactory;
import com.cpe307.group6.toweroffense.game.interfaces.Bot;
import com.cpe307.group6.toweroffense.game.interfaces.Unit;

import android.util.Log;

import lombok.Setter;

public class GameLogic implements Runnable {
   private static final String TAG = "GAME_THREAD";
   private static final int NANO_TO_MILLI = 1000000;
   private static final int WAIT_TIME_BOUND = 33;
   private static final int UNIT_CREATION_INTERVAL = 60;

   @Setter
   private boolean running;
   private Game game;
   private int counter = 0;

   public GameLogic(final Game game) {
      this.game = game;
   }

   @Override
   public void run() {
      Log.i(TAG, "begin running");
      while (running) {
         counter = (counter + 1) % UNIT_CREATION_INTERVAL;
         if (counter == 0) {
            stream(game.getPlayerStatuses()).
               forEach(status -> status.addUnits(new BasicUnit(status.getBase().getPath())));
         }
         final long startTime = System.nanoTime();

         final PlayerStatus[] statuses = game.getPlayerStatuses();
         attackUnits(statuses[0], statuses[1]);
         attackUnits(statuses[1], statuses[0]);
         moveUnits(statuses[0], statuses[1]);
         moveUnits(statuses[1], statuses[0]);
         placeTowers(statuses);
         if (game.isOver()) {
            game.end();
            running = false;
            game.handleLogicState(Game.GameLogicState.ENDED);
         } else {
            game.handleLogicState(Game.GameLogicState.RUNNING);
            final long now = System.nanoTime();
            long waitTime = (now - startTime) / NANO_TO_MILLI;

            if (waitTime < WAIT_TIME_BOUND) {
               waitTime = WAIT_TIME_BOUND;
            }

            try {
               sleep(waitTime);
            } catch (InterruptedException except) {
               Log.e(TAG, except.toString());
               Thread.currentThread().interrupt();
            }
         }
      }
      Log.i(TAG, "end running");
   }

   public void attackUnits(final PlayerStatus offense, final PlayerStatus defense) {
      offense.getTowers().forEach(tower -> {
         tower.selectTargets(defense.getUnits()).
            forEach(unit -> unit.takeDamage(tower.getDamage()));
         defense.removeInvalidUnits();
      });
   }

   public void moveUnits(final PlayerStatus offense, final PlayerStatus defense) {
      for (Unit unit : offense.getUnits()) {
         System.out.println("Moving Unit");
         if (unit.move().equals(defense.getBase().getLocation())) {
            defense.getBase().takeDamage(unit.getAttack());
         }
      }
      offense.removeInvalidUnits();
   }

   public void placeTowers(final PlayerStatus[] statuses) {
      for (PlayerStatus status : statuses) {
         if (status.getPlayer() instanceof Bot) {
            final Bot bot = (Bot) status.getPlayer();
            if (bot.shouldPlaceTower()) {
               final Location towerLocation = bot.getNewTowerLocation(game.getMap());
               status.addTowers(TowerFactory.getInstance().
                  createTower(TowerFactory.TowerType.SINGLE_TARGET, towerLocation));
               game.getMap().placeTowerAt(towerLocation);
            }
         }
      }
   }
}