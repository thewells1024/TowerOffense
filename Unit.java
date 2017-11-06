
import java.lang.*;
import java.util.*;

public interface Unit {
	public Location move(List<Location>);
	public void damage(Base);
}
