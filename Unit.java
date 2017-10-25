
import java.lang.*;

public interface Unit {
	public void attack(int id, int target);
	public void move(int id, int x, int y);
	public void spawn(int health, int attack, int speed, int type, int id, int x, int y);
	public void remove(int id);
}
