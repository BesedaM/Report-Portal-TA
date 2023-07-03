package com.epam.biaseda.reportportaltest.core.property;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

public class SecurityPropertyService {

    private enum SecurityPropertyType {
        LOGIN, PASSWORD, TOKEN
    }

    private static final CustomLogger log = CustomLoggerProvider.getLogger();
    private static final Properties properties = new Properties();
    private static final String SECURITY_PROPERTIES_FILE = "security.properties";

    private static final List<String> PROPERTIES_LIST =
            Arrays.asList("remote.reportportal.login",
                    "remote.reportportal.password",
                    "remote.reportportal.accesstoken",
                    "local.reportportal.login",
                    "local.reportportal.password",
                    "local.reportportal.accesstoken");

    public static String LOGIN;
    public static String PASSWORD;
    public static String ACCESS_TOKEN;

    static {
        loadSecurityProperties();
    }

    private static void loadSecurityProperties() {
        try (InputStream resourceStream = ClassLoader.getSystemResourceAsStream(SECURITY_PROPERTIES_FILE)) {
            properties.load(resourceStream);

            LOGIN = getProperty(SecurityPropertyType.LOGIN);
            PASSWORD = getProperty(SecurityPropertyType.PASSWORD);
            ACCESS_TOKEN = getProperty(SecurityPropertyType.TOKEN);
        } catch (IOException e) {
            log.warn(String.format("No '%s' file defined, loading values from local system", SECURITY_PROPERTIES_FILE));

            LOGIN = System.getProperty(SecurityPropertyType.LOGIN.name());
            PASSWORD = System.getProperty(SecurityPropertyType.PASSWORD.name());
            ACCESS_TOKEN = System.getProperty(SecurityPropertyType.TOKEN.name());
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
