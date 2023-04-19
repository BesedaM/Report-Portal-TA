package com.epam.biaseda.reportportaltest.ui.service;

import com.epam.biaseda.reportportaltest.ui.page.LoginPage;

public class LoginService {

    public static void enterLogin(String login) {
        new LoginPage().waitForPageLoaded();
        new LoginPage().getLogin().sendKeys(login);
    }

    public static void enterPassword(String password) {
        new LoginPage().getPassword().sendKeys(password);
    }

    public static void clickLoginButton() {
        new LoginPage().getSubmitButton().click();
    }
}
