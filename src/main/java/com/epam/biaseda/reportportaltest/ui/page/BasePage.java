package com.epam.biaseda.reportportaltest.ui.page;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.ui.driver.WebDriverHolder;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

public class BasePage {

    private static CustomLogger log = CustomLoggerProvider.getLogger();

    public BasePage() {
        HtmlElementLoader.populatePageObject(this, WebDriverHolder.getWebDriver());
    }

    public void waitForPageLoaded() {
        log.warn(String.format("WaitForPageLoaded method is not implemented for %s.", this.getClass().getCanonicalName()));
    }
}
