package cpe307.team6.toweroffense.game;

import cpe307.team6.toweroffense.game.interfaces.Tower;
import cpe307.team6.toweroffense.game.interfaces.Unit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
public class SingleTargetTower implements Tower {
   private static final int ATTACK_DISTANCE = 5;
   private static final int DAMAGE = 50;

   private final List<Location> path;
   @Getter
   private final Location location;

   @Getter
   @Setter
   private Priority priority;

   public List<Unit> selectTargets(final List<Unit> units) {
      switch (this.priority) {
         case DISTANCE:
            return selectClosestTarget(units);
         case HEALTH:
            return selectHealthiestTarget(units);
         case FIRST:
            return selectFirstTarget(units);
         case LAST:
            return selectLastTarget(units);
         default:
            return new ArrayList<>();
      }
   }

   @Override
   public int getDamage() {
      return DAMAGE;
   }


   public List<Unit> selectLastTarget(final List<Unit> units) {
      Unit returnedUnit = null;
      double maxDistance = Integer.MIN_VALUE;
      for (Unit unit : units) {
         final double distance = distanceToBase(unit.getLocation());
         final double towerDistance = unit.getLocation().getDistance(this.location);
         if (towerDistance <= ATTACK_DISTANCE &&
            distance > maxDistance) {

            returnedUnit = unit;
            maxDistance = distance;
         }
      }
      return returnedUnit != null ? Collections.singletonList(returnedUnit) :
         new ArrayList<>();
   }

   public List<Unit> selectFirstTarget(final List<Unit> units) {
      Unit returnedUnit = null;
      double minDistance = Integer.MAX_VALUE;
      for (Unit unit : units) {
         final double distance = distanceToBase(unit.getLocation());
         final double towerDistance = unit.getLocation().getDistance(this.location);
         if (towerDistance <= ATTACK_DISTANCE &&
            distance < minDistance) {

            returnedUnit = unit;
            minDistance = distance;
         }
      }
      return returnedUnit != null ? Collections.singletonList(returnedUnit) :
         new ArrayList<>();
   }

   public List<Unit> selectClosestTarget(final List<Unit> units) {
      Unit returnedUnit = null;
      double minDistance = Integer.MAX_VALUE;
      for (Unit unit : units) {
         final double distance = unit.getLocation().getDistance(this.location);
         if (distance <= ATTACK_DISTANCE && distance < minDistance) {
            returnedUnit = unit;
            minDistance = distance;
         }
      }
      return returnedUnit != null ? Collections.singletonList(returnedUnit) :
         new ArrayList<>();
   }

   public List<Unit> selectHealthiestTarget(final List<Unit> units) {
      Unit returnedUnit = null;
      int maxHealth = 0;
      for (Unit unit : units) {
         final double distance = unit.getLocation().getDistance(this.location);
         final int curHealth = unit.getHealth();
         if (distance <= ATTACK_DISTANCE && curHealth > maxHealth) {
            returnedUnit = unit;
            maxHealth = curHealth;
         }
      }
      return returnedUnit != null ? Collections.singletonList(returnedUnit) :
         new ArrayList<>();
   }

   private double distanceToBase(final Location loc) {
      final int index = path.size() - 1;
      final Location pathLoc = new Location((int) (loc.getX()),
         (int) (loc.getY()));
      final int unitIndex = path.indexOf(pathLoc);
      return (index - unitIndex) - loc.getDistance(pathLoc);
   }
}
