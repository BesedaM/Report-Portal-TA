package com.epam.biaseda.reportportaltest.core.property;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationPropertyService {

    private static final Properties properties = new Properties();
    private static final String CONFIG_PROPERTIES_FILE = "config.properties";

    private static final String SERVER_LOCAL_URL = "server.local.url";
    private static final String SERVER_REMOTE_URL = "server.remote.url";
    private static final String SERVER_LOCAL_SELENOID_URL = "server.local.selenoid.url";
    private static final String DRIVER_LOCAL_MODE = "local";
    private static final String DRIVER_REMOTE_MODE = "remote";

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (InputStream resourceStream = ClassLoader.getSystemResourceAsStream(CONFIG_PROPERTIES_FILE)) {
            properties.load(resourceStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(ApplicationProperty property) {
        return properties.getProperty(property.getName());
    }

    public static String defineApplicationUrl() {
        String webDriverMode = ApplicationPropertyService.getProperty(ApplicationProperty.WEBDRIVER_MODE);
        String serverType = ApplicationPropertyService.getProperty(ApplicationProperty.SERVER_TYPE);
        switch (ServerType.getValueFromString(serverType)) {
            case LOCAL:
                return defineLocalHostUrl(webDriverMode);
            case REMOTE:
                return properties.getProperty(SERVER_REMOTE_URL);
            default:
                throw new IllegalStateException(String.format("Unknown server type %s passed!", serverType));
        }
    }

    private static String defineLocalHostUrl(String webDriverMode) {
        if (webDriverMode.equalsIgnoreCase(DRIVER_LOCAL_MODE)) {
            return properties.getProperty(SERVER_LOCAL_URL);
        } else if (webDriverMode.equalsIgnoreCase(DRIVER_REMOTE_MODE)) {
            return properties.getProperty(SERVER_LOCAL_SELENOID_URL);
        }
        throw new IllegalStateException(String.format("Unknown webdriver mode %s passed!", webDriverMode));
    }
}
