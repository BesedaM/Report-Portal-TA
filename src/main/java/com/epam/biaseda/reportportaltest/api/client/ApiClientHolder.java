package com.epam.biaseda.reportportaltest.api.client;

public class ApiClientHolder {

    private static ApiClient API_CLIENT = null;

    private ApiClientHolder() {
    }

    public static ApiClient getApiClient() {
        if (API_CLIENT == null) {
            API_CLIENT = new HttpClient();
        }
        return API_CLIENT;
    }
}
