package cpe307.team6.toweroffense.game.interfaces;

import cpe307.team6.toweroffense.game.Result;

public interface Player {
   String getUsername();
   void addResult(Result gameResult);
}
