package com.epam.biaseda.reportportaltest.ui.driver.action;

import com.epam.biaseda.reportportaltest.ui.driver.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.epam.biaseda.reportportaltest.ui.driver.WebDriverContainer.TIMEOUT;

public class WaitAction {

    public static WebDriverWait getWebDriverWait() {
        return getWebDriverWait(TIMEOUT);
    }

    public static WebDriverWait getWebDriverWait(long timeout) {
        return new WebDriverWait(WebDriverHolder.getWebDriver(), Duration.ofSeconds(timeout));
    }

    public static void waitUntilClickable(WebElement element) {
        getWebDriverWait()
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilInvisible(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitUntilInvisible(By by) {
        getWebDriverWait().until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void waitUntilVisible(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilVisible(By locator) {
        getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitUntilTextToBePresentInElement(WebElement element, String text) {
        getWebDriverWait().until(ExpectedConditions.textToBePresentInElement(element, text));
    }
}
