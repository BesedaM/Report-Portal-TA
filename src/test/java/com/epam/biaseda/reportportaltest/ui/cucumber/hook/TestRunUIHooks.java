package com.epam.biaseda.reportportaltest.ui.cucumber.hook;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class TestRunUIHooks {

    private static final CustomLogger log = CustomLoggerProvider.getLogger();

    @BeforeAll
    public static void beforeTestRun() {
        log.info("Test suit started");
    }

    @AfterAll
    public static void afterTestRun() {
        log.info("Test suit finished");
    }
}
