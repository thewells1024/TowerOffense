import java.util.List;
import java.util.Collections;
import java.util.ArrayList;

@AllArgsConstructor
public class SingleTargetTower implements Tower {

   @Getter private final Location location;
   private final static int attackDistance;
   private final static int damage;
   private final static Priority priority;
   private final static List<Location> path;
   private final static int player;

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

   public List<Unit> selectFirstTarget(final List<Unit> units){
      Unit returnedUnit;
      for(Unit unit: units) {
         if(returnedUnit.getLocation().getDistance(unit.getLocation())
            <= attackDistance && distanceToBase(unit.getLocation())
            > distanceToBase(returnedUnit.getLocation())){

            returnedUnit = unit;
         }
      }
      return returnedUnit != null ? Collections.singletonList(unit) :
         new ArrayList<>();
   }

   public List<Unit> selectLastTarget(final List<Unit> units){
      Unit returnedUnit;
      for(Unit unit: units) {
         if(returnedUnit.getLocation().getDistance(unit.getLocation())
            <= attackDistance && distanceToBase(unit.getLocation())
            < distanceToBase(returnedUnit.getLocation())){

            returnedUnit = unit;
         }
      }
      return returnedUnit != null ? Collections.singletonList(unit) :
         new ArrayList<>();
   }

   public List<Unit> selectClosestTarget(final List<Unit> units){
      Unit returnedUnit;
      double minDistance = Integer.MAX_VALUE;
      for(Unit unit : units){
         double distance = unit.getLocation().getDistance(this.location);
         if(distance <= attackDistance && distance < minDistance) {
            returnedUnit = unit
            minDistance = distance
         }
      }
      return returnedUnit != null ? Collections.singletonList(unit) :
         new ArrayList<>();
   }

   public List<Unit> selectHealthiestTarget(final List<Unit> units){
      Unit returnedUnit;
      int maxHealth = 0;
      for(Unit unit : units){
         double distance = unit.getLocation().getDistance(this.location);
         int curHealth = unit.getHealth()
         if(distance <= attackDistance && curHealth > maxHealth) {
            returnedUnit = unit;
            maxHealth = health;
         }
      }
      return returnedUnit != null ? Collections.singletonList(unit) :
         new ArrayList<>();
   }

   private double distanceToBase(Location loc){
      int index;
      if (player = 1){
         index = 0;
      }
      else{
         index = path.size() - 1;
      }
      Location pathLoc = new Location((int)(loc.getx()),
                                      (int)(loc.gety())); 
      int unitIndex = path.indexOf(pathLoc);
      return Math.abs(index - unitIndex) - (loc.getDistance(pathLoc);
   }
}
