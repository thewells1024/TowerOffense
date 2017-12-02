package cpe307.team6.toweroffense.game.interfaces;

import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

import cpe307.team6.toweroffense.game.Location

import lombok.Getter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SingleTargetTower implements Tower {
   private final static int ATTACK_DISTANCE = 5;
   private final static int DAMAGE = 50;

   private final List<Location> path;
   @Getter private final Location location;

   private Priority priority;

   public List<Unit> selectTargetByPriority(final List<Unit> units){
      switch(this.priority){
         case DISTANCE:
            return selectClosestTarget(units);
         case HEALTH:
            return selectHealthiestTarget(units);
         case FIRST:
            return selectFirstTarget(units);
         case LAST:
            return selectLastTarget(units);
      }
   }


   public List<Unit> selectLastTarget(final List<Unit> units){
      Unit returnedUnit = null;
      double maxDistance = Integer.MIN_VALUE;
      for(Unit unit: units) {
         double distance = distanceToBase(unit.getLocation());
         double towerDistance = unit.getLocation().getDistance(this.location);
         if(towerDistance <= ATTACK_DISTANCE
            && distance > maxDistance){

            returnedUnit = unit;
            maxDistance = distance;
         }
      }
      return returnedUnit != null ? Collections.singletonList(unit) :
         new ArrayList<>();
   }

   public List<Unit> selectFirstTarget(final List<Unit> units){
      Unit returnedUnit = null;
      double minDistance = Integer.MAX_VALUE;
      for(Unit unit: units) {
         double distance = distanceToBase(unit.getLocation());
         double towerDistance = unit.getLocation().getDistance(this.location);
         if(towerDistance <= ATTACK_DISTANCE
            && distance < minDistance){

            returnedUnit = unit;
            minDistance = distance;
         }
      }
      return returnedUnit != null ? Collections.singletonList(unit) :
         new ArrayList<>();
   }

   public List<Unit> selectClosestTarget(final List<Unit> units){
      Unit returnedUnit = null;
      double minDistance = Integer.MAX_VALUE;
      for(Unit unit : units){
         double distance = unit.getLocation().getDistance(this.location);
         if(distance <= ATTACK_DISTANCE && distance < minDistance) {
            returnedUnit = unit;
            minDistance = distance;
         }
      }
      return returnedUnit != null ? Collections.singletonList(unit) :
         new ArrayList<>();
   }

   public List<Unit> selectHealthiestTarget(final List<Unit> units){
      Unit returnedUnit = null;
      int maxHealth = 0;
      for(Unit unit : units){
         double distance = unit.getLocation().getDistance(this.location);
         int curHealth = unit.getHealth();
         if(distance <= ATTACK_DISTANCE && curHealth > maxHealth) {
            returnedUnit = unit;
            maxHealth = health;
         }
      }
      return returnedUnit != null ? Collections.singletonList(unit) :
         new ArrayList<>();
   }

   private double distanceToBase(Location loc){
      int index = path.size() - 1;
      Location pathLoc = new Location((int)(loc.getx()),
         (int)(loc.gety())); 
      int unitIndex = path.indexOf(pathLoc);
      return (index - unitIndex) - loc.getDistance(pathLoc);
   }
}
