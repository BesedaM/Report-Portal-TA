package com.epam.biaseda.reportportaltest.api;

import com.epam.biaseda.reportportaltest.api.service.response.CustomResponse;
import com.epam.biaseda.reportportaltest.api.model.ErrorMessageDTO;
import com.epam.biaseda.reportportaltest.api.model.InfoMessageDTO;
import com.epam.biaseda.reportportaltest.api.model.WidgetDTO;
import com.epam.biaseda.reportportaltest.api.util.ObjectMapperUtils;
import com.epam.biaseda.reportportaltest.core.util.CopyUtils;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Feature("Widget API")
@Story("[API] PUT Widget Test")
public class PutWidgetTest extends BaseWidgetApiTest {

    private static final int EXISTING_WIDGET_ID = 31;

    private static final String UNKNOWN_WIDGET_TYPE = "111";

    private static final String UNKNOWN_PROJECT_NAME = "111_111";

    private WidgetDTO originalEntity;

    @BeforeClass
    public void getEntityToUpdate() {
        CustomResponse response = widgetsService.getWidget(PROJECT_NAME, EXISTING_WIDGET_ID);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Unexpected status code!");

        originalEntity = ObjectMapperUtils.getEntityFromString(response.getBody(), WidgetDTO.class);
    }

    @Test(description = "PUT widget and verify updated field")
    public void putWidgetTest() {
        WidgetDTO copyEntity = CopyUtils.copy(originalEntity);
        copyEntity.setDescription(RandomStringUtils.randomAlphanumeric(25));

        CustomResponse response = widgetsService.putWidget(PROJECT_NAME, EXISTING_WIDGET_ID, copyEntity);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Unexpected status code!");

        InfoMessageDTO infoMessage = ObjectMapperUtils.getEntityFromString(response.getBody(), InfoMessageDTO.class);
        Assert.assertTrue(infoMessage.getMessage().contains(String.valueOf(EXISTING_WIDGET_ID)));
    }

    @Test(description = "PUT widget with unknown widget type")
    public void updateWidgetWithUnknownTypeTest() {
        WidgetDTO copyEntity = CopyUtils.copy(originalEntity);
        copyEntity.setWidgetType(UNKNOWN_WIDGET_TYPE);

        CustomResponse response = widgetsService.putWidget(PROJECT_NAME, EXISTING_WIDGET_ID, copyEntity);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST, "Unexpected status code!");

        ErrorMessageDTO errorMessage = ObjectMapperUtils.getEntityFromString(response.getBody(), ErrorMessageDTO.class);
        Assert.assertEquals(errorMessage.getErrorCode(), HttpStatus.SC_BAD_REQUEST);
    }

    @Test(description = "PUT widget providing unknown project name in path")
    public void updateWidgetForWrongProjectTest() {
        WidgetDTO copyEntity = CopyUtils.copy(originalEntity);

        CustomResponse response = widgetsService.putWidget(UNKNOWN_PROJECT_NAME, EXISTING_WIDGET_ID, copyEntity);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST, "Unexpected status code!");

        ErrorMessageDTO errorMessage = ObjectMapperUtils.getEntityFromString(response.getBody(), ErrorMessageDTO.class);
        Assert.assertEquals(errorMessage.getErrorCode(), HttpStatus.SC_BAD_REQUEST);
    }
}
