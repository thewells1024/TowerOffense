import java.lang.*;

/*
* Interface for Towers
* Interfaces are implicitly abstract, public
*/

public interface Tower {

	/* Return a target unit using another custom priority.
	*/
	public Unit selectTargetByPriority(Tower tower);


	/* Return a target unit based on which unit is the shortest distance away.
	*/
	public Unit selectTargetByDistance(Tower tower);


	/* Return a target unit based on which unit has the lowest health.
	*/
	public Unit selectTargetByLowestHealth(Tower tower);


	/* Attack a targeted unit with a particular weapon.
	*/
	public void attackUnit(Tower tower, Unit unit, Weapon weapon);
}

/* Use this interface by creating a class like: 
* public class MassiveTower implements Tower {
	public MassiveTower() {
		super();
	}

	public Unit selectTargetByPriority(Tower tower) {
		...
		return unit;
	}
	...
	  ...
	    ...
  }
*/
