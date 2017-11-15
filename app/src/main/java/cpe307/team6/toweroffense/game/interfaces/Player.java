package cpe307.team6.toweroffense.game.interfaces;

public interface Player{

   public String getUsername();

   public int getLosses();

   public int getWins();

   public double getWinRatio();

   public void addResult(int gameResult);
}
