package com.epam.biaseda.reportportaltest.ui.page;

import com.epam.biaseda.reportportaltest.core.driver.WebDriverHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class BasePage {

    private static Logger log = LogManager.getRootLogger();

    protected BasePage() {
        HtmlElementLoader.populatePageObject(this, WebDriverHolder.getWebDriver());
    }

    public void waitForPageLoaded() {
        log.warn(String.format("WaitForPageLoaded method is not implemented for %s.", this.getClass().getCanonicalName()));
    }
}
