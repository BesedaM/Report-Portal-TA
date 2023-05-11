package com.epam.biaseda.reportportaltest.ui.junit.listener;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.ui.util.ScreenshotTaker;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

import java.io.IOException;

public class JunitTestExecutionListener implements TestExecutionListener {

    private static CustomLogger log = CustomLoggerProvider.getLogger();

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        log.error(String.format("Test '%s' %s!", testIdentifier.getDisplayName(), testExecutionResult.toString()));

        if (testExecutionResult.getStatus().equals(TestExecutionResult.Status.FAILED)) {
            log.error(ExceptionUtils.getStackTrace(testExecutionResult.getThrowable().get()));

            try {
                ScreenshotTaker.takeScreenshot();
            } catch (IOException e) {
                throw new JUnitException("Unable to take screenshot!");
            }
        }
    }
}
