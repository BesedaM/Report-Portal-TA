package com.epam.biaseda.reportportaltest.ui.cucumber.runner.listener;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.ui.driver.WebDriverContainer;
import com.epam.biaseda.reportportaltest.ui.util.ScreenshotTaker;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.TestNGException;

import java.io.IOException;

import static io.cucumber.plugin.event.Status.FAILED;

public class CucumberTestListener implements ConcurrentEventListener {

    private static final CustomLogger log = CustomLoggerProvider.getLogger();

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestCaseFinished.class, this::onScenarioFinished);
        eventPublisher.registerHandlerFor(TestCaseStarted.class, this::onScenarioStarted);
    }

    public void onScenarioFinished(TestCaseFinished event) {
        TestCase testCase = event.getTestCase();
        Result result = event.getResult();
        Status status = result.getStatus();
        if (status.is(FAILED)) {
            log.error(String.format("Scenario '%s' failed!", testCase.getName()));
            log.error(ExceptionUtils.getStackTrace(result.getError()));

            try {
                ScreenshotTaker.takeScreenshot();
            } catch (IOException e) {
                throw new TestNGException("Unable to take screenshot!");
            }
        }
        WebDriverContainer.quitDriver();
    }

    public void onScenarioStarted(TestCaseStarted event){
        WebDriverContainer.launchDriver();
    }
}
