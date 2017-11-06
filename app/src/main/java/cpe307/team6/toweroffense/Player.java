/* Interface for Players (Bots/Humans) 
 * Not implemented yet, just using to figure out pull requests
 */

public interface Player{

   public double getWinRatio();

   public int getLosses();

   public String getUsername();

   public int getWins();

   public void addResult(int gameResult);
}
