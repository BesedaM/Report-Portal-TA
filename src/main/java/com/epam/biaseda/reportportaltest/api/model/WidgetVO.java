package com.epam.biaseda.reportportaltest.api.model;

import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class WidgetVO implements Serializable {

    private int id;

    private List<Object> appliedFilters;

    private Object content;

    private Object contentParameters;

    private String name;

    private String owner;

    private Boolean share;

    private String widgetType;
}
