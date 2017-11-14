import java.lang.Enum;
import java.util.List;

public interface Tower{

	public enum Priority {
		DISTANCE, HEALTH, FIRST, LAST
	};
	
	/*
	*	Sets priority to given priority.
	*/
	public void setPriority(Priority priority);


	/* Attack 0 or more units in the list of units
	*/
	public void attack(List<Unit> units);
}
