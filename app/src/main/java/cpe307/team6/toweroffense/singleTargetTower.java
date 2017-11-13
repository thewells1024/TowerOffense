/* design taken from the not-yet-pulled tower interface */

import java.util.ArrayList;

public class singleTargetTower implements Tower {

   private Location location;
   private int attackDistance;
   private int damage;
   private Unit target;

   public singleTargetTower(Location location, int attackDistance, int damage){
      this.location = location;
      this.attackDistance = attackDistance;
      this.damage = damage;
      target = null
   }

   public Location getLocation(){
      return location;
   }

   public void selectTarget(ArrayList<Unit> units){
      for(Unit u : units){
         if(u.getLocation().getDistance(this.location) < attackDistance){
            target = u;
            return;
         }
      }
   }

   public void attackUnit(Unit unit){
      unit.takeDamage(damage);
   }
}
