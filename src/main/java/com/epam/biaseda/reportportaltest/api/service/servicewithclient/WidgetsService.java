package com.epam.biaseda.reportportaltest.api.service.servicewithclient;

import com.epam.biaseda.reportportaltest.api.client.CustomResponse;
import com.epam.biaseda.reportportaltest.api.model.WidgetEntity;

public interface WidgetsService {

    String PROJECT_NAME = "{projectName}";

    String WIDGET_ID = "{widgetId}";

    String POST_WIDGET_URI = "/api/v1/{projectName}/widget";
    String GET_WIDGETS_URI = "/api/v1/{projectName}/widget/{widgetId}";
    String PUT_WIDGET_URI = "/api/v1/{projectName}/widget/{widgetId}";

    CustomResponse getWidget(String projectName,
                             int widgetId);

    CustomResponse postWidget(String projectName,
                              WidgetEntity widget);

    CustomResponse putWidget(String projectName,
                             int widgetId,
                             WidgetEntity widget);

}
