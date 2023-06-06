package com.epam.biaseda.reportportaltest.ui.selenide.service;

import com.codeborne.selenide.Condition;
import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.ui.selenide.page.LoginPage;
import com.epam.biaseda.reportportaltest.ui.selenide.page.NavigationSidebarPanel;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class LoginUIService {

    private static CustomLogger log = CustomLoggerProvider.getLogger();

    public static void enterLogin(String login) {
        $(LoginPage.LOGIN).shouldBe(Condition.editable);

        log.info(String.format("Entering username '%s'", login));
        $(LoginPage.LOGIN).setValue(login);
    }

    public static void enterPassword(String password) {
        log.info(String.format("Entering password '%s'", password));
        $(LoginPage.PASSWORD).setValue(password);
    }

    public static void clickLoginButton() {
        log.info("Click on Login button");
        $(LoginPage.SUBMIT_BUTTON).click();
        $(NavigationSidebarPanel.CURRENT_PROJECT).shouldBe(Condition.visible, Duration.ofSeconds(10));
    }
}
