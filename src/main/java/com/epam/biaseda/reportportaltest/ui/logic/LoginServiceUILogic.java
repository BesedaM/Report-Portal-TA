package com.epam.biaseda.reportportaltest.ui.logic;

import com.epam.biaseda.reportportaltest.core.util.ApplicationPropertyService;
import com.epam.biaseda.reportportaltest.core.util.SecurityPropertyService;
import com.epam.biaseda.reportportaltest.ui.driver.action.NavigationAction;
import com.epam.biaseda.reportportaltest.ui.service.LoginUIService;

public class LoginServiceUILogic {

    public static void login() {
        String url = ApplicationPropertyService.defineApplicationUrl();
        NavigationAction.navigateToUrl(url);

        LoginUIService.enterLogin(SecurityPropertyService.LOGIN);
        LoginUIService.enterPassword(SecurityPropertyService.PASSWORD);

        LoginUIService.clickLoginButton();
    }
}
