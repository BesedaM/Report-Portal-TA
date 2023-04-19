package com.epam.biaseda.reportportaltest.ui.page.element;

import com.epam.biaseda.reportportaltest.ui.driver.action.WaitAction;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

public class CustomElement extends HtmlElement {

    @Override
    public boolean isDisplayed() {
        try {
            return super.isDisplayed();
        } catch (Exception exp) {
            return false;
        }
    }

    @Override
    public boolean isEnabled() {
        try {
            return super.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    public void waitUntilInvisible() {
        WaitAction.getWebDriverWait()
                .withMessage(String.format("'%s' not closed!", getName()))
                .until(ExpectedConditions.invisibilityOf(this));
    }

    public void waitUntilVisible() {
        WaitAction.waitUntilVisible(this);
    }
}
