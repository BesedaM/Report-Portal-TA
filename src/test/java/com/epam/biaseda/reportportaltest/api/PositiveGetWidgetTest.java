package com.epam.biaseda.reportportaltest.api;

import com.epam.biaseda.reportportaltest.api.model.WidgetEntity;
import com.epam.biaseda.reportportaltest.api.service.WidgetsService;
import com.epam.biaseda.reportportaltest.api.service.WidgetsServiceImpl;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Feature("Widget API")
@Story("[API] Positive GET Widget Test")
public class PositiveGetWidgetTest extends BaseAPITest {

    private WidgetsService widgetsService = new WidgetsServiceImpl();

    private int widgetId = 3;

    @Test(description = "GET existing widget and verify some of it data")
    public void getExistingWidgetTest() {
        ValidatableResponse response = widgetsService.getWidget(projectName, widgetId);
        response.statusCode(HttpStatus.SC_OK);

        WidgetEntity widget = response.extract().as(WidgetEntity.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(widget.getId(), widgetId);
        softAssert.assertEquals(widget.getWidgetType(), "statisticTrend");
        softAssert.assertEquals(widget.getOwner(), "default");
        softAssert.assertAll();
    }

}
