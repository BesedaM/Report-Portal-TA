package com.epam.biaseda.reportportaltest.ui.selenide;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.biaseda.reportportaltest.ui.selenide.listener.CustomWebDriverEventListener;
import com.epam.biaseda.reportportaltest.ui.selenide.listener.TestExecutionListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

@Listeners({TestExecutionListener.class})
public class BaseSelenideUITest {

    @BeforeClass
    public void setUpListener() {
        WebDriverRunner.addListener(new CustomWebDriverEventListener());
    }
}
