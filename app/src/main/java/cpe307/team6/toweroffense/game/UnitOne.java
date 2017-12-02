package cpe307.team6.toweroffense.game;

import cpe307.team6.toweroffense.game.Location;

import java.util.List;

public class UnitOne {
   // Location is used as a bounds check for the tile (x, y)
   // It specifies the location of the unit's  top-left corner for comparison to tiles
   private Location currentLocation;
   private int attack;
   private int health;
   
   // public Location move(List<Location> path)
   // pathing implementation pending
   
   /**
    * Simple version of the location setter.  Does not include unit pathing.
    * 
    * @param newLocation The new location for the unit
    */
   public void setLocation(Location newLocation) {
	   this.currentLocation = newLocation;
   }

   /**
    * Simple getter for the currentLocation variable.
    * 
    * @return The current (x, y) location of the unit
    */
   public Location getLocation() {
	  return this.currentLocation;
   }
   
   /**
    * Simple setter for the attack variable.
    * 
    * @param newAttack The new attack value for the unit
    */
   public void setAttack(int newAttack) {
	  this.attack = newAttack;   
   }
   
   /**
    * Simple getter for the attack variable.
    * 
    * @return The unit's attack value
    */
   public int getAttack() {
	  return this.attack;   
   }
   
   /**
    * Simple setter for the health variable.
    * 
    * @param newHealth The new health value for the unit
    */
   public void setHealth(int newHealth) {
	  this.health = newHealth;   
   }
   
   /**
    * Simple getter for the health variable.
    * 
    * @return The current health value of the unit
    */
   public int getHealth() {
      return this.health;
   }
   
   /**
    * Function for towers to apply damage to the unit.  Returns a boolean
    * to specify removal through the map.
    * 
    * @param amount The amount of damage to be dealt to the unit
    * @return Whether the unit has been killed (true) or not (false)
    */
   public boolean takeDamage(int amount) {
	  this.health -= amount;
	  // Removal function to be added for 0 health
	  return (this.health <= 0);
   }
}
