package cpe307.team6.toweroffense.game.interfaces;

import cpe307.team6.toweroffense.game.Location;

public interface Unit {
   Location move();
   Location getLocation();
   int getHealth();
   int getAttack();
   boolean takeDamage(int amount);
}
