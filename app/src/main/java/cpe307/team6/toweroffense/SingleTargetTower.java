/* design taken from the not-yet-pulled tower interface */

import java.util.List;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class SingleTargetTower implements Tower {

   @Getter private final Location location;
   private final static int attackDistance;
   private final static int damage;

   /* returns the first unit in the list that is within the tower's range */
   public Unit selectTargetByPriority(List<Unit> units){
	   /* assuming this list is organized by priority already */
	   for(Unit unit: units) {
		   if(unit.getLocation().getDistance(this.location) < attackDistance) {
			   	return unit;
		   }
	   }
   }

}
