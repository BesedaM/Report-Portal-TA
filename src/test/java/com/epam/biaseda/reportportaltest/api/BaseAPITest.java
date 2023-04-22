package com.epam.biaseda.reportportaltest.api;

import com.epam.biaseda.reportportaltest.api.util.ApiLogPrinter;
import com.epam.biaseda.reportportaltest.core.property.ApplicationProperty;
import com.epam.biaseda.reportportaltest.core.property.ApplicationPropertyService;
import com.epam.biaseda.reportportaltest.core.property.SecurityPropertyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LoggingException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseAPITest {

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
            ApiLogPrinter.initLogPrinter();
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
        ApiLogPrinter.closeLogPrinter();
    }

    @AfterClass(dependsOnMethods = "closeLogPrinter")
    public void logTestEnd(){
        log.debug(String.format("%s Test end", getClass().getCanonicalName()));
    }
}
