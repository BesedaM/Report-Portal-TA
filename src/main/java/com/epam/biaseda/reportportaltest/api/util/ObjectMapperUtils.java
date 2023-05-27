package com.epam.biaseda.reportportaltest.api.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ObjectMapperUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String getEntityAsJson(Object entity) {
        String stringEntity;

        try {
            stringEntity = mapper.writeValueAsString(entity);
        } catch (JsonProcessingException e) {
            throw new UnsupportedOperationException("Unable to get JSON string from entity!", e);
        }

        return stringEntity;
    }

    public static <T> T getEntityFromString(String jsonString, Class<T> expectedClass) {
        T entity;
        try {
            entity = mapper.readValue(jsonString, expectedClass);
        } catch (JsonProcessingException e) {
            throw new UnsupportedOperationException("Unable to get entity from JSON string!", e);
        }

        return entity;
    }

    public static Object getEntityFromString(String jsonString, JavaType javaType) {
        Object entity;
        try {
            entity = mapper.readValue(jsonString, javaType);
        } catch (JsonProcessingException e) {
            throw new UnsupportedOperationException("Unable to get entity from JSON string!", e);
        }

        return entity;
    }

    public static String getPrettyStringFromEntity(String stringEntity) {
        String prettyString;
        try {
            prettyString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapper.readValue(stringEntity, Object.class));
        } catch (IOException e) {
            throw new IllegalStateException("Unable to parse HttpEntity to String!", e);
        }
        return prettyString;
    }

    public static <T, E> JavaType constructType(Class<T> outerClass, Class<E> innerClass) {
        return mapper.getTypeFactory().constructParametricType(outerClass, innerClass);
    }
}
