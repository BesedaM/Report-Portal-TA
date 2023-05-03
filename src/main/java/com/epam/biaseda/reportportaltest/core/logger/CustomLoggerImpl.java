package com.epam.biaseda.reportportaltest.core.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomLoggerImpl implements CustomLogger {

    private final Logger log;

    private CustomLoggerImpl() {
        log = LogManager.getRootLogger();
    }

    public static CustomLogger getRootLogger(){
        return new CustomLoggerImpl();
    }

    @Override
    public void debug(String message) {
        log.debug(message);
    }

    @Override
    public void info(String message) {
        log.info(message);
    }

    @Override
    public void error(String message) {
        log.error(message);
    }

    @Override
    public void warn(String message) {
        log.warn(message);
    }
}
