package com.epam.biaseda.reportportaltest.ui.junit.listener;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.ui.driver.WebDriverHolder;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.junit.platform.commons.JUnitException;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class JunitTestExecutionListener implements TestExecutionListener {

    private static CustomLogger log = CustomLoggerProvider.getLogger();

    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        log.error(String.format("Test '%s' %s!", testIdentifier.getDisplayName(), testExecutionResult.toString()));

        if (testExecutionResult.getStatus().equals(TestExecutionResult.Status.FAILED)) {
            log.error(ExceptionUtils.getStackTrace(testExecutionResult.getThrowable().get()));

            try {
                takeScreenshot();
            } catch (IOException e) {
                throw new JUnitException("Unable to take screenshot!");
            }
        }
    }

    private void takeScreenshot() throws IOException {
        File screenshot = ((TakesScreenshot) WebDriverHolder.getWebDriver()).getScreenshotAs(OutputType.FILE);

        String timeString = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss").format(LocalDateTime.now());
        String pathString = Paths.get("/target/screenshot/", timeString + ".png").toAbsolutePath().toString();

        File newFile = new File(pathString);
        FileUtils.copyFile(screenshot, newFile);
        log.error(String.format("Screenshot %s was taken", newFile.getPath()));
    }
}
