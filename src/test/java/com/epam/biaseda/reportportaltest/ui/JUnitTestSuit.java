package com.epam.biaseda.reportportaltest.ui;

import com.epam.biaseda.reportportaltest.ui.junit.VerifyLaunchStatisticsChartCriteriaTest;
import com.epam.biaseda.reportportaltest.ui.junit.VerifyProjectActivityPanelCriteriaTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@SuiteDisplayName("JUnit 5 Suit")
@Suite
@SelectClasses({VerifyLaunchStatisticsChartCriteriaTest.class, VerifyProjectActivityPanelCriteriaTest.class})
public class JUnitTestSuit {
}
