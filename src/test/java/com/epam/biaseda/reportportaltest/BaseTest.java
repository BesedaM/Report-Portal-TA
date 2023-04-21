package com.epam.biaseda.reportportaltest;

import com.epam.biaseda.reportportaltest.core.util.ApplicationProperty;
import com.epam.biaseda.reportportaltest.core.util.ApplicationPropertyService;
import com.epam.biaseda.reportportaltest.core.util.SecurityPropertyService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    private static final Logger log = LogManager.getRootLogger();

    protected String projectName;
    protected String username;
    protected String password;

    @BeforeClass
    public void defineProjectName() {
        projectName = ApplicationPropertyService.getProperty(ApplicationProperty.PROJECT_NAME);
    }

    @BeforeClass
    public void defineUserData() {
        username = SecurityPropertyService.LOGIN;
        password = SecurityPropertyService.PASSWORD;
    }
}
