package com.epam.biaseda.reportportaltest.api.model;

import com.epam.biaseda.reportportaltest.api.model.part.ContentParameters;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@Getter
public class WidgetPostObject implements Serializable {

    private ContentParameters contentParameters;

    private String description;

    private List<Integer> filterIds;

    private String name;

    private Boolean share;

    private String widgetType;
}
