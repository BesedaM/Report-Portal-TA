package com.epam.biaseda.reportportaltest.api.model.part;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WidgetOptions {

    private Boolean zoom;

    private String timeline;

    private String viewMode;
}
