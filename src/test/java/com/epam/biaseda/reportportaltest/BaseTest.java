package com.epam.biaseda.reportportaltest;

import com.epam.biaseda.reportportaltest.api.util.LogPrinter;
import com.epam.biaseda.reportportaltest.core.util.ApplicationProperty;
import com.epam.biaseda.reportportaltest.core.util.ApplicationPropertyService;
import com.epam.biaseda.reportportaltest.core.util.SecurityPropertyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LoggingException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private static final Logger log = LogManager.getRootLogger();

    protected String projectName;
    protected String username;
    protected String password;

    @BeforeClass
    public void logTestStart(){
        log.debug(String.format("%s Test start", getClass().getCanonicalName()));
    }

    @BeforeClass(dependsOnMethods = "logTestStart")
    public void initLogPrinter() {
        try {
            LogPrinter.initLogPrinter();
        } catch (LoggingException ignored) {
            log.info("Log Printer was not created! Unable to write RestAssured logs with Log4j!");
        }
    }

    @BeforeClass
    public void defineTestData() {
        projectName = ApplicationPropertyService.getProperty(ApplicationProperty.PROJECT_NAME);
        username = SecurityPropertyService.LOGIN;
        password = SecurityPropertyService.PASSWORD;
    }

    @AfterClass(alwaysRun = true)
    public void closeLogPrinter(){
        LogPrinter.closeLogPrinter();
    }

    @AfterClass(dependsOnMethods = "closeLogPrinter")
    public void logTestEnd(){
        log.debug(String.format("%s Test end", getClass().getCanonicalName()));
    }
}
