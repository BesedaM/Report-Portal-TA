package com.epam.biaseda.reportportaltest.api.service.servicewithclient;

import com.epam.biaseda.reportportaltest.api.client.CustomResponse;
import com.epam.biaseda.reportportaltest.api.model.WidgetDTO;

public interface WidgetsService {

    String PROJECT_NAME = "{projectName}";

    String WIDGET_ID = "{widgetId}";

    String POST_WIDGET_URI = "/api/v1/{projectName}/widget";
    String GET_WIDGETS_URI = "/api/v1/{projectName}/widget/{widgetId}";
    String PUT_WIDGET_URI = "/api/v1/{projectName}/widget/{widgetId}";
    String GET_WIDGET_NAMES_URI = "/api/v1/{projectName}/widget/names/all";

    CustomResponse getWidget(String projectName,
                             int widgetId);

    CustomResponse postWidget(String projectName,
                              WidgetDTO widget);

    CustomResponse putWidget(String projectName,
                             int widgetId,
                             WidgetDTO widget);

    CustomResponse getWidgetNames(String projectName);
}
