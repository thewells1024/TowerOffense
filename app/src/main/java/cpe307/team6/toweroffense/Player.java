/* Interface for Players (Bots/Humans)
 * Outside of the actual game
 */

public interface Player{

   public String getUsername();

   public int getLosses();

   public int getWins();

   public double getWinRatio();

   public void addResult(int gameResult);
}
