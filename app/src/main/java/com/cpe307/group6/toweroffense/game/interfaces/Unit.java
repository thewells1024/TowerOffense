package com.cpe307.group6.toweroffense.game.interfaces;

import com.cpe307.group6.toweroffense.game.Location;

public interface Unit {
   Location move();
   Location getLocation();
   int getHealth();
   int getAttack();
   boolean takeDamage(int amount);
}
