package com.epam.biaseda.reportportaltest.core.util;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Objects;

public class CopyUtils {

    public static <T> T copy(T original) {
        Objects.requireNonNull(original, "Unable to copy 'null' object!");

        try {
            return (T) BeanUtils.cloneBean(original);
        } catch (ReflectiveOperationException exception) {
            throw new IllegalStateException(
                    String.format("Unable to create copy of '%s' object!", original.getClass().getSimpleName()), exception);
        }
    }
}
