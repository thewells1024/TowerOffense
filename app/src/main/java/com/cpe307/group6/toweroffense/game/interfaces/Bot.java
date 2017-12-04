package com.cpe307.group6.toweroffense.game.interfaces;

import com.cpe307.group6.toweroffense.game.Location;
import com.cpe307.group6.toweroffense.game.Map;

public interface Bot {
   boolean shouldPlaceTower();
   Location getNewTowerLocation(final Map map);
}
