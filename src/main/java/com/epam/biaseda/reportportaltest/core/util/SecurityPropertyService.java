package com.epam.biaseda.reportportaltest.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class SecurityPropertyService {

    private enum SecurityPropertyType {
        LOGIN, PASSWORD, TOKEN;
    }

    private static final Properties properties = new Properties();
    private static final String SECURITY_PROPERTIES_FILE = "security.properties";

    private static final List<String> PROPERTIES_LIST =
            Arrays.asList("remote.reportportal.login",
                    "remote.reportportal.password",
                    "remote.reportportal.accesstoken",
                    "local.reportportal.login",
                    "local.reportportal.password",
                    "local.reportportal.accesstoken");

    public static final String LOGIN;
    public static final String PASSWORD;
    public static final String ACCESS_TOKEN;

    static {
        loadSecurityProperties();
        LOGIN = getProperty(SecurityPropertyType.LOGIN);
        PASSWORD = getProperty(SecurityPropertyType.PASSWORD);
        ACCESS_TOKEN = getProperty(SecurityPropertyType.TOKEN);
    }

    private static void loadSecurityProperties() {
        try (InputStream resourceStream = ClassLoader.getSystemResourceAsStream(SECURITY_PROPERTIES_FILE)) {
            properties.load(resourceStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getProperty(SecurityPropertyType propertyType) {
        String serverType = ApplicationPropertyService.getProperty(ApplicationProperty.SERVER_TYPE);

        String requiredPropertyName = PROPERTIES_LIST.stream().filter(property -> property.startsWith(serverType.toLowerCase()) &&
                        property.endsWith(propertyType.name().toLowerCase()))
                .findFirst().orElseThrow(() -> new NoSuchElementException("Security property with name '%s.reportportal.%s' was not found!"));

        return properties.getProperty(requiredPropertyName);
    }
}
