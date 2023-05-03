package com.epam.biaseda.reportportaltest.api.model.part;

import lombok.Getter;

@Getter
public class Condition {

    private String filteringField;

    private String condition;

    private String value;
}
