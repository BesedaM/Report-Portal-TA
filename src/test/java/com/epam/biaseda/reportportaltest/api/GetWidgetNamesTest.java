package com.epam.biaseda.reportportaltest.api;


import com.epam.biaseda.reportportaltest.api.service.response.CustomResponse;
import com.epam.biaseda.reportportaltest.api.model.ErrorMessageDTO;
import com.epam.biaseda.reportportaltest.api.model.PageDataDTO;
import com.epam.biaseda.reportportaltest.api.util.ObjectMapperUtils;
import com.fasterxml.jackson.databind.JavaType;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Feature("Widget API")
@Story("[API] GET Widget Names Test")
public class GetWidgetNamesTest extends BaseWidgetApiTest {

    private static final String UNKNOWN_PROJECT_NAME = "111_111";

    private static final List<String> EXISTING_WIDGET_NAMES =
            Arrays.asList("LAUNCH STATISTICS AREA",
                    "LAUNCH STATISTICS BAR",
                    "INVESTIGATED PERCENTAGE OF LAUNCHES",
                    "FAILED CASES TREND CHART",
                    "LAUNCH TABLE",
                    "TEST TEST TEST");

    @Test(description = "GET widget names and verify some of them")
    public void getWidgetNamesTest() {
        CustomResponse response = widgetsService.getWidgetNames(PROJECT_NAME);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Unexpected status code!");

        JavaType type = ObjectMapperUtils.constructType(PageDataDTO.class, String.class);
        PageDataDTO<String> widgetNames = (PageDataDTO<String>) ObjectMapperUtils.getEntityFromString(response.getBody(), type);
        Assert.assertTrue(widgetNames.getContent().containsAll(EXISTING_WIDGET_NAMES),
                String.format("Actual widget names: '%s', expected to contain %s", widgetNames.getContent(), EXISTING_WIDGET_NAMES));
    }

    @Test(description = "GET widget names for unknown project")
    public void getNonExistingWidgetTest() {
        CustomResponse response = widgetsService.getWidgetNames(UNKNOWN_PROJECT_NAME);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST, "Unexpected status code!");

        ErrorMessageDTO errorMessage = ObjectMapperUtils.getEntityFromString(response.getBody(), ErrorMessageDTO.class);
        Assert.assertEquals(errorMessage.getErrorCode(), HttpStatus.SC_BAD_REQUEST);
    }

}
