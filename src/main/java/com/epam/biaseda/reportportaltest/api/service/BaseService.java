package com.epam.biaseda.reportportaltest.api.service;

import com.epam.biaseda.reportportaltest.api.util.LogPrinter;
import com.epam.biaseda.reportportaltest.core.util.ApplicationPropertyService;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseService {

    protected static final Logger log = LogManager.getRootLogger();

    protected RequestSpecBuilder getBasicRequestSpecBuilder() {
        RequestSpecBuilder baseRequestSpecBuilder = new RequestSpecBuilder()
                .setContentType("application/json; charset=UTF-8")
                .setBaseUri(ApplicationPropertyService.defineApplicationUrl())
                .addFilter(ResponseLoggingFilter.logResponseTo(LogPrinter.getPrinter()))
                .addFilter(RequestLoggingFilter.logRequestTo(LogPrinter.getPrinter()));

        return baseRequestSpecBuilder;
    }
}
