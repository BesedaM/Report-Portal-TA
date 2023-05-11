package com.epam.biaseda.reportportaltest.ui.cucumber.hook;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.google.common.base.Stopwatch;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeStep;

import java.util.concurrent.TimeUnit;

public class StepUIHooks {

    private static final CustomLogger log = CustomLoggerProvider.getLogger();

    private static final ThreadLocal<Stopwatch> TIMER = new ThreadLocal<>();

    @BeforeStep
    public void beforeStep() {
        TIMER.set(Stopwatch.createStarted());
    }

    @AfterStep(order = 1)
    public void afterStep() {
        log.info(String.format("Execution of step took %d ms", TIMER.get().elapsed(TimeUnit.MILLISECONDS)));
    }
}
