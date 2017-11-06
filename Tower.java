import java.lang.*;

/*
* Interface for Towers
* Interfaces are implicitly abstract, public
*/

public enum Priority {
	DISTANCE, HEALTH
};

public interface Tower{

	/* Return a target unit using another custom priority.
	* switch (p) {
		case DISTANCE: {
			//do stuff
			break;
		} 
		case HEALTH {
			//do stuff
			break;
		}
		default: {
			break;
		}
	}
	*/
	public Unit selectTargetByPriority(ArrayList<Unit> units, Priority p);


	/* Attack a targeted unit with a particular weapon.
	*/
	public void attackUnit(Unit unit);
}