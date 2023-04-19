package com.epam.biaseda.reportportaltest.ui.logic;

import com.epam.biaseda.reportportaltest.core.util.ApplicationProperty;
import com.epam.biaseda.reportportaltest.core.util.ApplicationPropertyService;
import com.epam.biaseda.reportportaltest.core.util.SecurityPropertyService;
import com.epam.biaseda.reportportaltest.core.util.ServerType;
import com.epam.biaseda.reportportaltest.ui.driver.action.NavigationAction;
import com.epam.biaseda.reportportaltest.ui.service.LoginService;

public class LoginLogic {

    public static void login() {
        ServerType serverType = ServerType.getValueFromString(ApplicationPropertyService.getProperty(ApplicationProperty.SERVER_TYPE));

        String url;

        switch (serverType) {
            case LOCAL:
                url = ApplicationPropertyService.getProperty(ApplicationProperty.SERVER_LOCAL_URL);
                break;
            case REMOTE:
                url = ApplicationPropertyService.getProperty(ApplicationProperty.SERVER_REMOTE_URL);
                break;
            default:
                throw new IllegalStateException(String.format("Unknown server type %s passed!", serverType));
        }

        login(url, SecurityPropertyService.getLogin(serverType), SecurityPropertyService.getPassword(serverType));
    }

    private static void login(String url, String login, String password) {
        NavigationAction.navigateToUrl(url);

        LoginService.enterLogin(login);
        LoginService.enterPassword(password);

        LoginService.clickLoginButton();

    }
}
