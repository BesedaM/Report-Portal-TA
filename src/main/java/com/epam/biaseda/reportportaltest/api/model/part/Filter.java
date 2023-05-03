package com.epam.biaseda.reportportaltest.api.model.part;

import lombok.Getter;

import java.util.List;

@Getter
public class Filter {

    private int id;

    private String name;

    private String owner;

    private Boolean share;

    private List<Condition> conditions;

    private List<Order> orders;

    private String type;
}
