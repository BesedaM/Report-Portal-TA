package com.epam.biaseda.reportportaltest.api.clientapi;

import com.epam.biaseda.reportportaltest.api.service.servicewithclient.WidgetsService;
import com.epam.biaseda.reportportaltest.api.service.servicewithclient.WidgetsServiceImpl;
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

    protected String projectName;
    protected String username;
    protected String password;

    @BeforeClass
    public void logTestStart() {
        log.debug(String.format("%s Test start", getClass().getCanonicalName()));
    }

    @BeforeClass
    public void defineTestData() {
        projectName = ApplicationPropertyService.getProperty(ApplicationProperty.PROJECT_NAME);
        username = SecurityPropertyService.LOGIN;
        password = SecurityPropertyService.PASSWORD;
    }

    @AfterClass
    public void logTestEnd() {
        log.debug(String.format("%s Test end", getClass().getCanonicalName()));
    }
}
