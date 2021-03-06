package com.cpe307.group6.toweroffense.game.players;

import com.cpe307.group6.toweroffense.game.Location;
import com.cpe307.group6.toweroffense.game.Map;
import com.cpe307.group6.toweroffense.game.Result;
import com.cpe307.group6.toweroffense.game.interfaces.Bot;
import com.cpe307.group6.toweroffense.game.interfaces.Player;

import java.util.Random;

import android.util.Log;

public class EasyBot implements Bot, Player {
   public static final String TAG = "EASY_BOT";
   public static final double CHANCE = .001;
   public static final int MAX_TOWERS = 4;

   private int numTowers = 0;
   private Random rng;

   public EasyBot() {
      rng = new Random();
   }

   @Override
   public String getUsername() {
      return "Easy Bot";
   }

   @Override
   public void addResult(final Result gameResult) {
      Log.i(TAG, "The bot " + gameResult.toString());
   }

   @Override
   public boolean shouldPlaceTower() {
      return rng.nextDouble() <= CHANCE && numTowers < MAX_TOWERS;
   }

   @Override
   public Location getNewTowerLocation(final Map map) {
      Location selected;
      do {
         selected = new Location(rng.nextInt(map.getWidth()), rng.nextInt(map.getHeight()));
      } while (!map.getTile(selected).canHoldTower());
      numTowers++;
      return selected;
   }
}
