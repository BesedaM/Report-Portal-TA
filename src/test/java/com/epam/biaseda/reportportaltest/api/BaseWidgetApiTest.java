package com.epam.biaseda.reportportaltest.api;

import com.epam.biaseda.reportportaltest.api.service.WidgetsService;
import com.epam.biaseda.reportportaltest.api.service.WidgetsServiceImpl;
import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.core.property.ApplicationProperty;
import com.epam.biaseda.reportportaltest.core.property.ApplicationPropertyService;
import com.epam.biaseda.reportportaltest.integration.TeamsNotificationService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseWidgetApiTest {

    private static final CustomLogger log = CustomLoggerProvider.getLogger();

    protected WidgetsService widgetsService = new WidgetsServiceImpl();

    protected static String PROJECT_NAME = null;

    @BeforeClass
    public void logTestStart() {
        log.debug(String.format("%s Test started", getClass().getCanonicalName()));
        TeamsNotificationService.sendNotification(String.format("%s started", getClass().getCanonicalName()));
    }

    @BeforeClass
    public void defineTestData() {
        PROJECT_NAME = ApplicationPropertyService.getProperty(ApplicationProperty.PROJECT_NAME);
    }

    @AfterClass
    public void logTestEnd() {
        log.debug(String.format("%s Test finished", getClass().getCanonicalName()));
        TeamsNotificationService.sendNotification(String.format("%s finished", getClass().getCanonicalName()));
    }
}
