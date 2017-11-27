package cpe307.team6.toweroffense.game.interfaces;

import java.util.List;

public interface Tower {
   enum Priority {
      DISTANCE, HEALTH, FIRST, LAST
   }

   void setPriority(Priority priority);
   void attack(List<Unit> units);
}
