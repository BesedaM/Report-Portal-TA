package com.epam.biaseda.reportportaltest.ui.selenide.service.action;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$;

public class WaitAction {

//    public static WebDriverWait getWebDriverWait() {
//        return getWebDriverWait(TIMEOUT);
//    }
//
//    public static WebDriverWait getWebDriverWait(long timeout) {
//        return new WebDriverWait(WebDriverHolder.getWebDriver(), Duration.ofSeconds(timeout));
//    }

    private static final long TIMEOUT = 5;

    public static void waitUntilEditable(SelenideElement element) {
        element.shouldBe(Condition.editable);
    }

    public static void waitUntilClickable(SelenideElement element) {
        element.shouldBe(Condition.interactable);
    }

    public static void waitUntilInvisible(SelenideElement element) {
        element.shouldBe(Condition.disappear);
    }

    public static void waitUntilVisible(SelenideElement element) {
        element.shouldBe(Condition.visible);
    }

    public static void waitUntilVisibleWithTimeout(SelenideElement element) {
        element.shouldBe(Condition.visible, Duration.ofSeconds(TIMEOUT));
    }

    public static void waitUntilCollectionNotEmpty(ElementsCollection elements) {
        elements.shouldBe(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(TIMEOUT));
    }
}
