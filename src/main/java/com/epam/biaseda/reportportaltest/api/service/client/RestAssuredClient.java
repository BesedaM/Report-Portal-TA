package com.epam.biaseda.reportportaltest.api.service.client;

import com.epam.biaseda.reportportaltest.api.service.response.CustomResponse;
import com.epam.biaseda.reportportaltest.api.service.response.RestAssuredResponseConverter;
import com.epam.biaseda.reportportaltest.api.util.ObjectMapperUtils;
import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.core.property.ApplicationPropertyService;
import com.epam.biaseda.reportportaltest.core.property.SecurityPropertyService;
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
                getRequestSpecification(url, pathSegments, parameters, null, METHOD_DELETE)
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
        log.info(ObjectMapperUtils.getPrettyStringFromEntity(customResponse.getBody()));
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

        baseRequestSpecBuilder.setBody(ObjectMapperUtils.getEntityAsJson(entity));

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
            log.info(ObjectMapperUtils.getPrettyStringFromEntity(specification.getBody().toString()));
        }
        log.info(REQUEST_END);
    }
}
