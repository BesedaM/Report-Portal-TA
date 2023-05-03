package com.epam.biaseda.reportportaltest.api.model.part;

import lombok.Getter;

import java.util.Date;
import java.util.Map;

@Getter
public class Result {

    private int id;

    private int number;

    private String name;

    private Date startTime;

    private Map<String, Integer> values;
}
