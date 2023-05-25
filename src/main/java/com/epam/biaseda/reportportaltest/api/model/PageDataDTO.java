package com.epam.biaseda.reportportaltest.api.model;

import com.epam.biaseda.reportportaltest.api.model.part.PageInfo;
import lombok.Getter;

import java.util.List;

@Getter
public class PageDataDTO <T> {

    private List<T> content;

    private PageInfo page;
}
