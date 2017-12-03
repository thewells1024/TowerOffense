package cpe307.team6.toweroffense.game.factories;

import cpe307.team6.toweroffense.game.Location;
import cpe307.team6.toweroffense.game.SingleTargetTower;
import cpe307.team6.toweroffense.game.interfaces.Tower;

import java.util.List;

import lombok.NonNull;

public class TowerFactory {
   private TowerFactory() { }

   public enum TowerType {
      SINGLE_TARGET,
      AREA_OF_EFFECT
   }

   public static Tower createTower(@NonNull final TowerType type, final List<Location> path,
      final Location atLocation) {
      switch (type) {
         case SINGLE_TARGET:
            return new SingleTargetTower(path, atLocation, Tower.Priority.DISTANCE);
         case AREA_OF_EFFECT:
            return null;
         default:
            return null;
      }
   }
}
