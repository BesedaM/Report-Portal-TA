package com.epam.biaseda.reportportaltest.api.model;

import com.epam.biaseda.reportportaltest.api.model.part.Content;
import com.epam.biaseda.reportportaltest.api.model.part.ContentParameters;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_ABSENT)
public class WidgetEntity implements Serializable {

    private int id;

    private List<Integer> filterIds;

    private List<Object> appliedFilters;

    private String name;

    private String description;

    private String owner;

    private Boolean share;

    private String widgetType;

    private ContentParameters contentParameters;

    private Content content;
}
