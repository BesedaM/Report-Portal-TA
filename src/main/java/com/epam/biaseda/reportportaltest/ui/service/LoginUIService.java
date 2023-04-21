package com.epam.biaseda.reportportaltest.ui.service;

import com.epam.biaseda.reportportaltest.ui.page.LoginPage;
import com.epam.biaseda.reportportaltest.ui.page.NavigationSidebarPanel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginUIService {

    private static final Logger log = LogManager.getRootLogger();

    public static void enterLogin(String login) {
        new LoginPage().waitForPageLoaded();

        log.info("Entering username '{}'", login);
        new LoginPage().getLogin().sendKeys(login);
    }

    public static void enterPassword(String password) {
        log.info("Entering password '{}'", password);
        new LoginPage().getPassword().sendKeys(password);
    }

    public static void clickLoginButton() {
        log.info("Click on Login button");
        new LoginPage().getSubmitButton().click();
        new NavigationSidebarPanel().waitForPageLoaded();
    }
}
