package com.epam.biaseda.reportportaltest.api.model.part;

import lombok.Getter;

import java.util.List;

@Getter
public class ContentParameters {

    private List<String> contentFields;

    private WidgetOptions widgetOptions;

    private int itemsCount;
}
