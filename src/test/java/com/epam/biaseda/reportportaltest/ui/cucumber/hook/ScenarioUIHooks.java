package com.epam.biaseda.reportportaltest.ui.cucumber.hook;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.ui.cucumber.runner.TestContext;
import com.epam.biaseda.reportportaltest.ui.driver.WebDriverContainer;
import com.epam.biaseda.reportportaltest.ui.util.ScreenshotTaker;
import com.google.common.base.Stopwatch;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.testng.TestNGException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScenarioUIHooks {

    private static CustomLogger log = CustomLoggerProvider.getLogger();

    private static final ThreadLocal<Stopwatch> TIMER = new ThreadLocal<>();

    @Before
    public void beforeScenario() {
        TIMER.set(Stopwatch.createStarted());
        WebDriverContainer.launchDriver();
    }

    @After(order = 1)
    public void resetTestContext() {
        TestContext.getInstance().reset();
    }

    @After(order = 2)
    public void afterScenario(Scenario scenario) {
        log.info(String.format("Execution of scenario '%s' took %d ms", scenario.getName(),
                TIMER.get().elapsed(TimeUnit.MILLISECONDS)));
        WebDriverContainer.quitDriver();
    }

    @After(order = 3)
    public void takeScreenshotIfFailed(Scenario scenario) {
        if (scenario.isFailed()) {
            log.error(String.format("Scenario '%s' failed!", scenario.getName()));

            try {
                ScreenshotTaker.takeScreenshot();
            } catch (IOException e) {
                throw new TestNGException("Unable to take screenshot!");
            }
        }
    }
}
