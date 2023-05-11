package com.epam.biaseda.reportportaltest.ui.testng.listener;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.ui.util.ScreenshotTaker;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestNGException;

import java.io.IOException;

public class TestExecutionListener implements ITestListener {

    private static final CustomLogger log = CustomLoggerProvider.getLogger();

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.error(String.format("Test '%s' failed!", iTestResult.getMethod().getConstructorOrMethod().getName()));
        log.error(ExceptionUtils.getStackTrace(iTestResult.getThrowable()));

        try {
            ScreenshotTaker.takeScreenshot();
        } catch (IOException e) {
            throw new TestNGException("Unable to take screenshot!");
        }
    }
}
