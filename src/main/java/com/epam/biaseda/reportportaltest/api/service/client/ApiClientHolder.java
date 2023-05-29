package com.epam.biaseda.reportportaltest.api.service.client;

public class ApiClientHolder {

    private static ApiClient API_CLIENT = null;

    private ApiClientHolder() {
    }

    public static ApiClient getApiClient() {
        if (API_CLIENT == null) {
            API_CLIENT = HttpClient.createHttpClient();
        }
        return API_CLIENT;
    }
}
