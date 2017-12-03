package cpe307.team6.toweroffense.game;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.junit.Test;


/**
 * Created by cvaranese on 12/3/17.
 */
@RunWith(Suite.class)
@SuiteClasses({ SelectClosestTest.class, SelectHealthiestTest.class, SelectFirstTest.class,
        SelectLastTest.class})
public class SingleTargetTowerSuite {

}
