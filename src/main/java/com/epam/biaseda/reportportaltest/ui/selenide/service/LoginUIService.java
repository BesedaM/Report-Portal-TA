package com.epam.biaseda.reportportaltest.ui.selenide.service;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.ui.selenide.page.LoginPage;
import com.epam.biaseda.reportportaltest.ui.selenide.page.NavigationSidebarPanel;
import com.epam.biaseda.reportportaltest.ui.selenide.service.action.WaitAction;

import static com.codeborne.selenide.Selenide.page;

public class LoginUIService {

    private static CustomLogger log = CustomLoggerProvider.getLogger();

    private static LoginPage loginPage = page(new LoginPage());
    private static NavigationSidebarPanel navigationSidebarPanel=page(new NavigationSidebarPanel());

    public static void enterLogin(String login) {
        WaitAction.waitUntilEditable(loginPage.getLogin());

        log.info(String.format("Entering username '%s'", login));
        loginPage.getLogin().setValue(login);
    }

    public static void enterPassword(String password) {
        log.info(String.format("Entering password '%s'", password));
        loginPage.getPassword().setValue(password);
    }

    public static void clickLoginButton() {
        log.info("Click on Login button");
        WaitAction.waitUntilClickable(loginPage.getSubmitButton());
        loginPage.getSubmitButton().click();
        WaitAction.waitUntilVisibleWithTimeout(navigationSidebarPanel.getCurrentProject());
    }
}
