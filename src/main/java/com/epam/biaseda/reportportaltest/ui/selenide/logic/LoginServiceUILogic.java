package com.epam.biaseda.reportportaltest.ui.selenide.logic;

import com.epam.biaseda.reportportaltest.core.property.ApplicationPropertyService;
import com.epam.biaseda.reportportaltest.core.property.SecurityPropertyService;
import com.epam.biaseda.reportportaltest.ui.selenide.service.NavigationService;
import com.epam.biaseda.reportportaltest.ui.selenide.service.LoginUIService;

public class LoginServiceUILogic {

    public static void login() {
        String url = ApplicationPropertyService.defineApplicationUrl();

        NavigationService.navigateToUrl(url);
        //TODO delete stuff
//        NavigationService.navigateToUrl("https://host.docker.internal:8080");

        try {
            Thread.sleep(10000);
        } catch (Exception ignored){

        }


        LoginUIService.enterLogin(SecurityPropertyService.LOGIN);
        LoginUIService.enterPassword(SecurityPropertyService.PASSWORD);

        LoginUIService.clickLoginButton();
    }
}
