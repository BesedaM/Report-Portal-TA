package com.epam.biaseda.reportportaltest.ui.cucumber.hook;

import com.epam.biaseda.reportportaltest.ui.driver.WebDriverContainer;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CommonUIHooks {

    @Before
    public void initWebdriver() {
        WebDriverContainer.launchDriver();
    }

    @After
    public void quitWebdriver() {
        WebDriverContainer.quitDriver();
    }
}
