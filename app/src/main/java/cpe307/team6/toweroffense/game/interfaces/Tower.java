import java.lang.Enum;
import java.util.List;

public interface Tower{

	public enum Priority {
		DISTANCE, HEALTH, FIRST, LAST
	};
	
	public void setPriority(Priority priority);

	public void attack(List<Unit> units);
}
