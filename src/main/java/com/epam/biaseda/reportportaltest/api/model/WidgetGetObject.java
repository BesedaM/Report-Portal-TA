package com.epam.biaseda.reportportaltest.api.model;

import com.epam.biaseda.reportportaltest.api.model.part.Content;
import com.epam.biaseda.reportportaltest.api.model.part.ContentParameters;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class WidgetGetObject implements Serializable {

    private int id;

    private List<Object> appliedFilters;

    private String name;

    private String owner;

    private Boolean share;

    private String widgetType;

    private ContentParameters contentParameters;

    private Content content;
}
