package com.epam.biaseda.reportportaltest.api.client;

import lombok.Builder;
import lombok.Data;
import org.apache.commons.collections4.MultiValuedMap;

@Builder
@Data
public class CustomResponse {

    private final int statusCode;
    private final String statusText;
    private final MultiValuedMap<String, String> headers;
    private final String body;

}
