package cpe307.team6.toweroffense;

import org.junit.Test;
import java.util.ArrayList;
import cpe307.team6.toweroffense.game.interfaces.Unit;
import cpe307.team6.toweroffense.game.interfaces.Tower;
import cpe307.team6.toweroffense.game.Unit;
import cpe307.team6.toweroffense.game.SingleTargetTower;

import static org.junit.Assert.*;

public class SingleTargetTowerTest {
    @Test
    public void test_SelectHealthiest(){
        ArrayList<Unit> units = new ArrayList();
        Unit unit1 = new basicUnit();
        Unit unit2 = new basicUnit();
        units.add(unit1);
        units.add(unit2);
        Location place = new Location(0, 0);
        SingleTargetTower tower = new SingleTargetTower(0, 0, null, place, HEALTH);
        assertEquals(unit1, tower.selectHealthiestTarget(units));
    }

}
