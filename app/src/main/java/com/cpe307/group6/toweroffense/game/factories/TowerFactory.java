package com.cpe307.group6.toweroffense.game.factories;

import com.cpe307.group6.toweroffense.game.Location;
import com.cpe307.group6.toweroffense.game.SingleTargetTower;
import com.cpe307.group6.toweroffense.game.interfaces.Tower;

import java.util.List;

import lombok.NonNull;

public class TowerFactory {
   private static TowerFactory instance;

   private List<Location> path;

   private TowerFactory(final List<Location> path) {
      this.path = path;
   }

   public enum TowerType {
      SINGLE_TARGET,
      AREA_OF_EFFECT
   }

   public Tower createTower(@NonNull final TowerType type, final Location atLocation) {
      switch (type) {
         case SINGLE_TARGET:
            return new SingleTargetTower(path, atLocation, Tower.Priority.DISTANCE);
         case AREA_OF_EFFECT:
            return null;
         default:
            return null;
      }
   }

   public static synchronized void createFactory(final List<Location> path) {
      instance = new TowerFactory(path);
   }

   public static synchronized TowerFactory getInstance() {
      return instance;
   }
}
