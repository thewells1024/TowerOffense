package com.cpe307.group6.toweroffense.game.interfaces;

import com.cpe307.group6.toweroffense.game.Location;

import java.util.List;

public interface Tower {
   enum Priority {
      DISTANCE, HEALTH, FIRST, LAST
   }

   void setPriority(Priority priority);
   List<Unit> selectTargets(List<Unit> units);
   Location getLocation();
   int getDamage();
}
