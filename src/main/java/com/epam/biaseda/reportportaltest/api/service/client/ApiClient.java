package com.epam.biaseda.reportportaltest.api.service.client;

import com.epam.biaseda.reportportaltest.api.service.response.CustomResponse;

import java.util.Map;

public interface ApiClient {

    CustomResponse doGetRequest(String url,
                                Map<String, String> pathSegments,
                                Map<String, String> parameters);

    CustomResponse doPostRequest(String url,
                                 Object entity,
                                 Map<String, String> pathSegments,
                                 Map<String, String> parameters);

    CustomResponse doDeleteRequest(String url,
                                   Map<String, String> pathSegments,
                                   Map<String, String> parameters);

    CustomResponse doPutRequest(String url,
                                Object entity,
                                Map<String, String> pathSegments,
                                Map<String, String> parameters);
}
