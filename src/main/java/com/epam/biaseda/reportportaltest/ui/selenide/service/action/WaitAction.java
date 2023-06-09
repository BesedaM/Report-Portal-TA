package com.epam.biaseda.reportportaltest.ui.selenide.service.action;

import com.codeborne.selenide.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import javax.annotation.Nonnull;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class WaitAction {

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

    public static void waitUntilAnimationComplete(SelenideElement element) {
        element.shouldBe(animationCompleted());
    }

    public static void waitUntilScrolledIntoView(SelenideElement element) {
        element.shouldBe(scrolledIntoView());
    }

    public static void waitUntilVisibleWithTimeout(SelenideElement element) {
        element.shouldBe(Condition.visible, Duration.ofSeconds(TIMEOUT));
    }

    public static void waitUntilCollectionNotEmpty(ElementsCollection elements) {
        elements.shouldBe(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(TIMEOUT));
    }

    private static Condition animationCompleted() {
        return new Condition("animationCompleted") {
            private Point currentLocation = new Point(0, 0);
            private Dimension currentSize = new Dimension(0, 0);

            @Nonnull
            @Override
            public CheckResult check(Driver driver, WebElement element) {
                Point location = element.getLocation();
                Dimension size = element.getSize();

                boolean animationCompleted = false;
                if (location.equals(currentLocation) && size.equals(currentSize)) {
                    animationCompleted = true;
                } else {
                    currentLocation = location;
                    currentSize = size;
                }

                return new CheckResult(animationCompleted, "Location:" + currentLocation);
            }
        };
    }

    private static Condition scrolledIntoView() {
        return new Condition("scrolledIntoView") {
            @Nonnull
            @Override
            public CheckResult check(Driver driver, WebElement element) {
                String jsCode =
                        "var position = arguments[0].getBoundingClientRect();" +
                                "if(position.top >= 0 && position.bottom <= window.innerHeight) {" +
                                "return true;" +
                                "} else {" +
                                "return false; }";
                String value = executeJavaScript(jsCode, element).toString();
                return new CheckResult(Boolean.parseBoolean(value), "isScrolledIntoView: " + value);
            }
        };
    }
}
