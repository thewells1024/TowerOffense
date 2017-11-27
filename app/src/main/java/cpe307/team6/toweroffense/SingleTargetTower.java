import java.util.List;
import java.util.Collections;

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

   public List<Unit> selectFirstTarget(final List<Unit> units){
      Unit returnedUnit;
      for(Unit unit: units) {
         if(distanceToBase(unit.getLocation())
            > distanceToBase(returnedUnit.getLocation())
            && getDistance(returnedUnit.getLocation(), unit.getLocation()
            < attackDistance) {
            returnedUnit = unit;
            
         }
      }
      return singletonList(unit);
   }

   public List<Unit> selectLastTarget(final List<Unit> units){
      Unit returnedUnit;
      for(Unit unit: units) {
         if(distanceToBase(unit.getLocation())
            > distanceToBase(returnedUnit.getLocation())
            && getDistance(returnedUnit.getLocation(), unit.getLocation()
            < attackDistance) {
            returnedUnit = unit;
         }
      }
      return singletonList(unit)
   }

   public List<Unit> selectClosestTarget(final List<Unit> units){
      List<Unit> returnedUnit = new ArrayList<Unit>();
      double minDistance = Integer.MAX_VALUE;
      for(Unit unit : units){
         double distance = unit.getLocation().getDistance(this.location);
         if(distance < attackDistance && distance < minDistance) {

            if(returnedUnit.size() == 0){
               returnedUnit.add(unit);
            }
            else{
               returnedUnit.set(0, unit);
            }
            minDistance = distance;
         }
      }
      return singletonList(returnedUnit);
   }

   public List<Unit> selectHealthiestTarget(final List<Unit> units){
      List<Unit> returnedUnit = new ArrayList<Unit>();
      int maxHealth = 0;
      for(Unit unit : units){
         double distance = unit.getLocation().getDistance(this.location);
         int curHealth = unit.getHealth()
         if(distance < attackDistance && curHealth > maxHealth) {

            if(returnedUnit.size() == 0){
               returnedUnit.add(unit);
            }
            else{
               returnedUnit.set(0, unit);
            }
            maxHealth = health;
         }
      }
      return singletonList(returnedUnit);
   }

   private double distanceToBase(Location loc){
      int index;
      if (player = 1){
         index = 0;
      }
      else{
         index = path.size() - 1;
      }
      Location pathLoc = new Location((int)loc.getx(), (int)loc.gety()); 
      int unitIndex = path.indexOf(pathLoc);
      return Math.abs(index - unitIndex);
         
   }

   private double getDistance(Location loc1, Location loc2){

      double xDist = loc1.getx() - loc2.getx();
      double yDist = loc1.gety() - loc2.gety();
      return Math.sqrt(xDist*xDist + yDist*yDist);
   }
}