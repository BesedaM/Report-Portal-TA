package com.epam.biaseda.reportportaltest.api.service;

import com.epam.biaseda.reportportaltest.api.model.WidgetPostObject;
import com.epam.biaseda.reportportaltest.core.util.ApplicationPropertyService;
import io.restassured.authentication.OAuth2Scheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class WidgetsServiceImpl implements WidgetsService {

    @Override
    public ValidatableResponse getWidget(String projectName,
                                         int widgetId,
                                         String login,
                                         String password) {

        OAuth2Scheme authenticationScheme = new OAuth2Scheme();
        authenticationScheme.setAccessToken("3e4338fd-96b4-441e-ad63-682101246568");

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setContentType("application/json; charset=UTF-8");
        builder.setAuth(authenticationScheme);
        builder.setBaseUri(ApplicationPropertyService.defineApplicationUrl());
        builder.setBasePath(GET_WIDGETS_URI);
        builder.addPathParam("projectName", projectName);
        builder.addPathParam("widgetId", widgetId);
        RequestSpecification requestSpec = builder.build();
        requestSpec.log().all();

        return given()
                .spec(requestSpec)
                .when()
                .get()
                .then()
                .log().body();
    }

    @Override
    public ValidatableResponse postWidget(String projectName,
                                          WidgetPostObject widget,
                                          String logic,
                                          String password) {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setBody(widget);
        builder.addParam("projectName", projectName);
        builder.setContentType("application/json; charset=UTF-8");
        RequestSpecification requestSpec = builder.build();

        String uri = ApplicationPropertyService.defineApplicationUrl() + POST_WIDGET_URI;

        return given()
                .auth()
                .basic(logic, password)
                .spec(requestSpec)
                .when()
                .post(uri)
                .then()
                .log().all();
    }
}
