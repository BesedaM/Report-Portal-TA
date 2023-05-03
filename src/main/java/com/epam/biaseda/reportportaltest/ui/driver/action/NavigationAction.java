package com.epam.biaseda.reportportaltest.ui.driver.action;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.ui.driver.WebDriverHolder;

public class NavigationAction {

    private static CustomLogger log = CustomLoggerProvider.getLogger();

    public static void navigateToUrl(String url) {
        log.info(String.format("Navigate to %s url ...", url));
        WebDriverHolder.getWebDriver().navigate().to(url);
    }

    public static void refreshPage() {
        WebDriverHolder.getWebDriver().navigate().refresh();
    }

    public static void goBack() {
        WebDriverHolder.getWebDriver().navigate().back();
    }
}
