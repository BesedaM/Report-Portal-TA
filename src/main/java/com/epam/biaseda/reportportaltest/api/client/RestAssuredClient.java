package com.epam.biaseda.reportportaltest.api.client;

import com.epam.biaseda.reportportaltest.api.util.ApiLogPrinter;
import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.core.property.ApplicationPropertyService;
import com.epam.biaseda.reportportaltest.core.property.SecurityPropertyService;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
import java.util.Objects;

import static com.epam.biaseda.reportportaltest.api.util.LoggingConstants.*;
import static io.restassured.RestAssured.given;

public class RestAssuredClient implements ApiClient {

    private static CustomLogger log = CustomLoggerProvider.getLogger();

    @Override
    public CustomResponse doGetRequest(String url, Map<String, String> pathSegments, Map<String, String> parameters) {
        log.info(RESPONSE_START);
        Response response =
                getRequestSpecification(url, pathSegments, parameters)
                        .get()
                        .andReturn();
        log.info(RESPONSE_END);

        return RestAssuredResponseConverter.convertToCustomResponse(response);
    }

    @Override
    public CustomResponse doPostRequest(String url, Object entity, Map<String, String> pathSegments, Map<String, String> parameters) {
        log.info(RESPONSE_START);
        Response response =
                getRequestSpecification(url, pathSegments, parameters)
                        .post()
                        .andReturn();
        log.info(RESPONSE_END);

        return RestAssuredResponseConverter.convertToCustomResponse(response);
    }

    @Override
    public CustomResponse doDeleteRequest(String url, Map<String, String> pathSegments, Map<String, String> parameters) {
        log.info(RESPONSE_START);
        Response response =
                getRequestSpecification(url, pathSegments, parameters)
                        .delete()
                        .andReturn();
        log.info(RESPONSE_END);

        return RestAssuredResponseConverter.convertToCustomResponse(response);
    }

    @Override
    public CustomResponse doPutRequest(String url, Object entity, Map<String, String> pathSegments, Map<String, String> parameters) {
        log.info(RESPONSE_START);
        Response response =
                getRequestSpecification(url, pathSegments, parameters)
                        .put()
                        .andReturn();
        log.info(RESPONSE_END);

        return RestAssuredResponseConverter.convertToCustomResponse(response);
    }

    private RequestSpecification getRequestSpecification(String url, Map<String, String> pathSegments, Map<String, String> parameters) {
        RequestSpecBuilder baseRequestSpecBuilder = new RequestSpecBuilder()
                .setContentType("application/json; charset=UTF-8")
                .setBaseUri(ApplicationPropertyService.defineApplicationUrl())
                .setBasePath(url)
//                .addFilter(ResponseLoggingFilter.logResponseTo(ApiLogPrinter.getPrinter()))
                .addFilter(RequestLoggingFilter.logRequestTo(ApiLogPrinter.getPrinter()));

        if (Objects.nonNull(pathSegments)) {
            pathSegments.forEach(baseRequestSpecBuilder::addPathParam);
        }

        if (Objects.nonNull(parameters)) {
            parameters.forEach(baseRequestSpecBuilder::addParam);
        }

        return given()
                .spec(baseRequestSpecBuilder.build())
                .auth().preemptive()
                .oauth2(SecurityPropertyService.ACCESS_TOKEN)
                .when();
    }
}
