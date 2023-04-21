package com.epam.biaseda.reportportaltest.ui;

import com.epam.biaseda.reportportaltest.BaseTest;
import com.epam.biaseda.reportportaltest.ui.logic.LoginServiceUILogic;
import com.epam.biaseda.reportportaltest.ui.service.DashboardsUIService;
import com.epam.biaseda.reportportaltest.ui.validation.DashboardsUIValidation;
import org.testng.annotations.Test;

public class VerifyNotEmptyDashboard extends BaseTest {

    @Test
    public static void login(){
        LoginServiceUILogic.login();
    }

    @Test(dependsOnMethods = "login")
    public static void openDashboardsPage(){
        DashboardsUIValidation.validateDashboardsPage();
        DashboardsUIService.openDashboard("DEMO DASHBOARD");
    }

    @Test
    public static void validateDemoDashboardPage(){


    }
}
