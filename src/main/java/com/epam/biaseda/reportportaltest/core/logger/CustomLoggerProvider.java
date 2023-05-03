package com.epam.biaseda.reportportaltest.core.logger;

public class CustomLoggerProvider {

    private static CustomLogger CUSTOM_LOGGER;

    public static CustomLogger getLogger() {
        if (CUSTOM_LOGGER == null) {
            CUSTOM_LOGGER = CustomLoggerImpl.getRootLogger();
        }
        return CUSTOM_LOGGER;
    }
}
