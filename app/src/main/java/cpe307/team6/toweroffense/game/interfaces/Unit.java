package cpe307.team6.toweroffense.game.interfaces;

import cpe307.team6.toweroffense.game.Location;

import java.util.List;

public interface Unit {
   public Location move(List<Location> path);
   public Location getLocation();
   public int getAttack();
   public boolean takeDamage(int amount);
}
