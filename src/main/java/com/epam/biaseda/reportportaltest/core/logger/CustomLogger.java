package com.epam.biaseda.reportportaltest.core.logger;

public interface CustomLogger {

    void debug(String message);
    void info(String message);
    void error(String message);

    void warn(String message);
}
