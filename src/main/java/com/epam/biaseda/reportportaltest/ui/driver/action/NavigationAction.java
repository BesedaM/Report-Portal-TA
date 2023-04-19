package com.epam.biaseda.reportportaltest.ui.driver.action;

import com.epam.biaseda.reportportaltest.ui.driver.WebDriverHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NavigationAction {

    private static Logger log = LogManager.getRootLogger();

    public static void navigateToUrl(String url) {
        log.info("Navigate to {} url ...", url);
        WebDriverHolder.getWebDriver().navigate().to(url);
    }

    public static void refreshPage() {
        WebDriverHolder.getWebDriver().navigate().refresh();
    }

    public static void goBack() {
        WebDriverHolder.getWebDriver().navigate().back();
    }
}
