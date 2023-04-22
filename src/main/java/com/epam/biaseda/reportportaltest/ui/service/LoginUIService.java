package com.epam.biaseda.reportportaltest.ui.service;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.ui.page.LoginPage;
import com.epam.biaseda.reportportaltest.ui.page.NavigationSidebarPanel;

public class LoginUIService {

    private static CustomLogger log = CustomLoggerProvider.getLogger();

    public static void enterLogin(String login) {
        new LoginPage().waitForPageLoaded();

        log.info(String.format("Entering username '%s'", login));
        new LoginPage().getLogin().sendKeys(login);
    }

    public static void enterPassword(String password) {
        log.info(String.format("Entering password '%s'", password));
        new LoginPage().getPassword().sendKeys(password);
    }

    public static void clickLoginButton() {
        log.info("Click on Login button");
        new LoginPage().getSubmitButton().click();
        new NavigationSidebarPanel().waitForPageLoaded();
    }
}
