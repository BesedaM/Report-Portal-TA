package com.epam.biaseda.reportportaltest.api.client;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.core.property.ApplicationPropertyService;
import com.epam.biaseda.reportportaltest.core.property.SecurityPropertyService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.RequestSpecification;

import java.util.Map;
import java.util.Objects;

import static com.epam.biaseda.reportportaltest.api.util.LoggingConstants.*;
import static io.restassured.RestAssured.given;

public class RestAssuredClient implements ApiClient {

    private static final String EMPTY_REQUEST_SPECIFICATION_BODY = "null";
    private static final String METHOD_GET = "GET";
    private static final String METHOD_POST = "POST";
    private static final String METHOD_PUT = "PUT";
    private static final String METHOD_DELETE = "DELETE";

    private static CustomLogger log = CustomLoggerProvider.getLogger();

    private static ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public CustomResponse doGetRequest(String url,
                                       Map<String, String> pathSegments,
                                       Map<String, String> parameters) {
        Response response =
                getRequestSpecification(url, pathSegments, parameters, null, METHOD_GET)
                        .get()
                        .andReturn();

        CustomResponse customResponse = RestAssuredResponseConverter.convertToCustomResponse(response);
        logResponse(customResponse);
        return customResponse;
    }

    @Override
    public CustomResponse doPostRequest(String url,
                                        Object entity,
                                        Map<String, String> pathSegments,
                                        Map<String, String> parameters) {
        Response response =
                getRequestSpecification(url, pathSegments, parameters, entity, METHOD_POST)
                        .body(entity)
                        .post()
                        .andReturn();

        CustomResponse customResponse = RestAssuredResponseConverter.convertToCustomResponse(response);
        logResponse(customResponse);
        return customResponse;
    }

    @Override
    public CustomResponse doDeleteRequest(String url,
                                          Map<String, String> pathSegments,
                                          Map<String, String> parameters) {
        Response response =
                getRequestSpecification(url, pathSegments, parameters, null, METHOD_POST)
                        .delete()
                        .andReturn();

        CustomResponse customResponse = RestAssuredResponseConverter.convertToCustomResponse(response);
        logResponse(customResponse);
        return customResponse;
    }

    @Override
    public CustomResponse doPutRequest(String url,
                                       Object entity,
                                       Map<String, String> pathSegments,
                                       Map<String, String> parameters) {
        Response response =
                getRequestSpecification(url, pathSegments, parameters, entity, METHOD_PUT)
                        .put()
                        .andReturn();

        CustomResponse customResponse = RestAssuredResponseConverter.convertToCustomResponse(response);
        logResponse(customResponse);
        return customResponse;
    }

    private void logResponse(CustomResponse customResponse) {
        log.info(RESPONSE_START);
        customResponse.getHeaders().entries().forEach(header -> log.info(header.getKey() + ": " + header.getValue()));
        try {
            log.info(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectMapper.readValue(customResponse.getBody(), Object.class)));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Unable to parse Custom response body to entity!", e);
        }
        log.info(RESPONSE_END);
    }

    private RequestSpecification getRequestSpecification(String url,
                                                         Map<String, String> pathSegments,
                                                         Map<String, String> parameters,
                                                         Object entity,
                                                         String methodName) {
        RequestSpecBuilder baseRequestSpecBuilder = new RequestSpecBuilder()
                .setContentType("application/json; charset=UTF-8")
                .setBaseUri(ApplicationPropertyService.defineApplicationUrl())
                .setBasePath(url);

        if (Objects.nonNull(pathSegments)) {
            pathSegments.forEach(baseRequestSpecBuilder::addPathParam);
        }

        if (Objects.nonNull(parameters)) {
            parameters.forEach(baseRequestSpecBuilder::addParam);
        }

        try {
            baseRequestSpecBuilder.setBody(objectMapper.writeValueAsString(entity));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Unable to parse entity to String!", e);
        }

        FilterableRequestSpecification specification = (FilterableRequestSpecification) given()
                .spec(baseRequestSpecBuilder.build())
                .auth().preemptive()
                .oauth2(SecurityPropertyService.ACCESS_TOKEN)
                .when();

        logRequest(methodName, specification);

        return specification;
    }

    private void logRequest(String method, FilterableRequestSpecification specification) {
        log.info(REQUEST_START);
        log.info(method + " " + specification.getURI());
        specification.getHeaders().forEach(header -> log.info(header.getName() + ": " + header.getValue()));

        if (!specification.getBody().equals(EMPTY_REQUEST_SPECIFICATION_BODY)) {
            try {
                log.info(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectMapper.readValue(specification.getBody().toString(), Object.class)));
            } catch (JsonProcessingException e) {
                throw new IllegalStateException("Unable to write request body to String!", e);
            }
        }
        log.info(REQUEST_END);
    }
}
