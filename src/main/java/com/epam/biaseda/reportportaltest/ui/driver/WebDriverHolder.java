package com.epam.biaseda.reportportaltest.ui.driver;

import org.openqa.selenium.WebDriver;

public class WebDriverHolder {

    private WebDriverHolder() {}

    private static final ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getWebDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        if (null == webDriver.get()) {
            webDriver.set(driver);
        }
    }

    public static void removeDriver() {
        if (null != webDriver.get()) {
            webDriver.get().quit();
            webDriver.remove();
        }
    }
}
