package com.epam.biaseda.reportportaltest.ui;

import com.epam.biaseda.reportportaltest.ui.driver.WebDriverContainer;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseUITest {

    @BeforeClass
    public void initWebdriver() {
        WebDriverContainer.launchDriver();
    }


    @AfterClass(alwaysRun = true)
    public void quitWebdriver() {
        WebDriverContainer.quitDriver();
    }
}
