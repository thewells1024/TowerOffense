package cpe307.team6.toweroffense.game;

import cpe307.team6.toweroffense.game.interfaces.Unit;

import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
@Setter(AccessLevel.NONE)
public class UnitOne implements Unit {
   private static final int ATTACK = 5;
   private static final double SPEED = .1;

   private final List<Location> path;

   private Location currentLocation;
   private int health;

   /**
    * Function for movement along a path. Moves the unit a set distance according
    * to its speed.
    *
    * @return The current location of the unit on its path
    */
   public Location move() {
      double remainingMovement = SPEED;

      while (remainingMovement > 0) {
         final int nextIndex = path.indexOf(this.currentLocation.getPathLocation()) + 1;

         if (nextIndex >= path.size()) {
            break;
         }

         final Location nextLocation = path.get(nextIndex);
         double newX = currentLocation.getX();
         double newY = currentLocation.getY();
         double changeX = nextLocation.getX() - newX;
         double changeY = nextLocation.getY() - newY;

         if (Math.abs(changeX) > remainingMovement) {
            changeX *= (remainingMovement / Math.abs(changeX));
         }

         if (Math.abs(changeY) > remainingMovement) {
            changeY *= (remainingMovement / Math.abs(changeY));
         }

         newX += changeX;
         newY += changeY;

         currentLocation = new Location(newX, newY);
         remainingMovement -= (changeX + changeY);
      }

      return currentLocation;
   }

   public Location getLocation() {
      return this.currentLocation;
   }

   public int getAttack() {
      return ATTACK;
   }

   /**
    * Function for towers to apply damage to the unit.  Returns a boolean
    * to signal for removal from the map.
    * 
    * @param amount The amount of damage to be dealt to the unit
    * @return Whether the unit has been killed (true) or not (false)
    */
   public boolean takeDamage(final int amount) {
      this.health -= amount;
      if (health < 0) {
         this.health = 0;
      }
      // Removal function to be added for 0 health
      return (this.health == 0);
   }
}
