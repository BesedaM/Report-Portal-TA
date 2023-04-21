package com.epam.biaseda.reportportaltest.ui.logic;

import com.epam.biaseda.reportportaltest.core.util.ApplicationPropertyService;
import com.epam.biaseda.reportportaltest.core.util.SecurityPropertyService;
import com.epam.biaseda.reportportaltest.ui.driver.action.NavigationAction;
import com.epam.biaseda.reportportaltest.ui.service.LoginService;

public class LoginLogic {

    public static void login() {
        String url = ApplicationPropertyService.defineApplicationUrl();
        NavigationAction.navigateToUrl(url);

        LoginService.enterLogin(SecurityPropertyService.LOGIN);
        LoginService.enterPassword(SecurityPropertyService.PASSWORD);

        LoginService.clickLoginButton();
    }
}
