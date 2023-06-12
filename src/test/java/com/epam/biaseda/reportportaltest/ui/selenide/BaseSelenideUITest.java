package com.epam.biaseda.reportportaltest.ui.selenide;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.biaseda.reportportaltest.ui.driver.WebDriverFactory;
import com.epam.biaseda.reportportaltest.ui.selenide.listener.CustomWebDriverEventListener;
import com.epam.biaseda.reportportaltest.ui.selenide.listener.TestExecutionListener;
import com.epam.biaseda.reportportaltest.ui.selenide.logic.LoginServiceUILogic;
import com.epam.biaseda.reportportaltest.ui.selenide.validation.DashboardsUIValidation;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

@Listeners({TestExecutionListener.class})
public class BaseSelenideUITest {

    @BeforeClass
    @Parameters({"browser"})
    public void setUpWebDriver(String browserName) {
        WebDriverRunner.setWebDriver(new WebDriverFactory().getDriver(browserName));
    }

    @BeforeClass(dependsOnMethods = "setUpWebDriver")
    public void setUpListener() {
        WebDriverRunner.addListener(new CustomWebDriverEventListener());
    }

    @BeforeClass(dependsOnMethods = "setUpListener",
            description = "login to Report Portal")
    public void login() {
        LoginServiceUILogic.login();
        DashboardsUIValidation.validateDashboardsPageHeader();
        DashboardsUIValidation.checkDashboardsTableNotEmpty();
    }

    @AfterClass(alwaysRun = true)
    public void logout() {
        WebDriverRunner.closeWebDriver();
    }
}
