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
                .release()
                .build();
        mouseOverAction.perform();
    }

    public static void scrollTo(SelenideElement element, int yScroll, int xScroll) {
        executeJavaScript("arguments[0].scrollTo({behavior: 'smooth', top: arguments[1], left: arguments[2]});",
                element, yScroll, xScroll);
        //Selenide allows to simplify scrollTo(...) method
        //        element.scrollTo();
    }

    public static void scrollIntoView(SelenideElement element) {
        executeJavaScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
        //Selenide allows to simplify scrollIntoView(...) method
        //        element.scrollIntoView("{behavior: 'smooth', block: 'center'}");
    }
}
