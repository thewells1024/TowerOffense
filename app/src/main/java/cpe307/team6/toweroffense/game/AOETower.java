package cpe307.team6.toweroffense.game;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import cpe307.team6.toweroffense.game.Location;
import cpe307.team6.toweroffense.game.interfaces.Unit;
import cpe307.team6.toweroffense.game.interfaces.Tower;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class AOETower implements Tower {

    public Tower.Priority priority;
    public Location loc;

    public AOETower(Location loc) {
        this.priority = Tower.Priority.DISTANCE;
        this.loc = loc;
    }

    public AOETower(Location loc, Tower.Priority priority) {
        this.priority = priority;
        this.loc = loc;
    }

    private Unit getWeakestUnit(List<Unit> units, int numUnits) {
        //Assumes numUnits > 1
        Unit weakestUnit = units.get(0);
        double currentUnitHealth;
        double weakestUnitHealth = weakestUnit.getHealth();

        for (int i = 1; i < numUnits; i++) {
            currentUnitHealth = units.get(i).getHealth();
            if (currentUnitHealth < weakestUnitHealth) {
                weakestUnitHealth = currentUnitHealth;
                weakestUnit = units.get(i);
            }
        }

        return weakestUnit;
    }

    private Unit getNearestUnit(List<Unit> units, int numUnits) {
        //Assumes numUnits > 1
        Unit closestUnit = units.get(0);
        double currentUnitDistance;
        double shortestDistance = this.getLocation().getDistance(units.get(0).getLocation());

        for (int i = 1; i < numUnits; i++) {
            currentUnitDistance = this.getLocation().getDistance(units.get(i).getLocation());

            // Reset ptr to closer unit
            if (currentUnitDistance < shortestDistance) {
                closestUnit = units.get(i);
                shortestDistance = currentUnitDistance;
            }
        }

        return closestUnit;
    }

    public void setPriority(Tower.Priority priority) {
        this.priority = priority;
    }

    public Tower.Priority getPriority() {
        return this.priority;
    }

    /* Handles Priorities: DISTANCE and HEALTH
     * DISTANCE:
     *  -> Attacks Unit that is the shortest distance from this tower
     * HEALTH:
     * -> Attacks Health that is the shortest distance from this tower
     */
    public List<Unit> selectTargets(List<Unit> units) {
        Unit target = null;
        int numUnits = units.size();
        if (numUnits == 0) {
            ; //throw new Exception("No units to set as target. List of units is empty");
        }
        if (numUnits == 1) {
            target = units.get(0);
        }
        else if (this.priority == Tower.Priority.DISTANCE) {
            target = getNearestUnit(units, numUnits);
        }
        else if (this.priority == Tower.Priority.HEALTH) {
            //Find unit that has the lowest health
            target = getWeakestUnit(units, numUnits);
        }
        else if (this.priority == Tower.Priority.FIRST) {
            target = units.get(0);
        }
        else if (this.priority == Tower.Priority.LAST) {
            target = units.get(numUnits - 1);
        }

        return target != null ? Collections.singletonList(target) :
                new ArrayList<Unit>();
    }

    public Location getLocation() {
        return this.loc;
    }
}
