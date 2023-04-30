package com.epam.biaseda.reportportaltest.ui.testng;

import com.epam.biaseda.reportportaltest.ui.driver.WebDriverContainer;
import com.epam.biaseda.reportportaltest.ui.testng.listener.TestExecutionListener;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({TestExecutionListener.class})
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
