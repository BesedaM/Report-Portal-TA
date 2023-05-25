package com.epam.biaseda.reportportaltest.api.service.servicewithclient;

import com.epam.biaseda.reportportaltest.api.client.ApiClientHolder;
import com.epam.biaseda.reportportaltest.api.client.CustomResponse;
import com.epam.biaseda.reportportaltest.api.model.WidgetDTO;
import com.epam.biaseda.reportportaltest.core.property.ApplicationPropertyService;

import java.util.HashMap;
import java.util.Map;

public class WidgetsServiceImpl implements WidgetsService {

    @Override
    public CustomResponse getWidget(String projectName, int widgetId) {
        Map<String, String> pathSegments = new HashMap<>();
        pathSegments.put(PROJECT_NAME, projectName);
        pathSegments.put(WIDGET_ID, String.valueOf(widgetId));

        String url = ApplicationPropertyService.defineApplicationUrl() + GET_WIDGETS_URI;
        return ApiClientHolder.getApiClient().doGetRequest(url, pathSegments, null);
    }

    @Override
    public CustomResponse postWidget(String projectName, WidgetDTO widget) {
        Map<String, String> pathSegments = new HashMap<>();
        pathSegments.put(PROJECT_NAME, projectName);

        String url = ApplicationPropertyService.defineApplicationUrl() + POST_WIDGET_URI;
        return ApiClientHolder.getApiClient().doPostRequest(url, widget, pathSegments, null);
    }

    @Override
    public CustomResponse putWidget(String projectName, int widgetId, WidgetDTO widget) {
        Map<String, String> pathSegments = new HashMap<>();
        pathSegments.put(PROJECT_NAME, projectName);
        pathSegments.put(WIDGET_ID, String.valueOf(widgetId));

        String url = ApplicationPropertyService.defineApplicationUrl() + PUT_WIDGET_URI;
        return ApiClientHolder.getApiClient().doPutRequest(url, widget, pathSegments, null);
    }

    @Override
    public CustomResponse getWidgetNames(String projectName) {
        Map<String, String> pathSegments = new HashMap<>();
        pathSegments.put(PROJECT_NAME, projectName);

        String url = ApplicationPropertyService.defineApplicationUrl() + GET_WIDGET_NAMES_URI;
        return ApiClientHolder.getApiClient().doGetRequest(url, pathSegments, null);
    }
}
