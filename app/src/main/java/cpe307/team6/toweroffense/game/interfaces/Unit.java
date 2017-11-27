package cpe307.team6.toweroffense.game.interfaces;

import cpe307.team6.toweroffense.game.Location;

import java.util.List;

public interface Unit {
   Location move(List<Location> path);
   Location getLocation();
   int getAttack();
   boolean takeDamage(int amount);
}
