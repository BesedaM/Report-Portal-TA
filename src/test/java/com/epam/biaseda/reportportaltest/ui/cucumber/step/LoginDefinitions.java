package com.epam.biaseda.reportportaltest.ui.cucumber.step;

import com.epam.biaseda.reportportaltest.ui.logic.LoginServiceUILogic;
import io.cucumber.java.en.Given;

public class LoginDefinitions {

    @Given("user logins to Report Portal")
    public void user_logins_to_report_portal() {
        LoginServiceUILogic.login();
    }
}
