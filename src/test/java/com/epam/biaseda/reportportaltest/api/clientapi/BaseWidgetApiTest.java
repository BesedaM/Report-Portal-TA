package com.epam.biaseda.reportportaltest.api.clientapi;

import com.epam.biaseda.reportportaltest.api.service.servicewithclient.WidgetsService;
import com.epam.biaseda.reportportaltest.api.service.servicewithclient.WidgetsServiceImpl;
import com.epam.biaseda.reportportaltest.api.util.ApiLogPrinter;
import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.core.property.ApplicationProperty;
import com.epam.biaseda.reportportaltest.core.property.ApplicationPropertyService;
import com.epam.biaseda.reportportaltest.core.property.SecurityPropertyService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseWidgetApiTest {

    private static final CustomLogger log = CustomLoggerProvider.getLogger();

    protected WidgetsService widgetsService = new WidgetsServiceImpl();

    protected static String PROJECT_NAME = null;

    @BeforeClass
    public void logTestStart() {
        log.debug(String.format("%s Test start", getClass().getCanonicalName()));
    }

    @BeforeClass(dependsOnMethods = "logTestStart")
    public void initLogPrinter() {
        ApiLogPrinter.initLogPrinter();
    }

    @BeforeClass
    public void defineTestData() {
        PROJECT_NAME = ApplicationPropertyService.getProperty(ApplicationProperty.PROJECT_NAME);
    }

    @AfterClass(alwaysRun = true)
    public void closeLogPrinter() {
        ApiLogPrinter.closeLogPrinter();
    }

    @AfterClass
    public void logTestEnd() {
        log.debug(String.format("%s Test end", getClass().getCanonicalName()));
    }
}