package com.epam.biaseda.reportportaltest.api.client;

import io.restassured.http.Header;
import io.restassured.response.Response;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

public class RestAssuredResponseConverter {

    public static CustomResponse convertToCustomResponse(Response response) {
        MultiValuedMap<String, String> headersMap = new ArrayListValuedHashMap<>();
        for (Header header : response.getHeaders()) {
            headersMap.put(header.getName(), header.getValue());
        }

        return CustomResponse.builder()
                .statusCode(response.getStatusCode())
                .statusText(response.getStatusLine())
                .headers(headersMap)
                .body(response.getBody().asString())
                .build();
    }
}
