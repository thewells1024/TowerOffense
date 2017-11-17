import java.util.List;
import java.util.ArrayList;

@AllArgsConstructor
public class SingleTargetTower implements Tower {

   @Getter private final Location location;
   private final static int attackDistance;
   private final static int damage;
   private final static List<Location> path;

   public List<Unit> selectTargetByPriority(List<Unit> units, Priority priority){
      List<Unit> returnedUnit = new ArrayList<Unit>();
      switch(priority){
         case DISTANCE:
            return selectClosestTarget(units);
         case HEALTH:
            return selectHealthiestTarget(units);
         case FIRST:
            return selectFirstTarget(units);
         case LAST:
            return selectLastTarget(units);
   }

   public List<Unit> selectFirstTarget(List<Unit> units){
      List<Unit> returnedUnit = new ArrayList<Unit>();
      for(Unit unit: units) {
         if(unit.getLocation().getDistance(this.location)
            < attackDistance) {
            
            returnedUnit.add(unit)
            return returnedUnit;
         }
      }
   }

   public List<Unit> selectLastTarget(List<Unit> units){
      List<Unit> returnedUnit = new ArrayList<Unit>();
      for(int i; i >= 0; i--){
         Unit unit = units.get(i);
         if(unit.getLocation().getDistance(this.location)
            < attackDistance) {
            
            returnedUnit.add(unit)
            return returnedUnit;
         }
      }
   }

   public List<Unit> selectClosestTarget(List<Unit> units){
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
      return returnedUnit;
   }

   public List<Unit> selectHealthiestTarget(List<Unit> units){
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
      return returnedUnit;
   }
}
