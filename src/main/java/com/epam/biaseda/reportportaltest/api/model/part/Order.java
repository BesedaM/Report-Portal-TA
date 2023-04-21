package com.epam.biaseda.reportportaltest.api.model.part;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Order {

    private String sortingColumn;

    @JsonProperty("isAsc")
    private Boolean isAscending;
}
