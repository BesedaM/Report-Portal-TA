package com.epam.biaseda.reportportaltest.api.service;

import com.epam.biaseda.reportportaltest.api.model.WidgetPostObject;
import io.restassured.response.ValidatableResponse;

public interface WidgetsService {

    String POST_WIDGET_URI = "/api/v1/{projectName}/widget";
    String GET_WIDGETS_URI = "/api/v1/{projectName}/widget/{widgetId}";

    ValidatableResponse getWidget(String projectName,
                                  int widgetId);

    ValidatableResponse postWidget(String projectName,
                                   WidgetPostObject widget);

}
