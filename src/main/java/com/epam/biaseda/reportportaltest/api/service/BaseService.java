package com.epam.biaseda.reportportaltest.api.service;

import com.epam.biaseda.reportportaltest.api.util.ApiLogPrinter;
import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.core.property.ApplicationPropertyService;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class BaseService {

    protected static CustomLogger log = CustomLoggerProvider.getLogger();

    protected RequestSpecBuilder getBasicRequestSpecBuilder() {
        RequestSpecBuilder baseRequestSpecBuilder = new RequestSpecBuilder()
                .setContentType("application/json; charset=UTF-8")
                .setBaseUri(ApplicationPropertyService.defineApplicationUrl())
                .addFilter(ResponseLoggingFilter.logResponseTo(ApiLogPrinter.getPrinter()))
                .addFilter(RequestLoggingFilter.logRequestTo(ApiLogPrinter.getPrinter()));

        return baseRequestSpecBuilder;
    }
}
