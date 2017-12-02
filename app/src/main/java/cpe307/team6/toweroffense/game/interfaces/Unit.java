package cpe307.team6.toweroffense.game.interfaces;

import cpe307.team6.toweroffense.game.Location;

//import java.util.List;

public interface Unit {
   //Location move(List<Location> path);
   void setLocation(Location newLocation);
   Location getLocation();
   void setAttack(double newAttack);
   double getAttack();
   void setHealth(double newHealth);
   double getHealth();
   boolean takeDamage(double amount);
}
