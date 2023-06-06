package com.epam.biaseda.reportportaltest.ui.selenide.util;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import java.util.Arrays;
import java.util.List;

public class CustomWebDriverEventListener implements WebDriverListener {

    private static final CustomLogger log = CustomLoggerProvider.getLogger();

    public void afterClick(WebElement element) {
        log.debug(String.format("Element with text '%s' was clicked", element.getText()));
    }

    public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
        log.debug(String.format("Text '%s' was entered", Arrays.toString(keysToSend)));
    }

    public void afterFindElement(WebElement element, By locator, WebElement result) {
        log.debug(String.format("Element by locator '%s' was '%s'", locator.toString(),
                result.isDisplayed() ? "found" : "not found"));
    }

    public void afterFindElements(WebElement element, By locator, List<WebElement> result) {
        log.debug(String.format("Elements by locator '%s' were '%s'", locator.toString(),
                result.size() > 0 ? "found" : "not found"));
    }
}
