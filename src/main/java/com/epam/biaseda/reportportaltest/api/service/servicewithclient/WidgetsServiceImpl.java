package com.epam.biaseda.reportportaltest.api.service.servicewithclient;

import com.epam.biaseda.reportportaltest.api.client.ApiClientHolder;
import com.epam.biaseda.reportportaltest.api.client.CustomResponse;
import com.epam.biaseda.reportportaltest.api.model.WidgetDTO;

import java.util.HashMap;
import java.util.Map;

public class WidgetsServiceImpl implements WidgetsService {

    @Override
    public CustomResponse getWidget(String projectName, int widgetId) {
        Map<String, String> pathSegments = new HashMap<>();
        pathSegments.put(PROJECT_NAME, projectName);
        pathSegments.put(WIDGET_ID, String.valueOf(widgetId));

        return ApiClientHolder.getApiClient().doGetRequest(GET_WIDGETS_URI, pathSegments, null);
    }

    @Override
    public CustomResponse postWidget(String projectName, WidgetDTO widget) {
        Map<String, String> pathSegments = new HashMap<>();
        pathSegments.put(PROJECT_NAME, projectName);

        return ApiClientHolder.getApiClient().doPostRequest(POST_WIDGET_URI, widget, pathSegments, null);
    }

    @Override
    public CustomResponse putWidget(String projectName, int widgetId, WidgetDTO widget) {
        Map<String, String> pathSegments = new HashMap<>();
        pathSegments.put(PROJECT_NAME, projectName);
        pathSegments.put(WIDGET_ID, String.valueOf(widgetId));

        return ApiClientHolder.getApiClient().doPutRequest(PUT_WIDGET_URI, widget, pathSegments, null);
    }

    @Override
    public CustomResponse getWidgetNames(String projectName) {
        Map<String, String> pathSegments = new HashMap<>();
        pathSegments.put(PROJECT_NAME, projectName);

        return ApiClientHolder.getApiClient().doGetRequest(GET_WIDGET_NAMES_URI, pathSegments, null);
    }
}
