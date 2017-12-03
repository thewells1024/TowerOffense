package cpe307.team6.toweroffense.game;

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Arrays;
import cpe307.team6.toweroffense.game.*;
import cpe307.team6.toweroffense.game.Location;
import cpe307.team6.toweroffense.game.AOETower;
import cpe307.team6.toweroffense.game.interfaces.Tower;
import cpe307.team6.toweroffense.game.interfaces.Unit;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AOETowerTest {
    private Tower.Priority priority;
    private int x, y;
    private Location loc;
    Unit unit1, unit2, unit3;
    @Before
    public void setup() {
        priority = Tower.Priority.HEALTH;
        x = 3;
        y = 4;
        loc = new Location(x, y);
        unit1 = mock(Unit.class);
        unit2 = mock(Unit.class);
        unit3 = mock(Unit.class);
    }

    @Test
    public void testAOETowerConstructor() {
        AOETower testTower = new AOETower(loc, priority);
        assertEquals(testTower.loc.getX(), x, .005);
        assertEquals(testTower.loc.getY(), y, .005);
        assertEquals(testTower.getPriority(), priority);
    }

    @Test
    public void testAOETowerDefaultPriority() {
        AOETower testTower = new AOETower(loc);
        assertEquals(testTower.getPriority(), Tower.Priority.DISTANCE);
    }

    @Test
    public void testAOETowerSetPriority() {
        Tower.Priority newPriority = Tower.Priority.FIRST;
        AOETower testTower = new AOETower(loc);
        assertNotEquals(testTower.getPriority(), newPriority);
        testTower.setPriority(newPriority);
        assertEquals(testTower.getPriority(), newPriority);
    }

    @Test
    public void testAOETowerSelectTargetsByHealthOfEqual() {
        when(unit1.getHealth()).thenReturn(10);
        when(unit2.getHealth()).thenReturn(6);
        when(unit3.getHealth()).thenReturn(6);

        List<Unit> units = Arrays.asList(unit1, unit2, unit3);
        AOETower testTower = new AOETower(loc);
        testTower.setPriority(Tower.Priority.HEALTH);
        assertEquals(testTower.selectTargets(units).get(0).getHealth(),
                unit2.getHealth());
    }

    @Test
    public void testAOETowerSelectTargetsByHealthOfThree() {
        when(unit1.getHealth()).thenReturn(10);
        when(unit2.getHealth()).thenReturn(6);
        when(unit3.getHealth()).thenReturn(8);
        List<Unit> units = Arrays.asList(unit1, unit2, unit3);

        AOETower testTower = new AOETower(loc);
        testTower.setPriority(Tower.Priority.HEALTH);

        assertEquals(testTower.selectTargets(units).get(0).getHealth(),
                unit2.getHealth());
    }

    @Test
    public void testAOETowerSelectTargetsByDistance() {
        AOETower testTower = new AOETower(loc);
        when(unit1.getLocation()).thenReturn(new Location(0, 0));
        when(unit1.getHealth()).thenReturn(1);

        when(unit2.getLocation()).thenReturn(new Location(2, 3));
        when(unit2.getHealth()).thenReturn(2);
        List<Unit> units = Arrays.asList(unit1, unit2);

        testTower.setPriority(Tower.Priority.DISTANCE);

        assertEquals(testTower.selectTargets(units).get(0).getHealth(), unit2.getHealth());
    }
}

