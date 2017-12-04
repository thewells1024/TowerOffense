package com.cpe307.group6.toweroffense.game;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

// Ian Watts
@RunWith(Suite.class)
@SuiteClasses({ BasicUnitHealthTest.class, BasicUnitNegativeXTest.class, BasicUnitNegativeYTest.class,
   BasicUnitPositiveXTest.class, BasicUnitPositiveYTest.class, BasicUnitShortPathTest.class })
public class AllBasicUnitTestSuite {

}
