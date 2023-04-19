package com.epam.biaseda.reportportaltest.core.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class SecurityPropertyService {

    private static final Properties properties = new Properties();
    private static final String SECURITY_PROPERTIES_FILE = "config.properties";

    private static final String LOGIN_REMOTE = "remote.reportportal.username";
    private static final String PASSWORD_REMOTE = "remote.reportportal.password";

    private static final String LOGIN_LOCAL = "local.reportportal.username";
    private static final String PASSWORD_LOCAL = "local.reportportal.password";


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

    public static String getLogin(ServerType serverType) {
        switch (serverType) {
            case LOCAL:
                return properties.getProperty(LOGIN_LOCAL);
            case REMOTE:
                return properties.getProperty(LOGIN_REMOTE);
            default:
                throw new IllegalStateException(String.format("Unknown login for %s type server!", serverType));
        }
    }

    public static String getPassword(ServerType serverType) {
        switch (serverType) {
            case LOCAL:
                return properties.getProperty(PASSWORD_LOCAL);
            case REMOTE:
                return properties.getProperty(PASSWORD_REMOTE);
            default:
                throw new IllegalStateException(String.format("Unknown password for %s type server!", serverType));
        }
    }

}
