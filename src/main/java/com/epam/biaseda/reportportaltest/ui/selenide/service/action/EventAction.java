package com.epam.biaseda.reportportaltest.ui.selenide.service.action;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Action;

import static com.codeborne.selenide.Selenide.actions;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class EventAction {

    public static void clickUsingJavaScript(SelenideElement element) {
        executeJavaScript("arguments[0].click();", element);
    }

    public static void dragAndDrop(SelenideElement elementSource, SelenideElement elementTarget) {
        Action mouseOverAction = actions()
                .dragAndDrop(elementSource, elementTarget)
                .build();
        mouseOverAction.perform();
    }

    public static void resize(SelenideElement element, int xOffset, int yOffset) {
        Action mouseOverAction = actions()
                .clickAndHold(element)
                .moveByOffset(xOffset, yOffset)
                .build();
        mouseOverAction.perform();
    }

    public static void scrollTo(SelenideElement element, int yScroll, int xScroll) {
        executeJavaScript("arguments[0].scrollTo({behavior: 'smooth', top: arguments[1], left: arguments[2]});",
                element, yScroll, xScroll);
    }

    public static void scrollIntoView(SelenideElement element) {
        executeJavaScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }

    public static boolean isScrolledIntoView(SelenideElement element) {
        String jsCode =
                "var position = arguments[0].getBoundingClientRect();" +
                        "if(position.top >= 0 && position.bottom <= window.innerHeight) {" +
                        "return true;" +
                        "} else {" +
                        "return false; }";
        String value = executeJavaScript(jsCode, element).toString();
        return Boolean.parseBoolean(value);
    }
}
