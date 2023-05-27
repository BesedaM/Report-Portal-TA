package com.epam.biaseda.reportportaltest.api.client;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class HttpResponseConverter {

    public static CustomResponse convertToCustomResponse(CloseableHttpResponse response) {
        MultiValuedMap<String, String> headersMap = new ArrayListValuedHashMap<>();
        for (Header header : response.getAllHeaders()) {
            headersMap.put(header.getName(),
                    Arrays.stream(header.getElements()).map(HeaderElement::getName).collect(Collectors.toList()).toString());
        }

        String responseEntity = null;
        try {
            responseEntity = EntityUtils.toString(response.getEntity());
        } catch (IOException e) {
            throw new IllegalStateException("Unable to parse Http Response Entity to String!", e);
        }

        return CustomResponse.builder()
                .statusCode(response.getStatusLine().getStatusCode())
                .statusText(response.getStatusLine().getReasonPhrase())
                .headers(headersMap)
                .body(responseEntity)
                .build();
    }
}
