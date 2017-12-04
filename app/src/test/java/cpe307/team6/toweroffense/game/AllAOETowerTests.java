package cpe307.team6.toweroffense.game;
import cpe307.team6.toweroffense.game.AOETowerPriorityTest;
import cpe307.team6.toweroffense.game.AOETowerHealthTest;
import cpe307.team6.toweroffense.game.AOETowerDistanceTest;
import cpe307.team6.toweroffense.game.AOETowerConstructorTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Test Suite for AOETower
 * Person Responsible: Annamarie Roger
 */
@RunWith(Suite.class)
@SuiteClasses({AOETowerConstructorTest.class, AOETowerPriorityTest.class,
                    AOETowerDistanceTest.class, AOETowerHealthTest.class})
public class AllAOETowerTests {

}

