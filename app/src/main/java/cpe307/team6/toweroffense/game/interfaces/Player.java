package cpe307.team6.toweroffense.game.interfaces;

public interface Player {
   String getUsername();
   int getLosses();
   int getWins();
   double getWinRatio();
   void addResult(int gameResult);
}
