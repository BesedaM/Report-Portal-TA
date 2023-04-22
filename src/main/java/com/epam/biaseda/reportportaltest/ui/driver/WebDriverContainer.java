package com.epam.biaseda.reportportaltest.ui.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverContainer {

    private static final Logger log = LogManager.getRootLogger();

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

