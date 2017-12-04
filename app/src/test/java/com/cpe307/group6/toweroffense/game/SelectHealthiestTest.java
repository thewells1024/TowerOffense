package com.cpe307.group6.toweroffense.game;

import static java.util.Arrays.asList;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.cpe307.group6.toweroffense.game.interfaces.Tower;
import com.cpe307.group6.toweroffense.game.interfaces.Unit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/* Chris Varanese */
public class SelectHealthiestTest {
    private List<Location> path;
    private Location location;
    private Tower.Priority priority;

    @Before
    public void setup() {
        path = asList(new Location(0,0),
                new Location(0,1),
                new Location(0,2),
                new Location(1,2),
                new Location(1,3));
        location = new Location(1,1);
    }

    @Test
    public void testSelectHealthiest(){
        priority = Tower.Priority.HEALTH;
        ArrayList<Unit> units = new ArrayList<>();
        Unit unit1 = mock(Unit.class);
        when(unit1.getLocation()).thenReturn(new Location(0,0));
        when(unit1.getHealth()).thenReturn(100);
        Unit unit2 = mock(Unit.class);
        when(unit2.getLocation()).thenReturn(new Location(0,1.3));
        when(unit2.getHealth()).thenReturn(95);
        units.add(unit1);
        units.add(unit2);
        SingleTargetTower tower = new SingleTargetTower(path, location, priority);
        List<Unit> selectedUnits = tower.selectTargets(units);
        assertTrue(selectedUnits.size() == 1 && selectedUnits.get(0).getHealth() == 100);
    }

}
