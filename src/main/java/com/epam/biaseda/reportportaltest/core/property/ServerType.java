package com.epam.biaseda.reportportaltest.core.property;

public enum ServerType {
    LOCAL, REMOTE;

    public static ServerType getValueFromString(String type) {
        return valueOf(type.toUpperCase());
    }
}
