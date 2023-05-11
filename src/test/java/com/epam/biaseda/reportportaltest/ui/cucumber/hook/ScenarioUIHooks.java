package com.epam.biaseda.reportportaltest.ui.cucumber.hook;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.ui.cucumber.runner.TestContext;
import com.google.common.base.Stopwatch;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.concurrent.TimeUnit;

public class ScenarioUIHooks {

    private static CustomLogger log = CustomLoggerProvider.getLogger();

    private static final ThreadLocal<Stopwatch> TIMER = new ThreadLocal<>();

    @Before
    public void beforeScenario() {
        TIMER.set(Stopwatch.createStarted());
    }

    @After(order = 1)
    public void resetTestContext() {
        TestContext.getInstance().reset();
    }

    @After(order = 2)
    public void afterScenario(Scenario scenario) {
        log.info(String.format("Execution of scenario '%s' took %d ms", scenario.getName(),
                TIMER.get().elapsed(TimeUnit.MILLISECONDS)));
    }
}
