
import java.util.List;

public interface Unit {
	public Location move(List<Location>);
	public Location getLocation();
	public void damage(Base);
}
