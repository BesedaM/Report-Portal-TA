package com.epam.biaseda.reportportaltest.api.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.io.IoBuilder;

import java.io.PrintStream;

public class LogPrinter {

    private static final Logger log = LogManager.getRootLogger();

    private static PrintStream logPrinter;

    public static PrintStream initLogPrinter() {
        logPrinter = IoBuilder.forLogger(log).buildPrintStream();
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
