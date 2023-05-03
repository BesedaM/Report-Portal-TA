package com.epam.biaseda.reportportaltest.ui.driver;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverContainer {

    private static CustomLogger log = CustomLoggerProvider.getLogger();

    public static long TIMEOUT = 5;

    public WebDriverContainer() {
    }

    public static void launchDriver() {
        WebDriver driver = new WebDriverFactory().getDriver();

        WebDriverHolder.setWebDriver(driver);

        log.info(WebDriverHolder.getWebDriver().toString());
    }

    public static void quitDriver() {
        WebDriverHolder.removeDriver();
    }

    public static WebDriverWait getWaitDriver() {
        return new WebDriverWait(WebDriverHolder.getWebDriver(), Duration.ofSeconds(TIMEOUT));
    }
}

