package com.epam.biaseda.reportportaltest.ui.listener;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.ui.BaseUITest;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestExecutionListener extends BaseUITest implements ITestListener {

    private static CustomLogger log = CustomLoggerProvider.getLogger();

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.error(String.format("Test '%s' failed!", iTestResult.getMethod().getConstructorOrMethod().getName()));
        log.error(ExceptionUtils.getStackTrace(iTestResult.getThrowable()));
    }
}
