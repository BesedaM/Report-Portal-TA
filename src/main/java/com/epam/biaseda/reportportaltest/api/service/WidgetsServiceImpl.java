package com.epam.biaseda.reportportaltest.api.service;

import com.epam.biaseda.reportportaltest.api.model.WidgetPostObject;
import com.epam.biaseda.reportportaltest.core.util.SecurityPropertyService;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class WidgetsServiceImpl extends BaseService implements WidgetsService {

    private static final String PROJECT_NAME_PATH_PARAMETER = "projectName";
    private static final String WIDGET_ID_PATH_PARAM = "widgetId";

    @Override
    public ValidatableResponse getWidget(String projectName,
                                         int widgetId,
                                         String login,
                                         String password) {
        RequestSpecBuilder baseRequestSpecBuilder = getBasicRequestSpecBuilder();
        baseRequestSpecBuilder.setBasePath(GET_WIDGETS_URI);
        baseRequestSpecBuilder.addPathParam(PROJECT_NAME_PATH_PARAMETER, projectName);
        baseRequestSpecBuilder.addPathParam(WIDGET_ID_PATH_PARAM, widgetId);
        RequestSpecification requestSpec = baseRequestSpecBuilder.build();

        return given()
                .spec(requestSpec)
                .auth().preemptive()
                .oauth2(SecurityPropertyService.ACCESS_TOKEN)
                .when()
                .get()
                .then();
    }

    @Override
    public ValidatableResponse postWidget(String projectName,
                                          WidgetPostObject widget,
                                          String logic,
                                          String password) {
        RequestSpecBuilder baseRequestSpecBuilder = getBasicRequestSpecBuilder();
        baseRequestSpecBuilder.setBasePath(POST_WIDGET_URI);
        baseRequestSpecBuilder.addPathParam(PROJECT_NAME_PATH_PARAMETER, projectName);
        baseRequestSpecBuilder.setBody(widget);
        RequestSpecification requestSpec = baseRequestSpecBuilder.build();

        return given()
                .spec(requestSpec)
                .auth().preemptive()
                .oauth2(SecurityPropertyService.ACCESS_TOKEN)
                .when()
                .post()
                .then();
    }
}
