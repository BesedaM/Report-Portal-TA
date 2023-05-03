package com.epam.biaseda.reportportaltest.ui.driver.action;

import com.epam.biaseda.reportportaltest.ui.driver.WebDriverHolder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class EventAction {

    public static <T extends WebElement> T mouseOver(T element) {
        WebElement originalElement = element;

        if (element instanceof HtmlElement) {
            originalElement = ((HtmlElement) element).getWrappedElement();
        }

        if (element instanceof TypifiedElement) {
            originalElement = ((TypifiedElement) element).getWrappedElement();
        }

        Action mouseOverAction = new Actions(WebDriverHolder.getWebDriver())
                .moveToElement(originalElement)
                .build();
        mouseOverAction.perform();
        return element;
    }

    public static void scrollTo(String xpath, int scrollAmount) {
        WebElement element = WebDriverHolder.getWebDriver().findElement(By.xpath(xpath));
        ((JavascriptExecutor) WebDriverHolder.getWebDriver()).executeScript("arguments[0].scrollTo({top: arguments[1]});", element, scrollAmount);
    }

    //try to use mouseOver instead
    public static void scrollIntoView(WebElement element) {
        ((JavascriptExecutor) WebDriverHolder.getWebDriver()).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
    }
}
