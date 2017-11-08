import java.util.List;

public interface Unit {
   public Location move(List<Location>);
   public Location getLocation();
   public int getAttack();
   public boolean takeDamage(int);
}
