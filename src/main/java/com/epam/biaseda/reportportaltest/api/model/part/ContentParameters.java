package com.epam.biaseda.reportportaltest.api.model.part;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContentParameters {

    private List<String> contentFields;

    private WidgetOptions widgetOptions;

    private int itemsCount;
}
