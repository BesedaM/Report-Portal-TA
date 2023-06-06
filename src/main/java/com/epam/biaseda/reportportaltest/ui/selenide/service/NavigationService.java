package com.epam.biaseda.reportportaltest.ui.selenide.service;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;

import static com.codeborne.selenide.Selenide.*;

public class NavigationService {

    private static CustomLogger log = CustomLoggerProvider.getLogger();

    public static void navigateToUrl(String url) {
        log.info(String.format("Navigate to %s url ...", url));
        open(url);
    }

    public static void refreshPage() {
        log.info("Refresh current page...");
        refresh();
    }

    public static void goBack() {
        back();
    }
}
