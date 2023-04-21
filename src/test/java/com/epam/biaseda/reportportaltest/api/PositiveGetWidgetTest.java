package com.epam.biaseda.reportportaltest.api;

import com.epam.biaseda.reportportaltest.BaseTest;
import com.epam.biaseda.reportportaltest.api.model.WidgetGetObject;
import com.epam.biaseda.reportportaltest.api.service.WidgetsService;
import com.epam.biaseda.reportportaltest.api.service.WidgetsServiceImpl;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PositiveGetWidgetTest extends BaseTest {

    private WidgetsService widgetsService = new WidgetsServiceImpl();

    private int widgetId = 3;

    @Test
    public void getExistingWidgetTest() {
        ValidatableResponse response = widgetsService.getWidget(projectName, widgetId, username, password);
        response.statusCode(HttpStatus.SC_OK).log().everything();

        WidgetGetObject widget = response.extract().as(WidgetGetObject.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(widget.getId(), widgetId);
        softAssert.assertEquals(widget.getWidgetType(), "statisticTrend");
        softAssert.assertEquals(widget.getOwner(), "default");
        softAssert.assertAll();
    }
}
