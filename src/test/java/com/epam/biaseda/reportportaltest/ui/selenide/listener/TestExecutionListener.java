package com.epam.biaseda.reportportaltest.ui.selenide.listener;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.integration.TeamsNotificationService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selenide.screenshot;

public class TestExecutionListener implements ITestListener {

    private static final CustomLogger log = CustomLoggerProvider.getLogger();

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.error(String.format("Test '%s' failed!", iTestResult.getMethod().getConstructorOrMethod().getName()));
        log.error(ExceptionUtils.getStackTrace(iTestResult.getThrowable()));

        String timeString = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss").format(LocalDateTime.now());
        String screenshotName = screenshot(timeString);

        log.debug(String.format("Screenshot file '%s' was created", screenshotName));
    }

    @Override
    public void onStart(ITestContext context) {
        TeamsNotificationService.sendNotification(String.format("'%s' was started", context.getName()));
    }

    @Override
    public void onFinish(ITestContext context) {
        TeamsNotificationService.sendNotification(String.format("'%s' was finished", context.getName()));
    }
}
