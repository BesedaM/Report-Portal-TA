package com.epam.biaseda.reportportaltest.core.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationPropertyService {

    private static final Properties properties = new Properties();
    private static final String CONFIG_PROPERTIES_FILE = "config.properties";

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try {
            properties.load(new FileInputStream(CONFIG_PROPERTIES_FILE));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getProperty(ApplicationProperty property){
        return properties.getProperty(property.getName());
    }
}
