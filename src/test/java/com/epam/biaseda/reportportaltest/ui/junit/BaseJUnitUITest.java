package com.epam.biaseda.reportportaltest.ui.junit;

import com.epam.biaseda.reportportaltest.ui.driver.WebDriverContainer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

public class BaseJUnitUITest {

    @BeforeAll
    public void initWebdriver() {
        WebDriverContainer.launchDriver();
    }


    @AfterAll
    public void quitWebdriver() {
        WebDriverContainer.quitDriver();
    }
}
