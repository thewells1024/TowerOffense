package com.cpe307.group6.toweroffense.game.players;

import com.cpe307.group6.toweroffense.game.Result;
import com.cpe307.group6.toweroffense.game.interfaces.Player;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class Human implements Player {
   private final String username;

   @Setter(AccessLevel.NONE)
   private int wins;
   @Setter(AccessLevel.NONE)
   private int losses;

   @Override
   public void addResult(final Result gameResult) {
      switch (gameResult) {
         case WIN:
            wins++;
            break;
         case LOSE:
            losses++;
            break;
         default:
            break;
      }
   }

   public double getWinLossRatio() {
      return ((double) wins) / losses;
   }
}
