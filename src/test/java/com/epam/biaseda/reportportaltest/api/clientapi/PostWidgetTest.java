package com.epam.biaseda.reportportaltest.api.clientapi;

import com.epam.biaseda.reportportaltest.api.client.CustomResponse;
import com.epam.biaseda.reportportaltest.api.util.ObjectMapperUtils;
import com.epam.biaseda.reportportaltest.api.model.ErrorMessageDTO;
import com.epam.biaseda.reportportaltest.api.model.WidgetDTO;
import com.epam.biaseda.reportportaltest.api.model.part.ContentParameters;
import com.epam.biaseda.reportportaltest.api.model.part.WidgetOptions;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Feature("Widget API")
@Story("[API] POST Widget Test")
public class PostWidgetTest extends BaseWidgetApiTest {

    private String widgetType = "statisticTrend";

    private String unknownWidgetType = "111";

    private List<String> contentFields =
            Arrays.asList("statistics$executions$passed",
                    "statistics$executions$failed",
                    "statistics$executions$skipped");

    private WidgetDTO widget;

    @Test(description = "POST widget and verify some of it data")
    public void postWidgetTest() {
        widget = WidgetDTO.builder()
                .widgetType(widgetType)
                .name(RandomStringUtils.randomAlphanumeric(15))
                .description(RandomStringUtils.randomAlphanumeric(25))
                .share(false)
                .filterIds(Collections.singletonList(1))
                .contentParameters(ContentParameters.builder()
                        .widgetOptions(new WidgetOptions(true, "string", "string"))
                        .contentFields(contentFields)
                        .itemsCount(5)
                        .build())
                .build();

        CustomResponse response = widgetsService.postWidget(projectName, widget);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED, "Unexpected status code!");

        WidgetDTO widget = ObjectMapperUtils.getEntityFromString(response.getBody(), WidgetDTO.class);
        Assert.assertNotEquals(widget.getId(), 0);
    }

    @Test(description = "POST widget without Content Parameters and verify some of it data")
    public void postWidgetWithoutContentParametersTest() {
        widget = WidgetDTO.builder()
                .widgetType(widgetType)
                .name(RandomStringUtils.randomAlphanumeric(15))
                .description(RandomStringUtils.randomAlphanumeric(25))
                .share(false)
                .filterIds(Collections.singletonList(1))
                .contentParameters(null)
                .build();

        CustomResponse response = widgetsService.postWidget(projectName, widget);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST, "Unexpected status code!");

        ErrorMessageDTO errorMessage = ObjectMapperUtils.getEntityFromString(response.getBody(), ErrorMessageDTO.class);
        Assert.assertEquals(errorMessage.getErrorCode(), HttpStatus.SC_BAD_REQUEST);
    }

    @Test(description = "POST widget with unknown type and verify some of it data")
    public void postWidgetWithUnknownTypeTest() {
        widget = WidgetDTO.builder()
                .widgetType(unknownWidgetType)
                .name(RandomStringUtils.randomAlphanumeric(15))
                .description(RandomStringUtils.randomAlphanumeric(25))
                .share(false)
                .filterIds(Collections.singletonList(1))
                .contentParameters(ContentParameters.builder()
                        .widgetOptions(new WidgetOptions(true, "string", "string"))
                        .contentFields(contentFields)
                        .itemsCount(5)
                        .build())
                .build();

        CustomResponse response = widgetsService.postWidget(projectName, widget);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST, "Unexpected status code!");

        ErrorMessageDTO errorMessage = ObjectMapperUtils.getEntityFromString(response.getBody(), ErrorMessageDTO.class);
        Assert.assertEquals(errorMessage.getErrorCode(), HttpStatus.SC_BAD_REQUEST);
    }
}
