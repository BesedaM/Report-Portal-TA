package com.epam.biaseda.reportportaltest.api.clientapi;


import com.epam.biaseda.reportportaltest.api.client.CustomResponse;
import com.epam.biaseda.reportportaltest.api.util.ObjectMapperUtils;
import com.epam.biaseda.reportportaltest.api.model.ErrorMessage;
import com.epam.biaseda.reportportaltest.api.model.WidgetEntity;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Feature("Widget API")
@Story("[API] GET Widget Test")
public class GetWidgetTest extends BaseWidgetApiTest {

    private static final int EXISTING_WIDGET_ID = 3;
    private static final String WIDGET_OWNER = "default";

    private static final int NON_EXISTING_WIDGET_ID = 3333;

    @Test(description = "GET existing widget and verify some of it data")
    public void getExistingWidgetTest() {
        CustomResponse response = widgetsService.getWidget(PROJECT_NAME, EXISTING_WIDGET_ID);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Unexpected status code!");

        WidgetEntity widget = ObjectMapperUtils.getEntityFromString(response.getBody(), WidgetEntity.class);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(widget.getId(), EXISTING_WIDGET_ID);
        softAssert.assertEquals(widget.getWidgetType(), "statisticTrend");
        softAssert.assertEquals(widget.getOwner(), WIDGET_OWNER);
        softAssert.assertAll();
    }

    @Test(description = "GET non existing widget and verify some of it data")
    public void getNonExistingWidgetTest() {
        CustomResponse response = widgetsService.getWidget(PROJECT_NAME, NON_EXISTING_WIDGET_ID);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND, "Unexpected status code!");

        ErrorMessage errorMessage = ObjectMapperUtils.getEntityFromString(response.getBody(), ErrorMessage.class);
        Assert.assertEquals(errorMessage.getErrorCode(), HttpStatus.SC_NOT_FOUND);
    }

}
