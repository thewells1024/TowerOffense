package cpe307.team6.toweroffense.game.interfaces;

import cpe307.team6.toweroffense.game.Location;
import cpe307.team6.toweroffense.game.Map;

public interface Bot {
   boolean shouldPlaceTower();
   Location getNewTowerLocation(final Map map);
}
