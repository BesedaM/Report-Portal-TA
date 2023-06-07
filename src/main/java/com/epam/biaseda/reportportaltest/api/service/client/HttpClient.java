package com.epam.biaseda.reportportaltest.api.service.client;

import com.epam.biaseda.reportportaltest.api.service.response.CustomResponse;
import com.epam.biaseda.reportportaltest.api.service.response.HttpResponseConverter;
import com.epam.biaseda.reportportaltest.api.util.ObjectMapperUtils;
import com.epam.biaseda.reportportaltest.core.logger.CustomLogger;
import com.epam.biaseda.reportportaltest.core.logger.CustomLoggerProvider;
import com.epam.biaseda.reportportaltest.core.property.ApplicationPropertyService;
import com.epam.biaseda.reportportaltest.core.property.SecurityPropertyService;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static com.epam.biaseda.reportportaltest.api.util.LoggingConstants.*;

class HttpClient implements ApiClient {

    private static final List<String> METHODS_WITH_BODY = Arrays.asList("POST", "PUT");
    private static CustomLogger log = CustomLoggerProvider.getLogger();

    private static HttpClient client = null;

    private HttpClient() {
    }

    public static HttpClient createHttpClient() {
        if (client == null) {
            client = new HttpClient();
        }
        return client;
    }

    @Override
    public CustomResponse doGetRequest(String url,
                                       Map<String, String> pathSegments,
                                       Map<String, String> parameters) {
        HttpGet request = new HttpGet(ApplicationPropertyService.defineApplicationUrl() +
                prepareUrlWithPathSegments(url, pathSegments) + getParametersString(parameters));
        return doRequest(request);
    }

    @Override
    public CustomResponse doPostRequest(String url,
                                        Object entity,
                                        Map<String, String> pathSegments,
                                        Map<String, String> parameters) {
        HttpPost request = new HttpPost(ApplicationPropertyService.defineApplicationUrl() +
                prepareUrlWithPathSegments(url, pathSegments) + getParametersString(parameters));

        try {
            request.setEntity(new StringEntity(ObjectMapperUtils.getEntityAsJson(entity)));
        } catch (UnsupportedEncodingException exception) {
            throw new IllegalStateException(exception);
        }
        return doRequest(request);
    }

    @Override
    public CustomResponse doDeleteRequest(String url,
                                          Map<String, String> pathSegments,
                                          Map<String, String> parameters) {
        HttpDelete request = new HttpDelete(ApplicationPropertyService.defineApplicationUrl() +
                prepareUrlWithPathSegments(url, pathSegments) + getParametersString(parameters));
        return doRequest(request);
    }

    @Override
    public CustomResponse doPutRequest(String url,
                                       Object entity,
                                       Map<String, String> pathSegments,
                                       Map<String, String> parameters) {
        HttpPut request = new HttpPut(ApplicationPropertyService.defineApplicationUrl() +
                prepareUrlWithPathSegments(url, pathSegments) + getParametersString(parameters));
        try {
            request.setEntity(new StringEntity(ObjectMapperUtils.getEntityAsJson(entity)));
        } catch (UnsupportedEncodingException exception) {
            throw new IllegalStateException(exception);
        }
        return doRequest(request);
    }

    private CustomResponse doRequest(HttpUriRequest httpUriRequest) {
        CustomResponse customResponse;

        setDefaultHeaders(httpUriRequest);
        logRequest(httpUriRequest);

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(httpUriRequest)) {
            customResponse = HttpResponseConverter.convertToCustomResponse(response);
            logResponse(customResponse);
        } catch (IOException exception) {
            throw new IllegalStateException("Exception was thrown while performing the request!", exception);
        }
        return customResponse;
    }

    private void setDefaultHeaders(HttpUriRequest httpUriRequest) {
        httpUriRequest.setHeader(HttpHeaders.AUTHORIZATION, "Bearer " + SecurityPropertyService.ACCESS_TOKEN);
        httpUriRequest.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
    }

    private void logRequest(HttpUriRequest httpUriRequest) {
        log.info(REQUEST_START);
        log.info(httpUriRequest.getProtocolVersion() + " " + httpUriRequest.getMethod() + " " + httpUriRequest.getURI());
        Arrays.stream(httpUriRequest.getAllHeaders()).forEach(header -> log.info(header.toString()));
        if (METHODS_WITH_BODY.contains(httpUriRequest.getMethod())) {
            try {
                String stringEntity = EntityUtils.toString(((HttpEntityEnclosingRequestBase) httpUriRequest).getEntity());
                log.info(ObjectMapperUtils.getPrettyStringFromEntity(stringEntity));
            } catch (IOException e) {
                throw new IllegalStateException("Unable to parse HttpEntity to String!", e);
            }
        }
        log.info(REQUEST_END);
    }

    private void logResponse(CustomResponse customResponse) {
        log.info(RESPONSE_START);
        customResponse.getHeaders().entries().forEach(header -> log.info(header.getKey() + ": " + header.getValue()));
        log.info(ObjectMapperUtils.getPrettyStringFromEntity(customResponse.getBody()));
        log.info(RESPONSE_END);
    }

    private String prepareUrlWithPathSegments(String url,
                                              Map<String, String> pathSegments) {
        String resultUrl = url;
        if (pathSegments != null) {
            for (Map.Entry<String, String> entry : pathSegments.entrySet()) {
                resultUrl = resultUrl.replace(getHttpClientPathParameter(entry.getKey()), entry.getValue());
            }
        }
        return resultUrl;
    }

    private String getParametersString(Map<String, String> parameters) {
        if (parameters != null && !parameters.isEmpty()) {
            List<NameValuePair> params = new ArrayList<>();
            parameters.forEach((key, value) -> params.add(new BasicNameValuePair(key, value)));
            return '?' + URLEncodedUtils.format(params, "UTF-8");
        } else {
            return "";
        }
    }

    private String getHttpClientPathParameter(String pathParam) {
        return '{' + pathParam + '}';
    }
}
