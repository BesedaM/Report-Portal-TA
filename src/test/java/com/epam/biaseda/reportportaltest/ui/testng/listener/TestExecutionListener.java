package com.epam.biaseda.reportportaltest.ui.testng.listener;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.ui.driver.WebDriverHolder;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestNGException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestExecutionListener implements ITestListener {

    private static final CustomLogger log = CustomLoggerProvider.getLogger();

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        log.error(String.format("Test '%s' failed!", iTestResult.getMethod().getConstructorOrMethod().getName()));
        log.error(ExceptionUtils.getStackTrace(iTestResult.getThrowable()));

        try {
            takeScreenshot();
        } catch (IOException e) {
            throw new TestNGException("Unable to take screenshot!");
        }
    }

    private void takeScreenshot() throws IOException {
        File screenshot = ((TakesScreenshot) WebDriverHolder.getWebDriver()).getScreenshotAs(OutputType.FILE);

        String timeString = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss").format(LocalDateTime.now());
        String pathString = Paths.get(".", "/target/screenshot/" + timeString + ".png").toAbsolutePath().toString();

        File newFile = new File(pathString);
        FileUtils.copyFile(screenshot, newFile);
        log.error(String.format("Screenshot %s was taken", newFile.getPath()));
    }
}
