package com.epam.biaseda.reportportaltest.api.util;

import com.epam.biaseda.reportportaltest.api.client.ApiClientHolder;
import com.epam.biaseda.reportportaltest.api.client.RestAssuredClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.io.IoBuilder;

import java.io.PrintStream;

public class ApiLogPrinter {

    private static final Logger log = LogManager.getRootLogger();

    private static PrintStream logPrinter;

    public static PrintStream initLogPrinter() {
        if (logPrinter == null && ApiClientHolder.getApiClient() instanceof RestAssuredClient) {
            logPrinter = IoBuilder.forLogger(log).buildPrintStream();
        }
        return logPrinter;
    }

    public static PrintStream getPrinter() {
        return logPrinter;
    }

    public static void closeLogPrinter() {
        if (logPrinter != null) {
            logPrinter.close();
        }
    }
}
