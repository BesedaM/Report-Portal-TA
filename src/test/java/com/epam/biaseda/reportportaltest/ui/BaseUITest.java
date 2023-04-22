package com.epam.biaseda.reportportaltest.ui;

import com.epam.biaseda.reportportaltest.ui.driver.WebDriverContainer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseUITest {

    protected static final Logger log = LogManager.getRootLogger();

    @BeforeClass
    public void initWebdriver() {
        WebDriverContainer.launchDriver();
    }


    @AfterClass(alwaysRun = true)
    public void quitWebdriver() {
        WebDriverContainer.quitDriver();
    }
}
