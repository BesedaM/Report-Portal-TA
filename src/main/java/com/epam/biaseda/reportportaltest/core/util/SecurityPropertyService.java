package com.epam.biaseda.reportportaltest.core.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SecurityPropertyService {

    private static final Properties properties = new Properties();
    private static final String SECURITY_PROPERTIES_FILE = "config.properties";

    private static final String LOGIN = "reportportal.username";
    private static final String PASSWORD = "reportportal.password";

    private static final String LOGIN_LOCAL = "reportportal.local.username";
    private static final String PASSWORD_LOCAL = "reportportal.local.password";


    static {
        loadSecurityProperties();
    }

    private static void loadSecurityProperties() {
        try {
            properties.load(new FileInputStream(SECURITY_PROPERTIES_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getRemoteLogin() {
        return properties.getProperty(LOGIN);
    }

    public static String getRemotePassword() {
        return properties.getProperty(PASSWORD);
    }

    public static String getLocalLogin() {
        return properties.getProperty(LOGIN_LOCAL);
    }

    public static String getLocalPassword() {
        return properties.getProperty(PASSWORD_LOCAL);
    }
}
