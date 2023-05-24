package com.epam.biaseda.reportportaltest.api.client;

import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.ArrayListValuedHashMap;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ResponseConverter {

    private static final CustomLogger log = CustomLoggerProvider.getLogger();
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static CustomResponse convertToCustomResponse(CloseableHttpResponse response) throws IOException {
        MultiValuedMap<String, String> headersMap = new ArrayListValuedHashMap<>();
        for (Header header : response.getAllHeaders()) {
            headersMap.putAll(header.getName(), Arrays.stream(header.getElements()).map(HeaderElement::getValue).collect(Collectors.toList()));
        }

        String responseEntity = EntityUtils.toString(response.getEntity());
        log.info(OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(OBJECT_MAPPER.readValue(responseEntity, Object.class)));

        return CustomResponse.builder()
                .statusCode(response.getStatusLine().getStatusCode())
                .statusText(response.getStatusLine().getReasonPhrase())
                .headers(headersMap)
                .body(responseEntity)
                .build();
    }

//    public static <T> CustomResponse<T> convertToCustomResponse(CloseableHttpResponse response, Class<T> responseType) throws IOException {
//        MultiValuedMap<String, String> headersMap = new ArrayListValuedHashMap<>();
//        for (Header header : response.getAllHeaders()) {
//            headersMap.putAll(header.getName(), Arrays.stream(header.getElements()).map(HeaderElement::getValue).collect(Collectors.toList()));
//        }
//
//        String responseEntity = EntityUtils.toString(response.getEntity());
//        log.info(OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(OBJECT_MAPPER.readValue(responseEntity, Object.class)));
//
//        return CustomResponse.<T>builder()
//                .statusCode(response.getStatusLine().getStatusCode())
//                .statusText(response.getStatusLine().getReasonPhrase())
//                .headers(headersMap)
//                .body(OBJECT_MAPPER.readValue(responseEntity, responseType))
//                .build();
//    }
}
