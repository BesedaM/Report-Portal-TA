package com.epam.biaseda.reportportaltest.api.client;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;

public class RestAssuredResponseConverter {

    private static final CustomLogger log = CustomLoggerProvider.getLogger();
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static CustomResponse convertToCustomResponse(Response response) {
        MultiValuedMap<String, String> headersMap = new ArrayListValuedHashMap<>();
        for (Header header : response.getHeaders()) {
            headersMap.put(header.getName(), header.getValue());
        }
        log.info(response.getStatusLine());
        headersMap.entries().forEach(entry -> log.info(entry.getKey() + ": " + entry.getValue()));

        String responseEntity = response.getBody().asString();
        try {
            log.info(OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(OBJECT_MAPPER.readValue(responseEntity, Object.class)));
        } catch (JsonProcessingException e) {
            throw new IllegalStateException("Unable to parse String to Object!", e);
        }

        return CustomResponse.builder()
                .statusCode(response.getStatusCode())
                .statusText(response.getStatusLine())
                .headers(headersMap)
                .body(responseEntity)
                .build();
    }
}
