package com.epam.biaseda.reportportaltest.api.clientapi;

import com.epam.biaseda.reportportaltest.api.client.CustomResponse;
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

    private int existingWidgetId = 31;

    private String unknownWidgetType = "111";

    private String unknownProjectName = "111_111";

    private WidgetDTO originalEntity;

    @BeforeClass
    public void getEntityToUpdate() {
        CustomResponse response = widgetsService.getWidget(projectName, existingWidgetId);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Unexpected status code!");

        originalEntity = ObjectMapperUtils.getEntityFromString(response.getBody(), WidgetDTO.class);
    }

    @Test(description = "PUT widget and verify updated field")
    public void putWidgetTest() {
        WidgetDTO copyEntity = CopyUtils.copy(originalEntity);
        copyEntity.setDescription(RandomStringUtils.randomAlphanumeric(25));

        CustomResponse response = widgetsService.putWidget(projectName, existingWidgetId, copyEntity);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Unexpected status code!");

        InfoMessageDTO infoMessage = ObjectMapperUtils.getEntityFromString(response.getBody(), InfoMessageDTO.class);
        Assert.assertTrue(infoMessage.getMessage().contains(String.valueOf(existingWidgetId)));
    }

    @Test(description = "PUT widget with unknown widget type")
    public void updateWidgetWithUnknownTypeTest() {
        WidgetDTO copyEntity = CopyUtils.copy(originalEntity);
        copyEntity.setWidgetType(unknownWidgetType);

        CustomResponse response = widgetsService.putWidget(projectName, existingWidgetId, copyEntity);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST, "Unexpected status code!");

        ErrorMessageDTO errorMessage = ObjectMapperUtils.getEntityFromString(response.getBody(), ErrorMessageDTO.class);
        Assert.assertEquals(errorMessage.getErrorCode(), HttpStatus.SC_BAD_REQUEST);
    }

    @Test(description = "PUT widget providing unknown project name in path")
    public void updateWidgetForWrongProjectTest() {
        WidgetDTO copyEntity = CopyUtils.copy(originalEntity);

        CustomResponse response = widgetsService.putWidget(unknownProjectName, existingWidgetId, copyEntity);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST, "Unexpected status code!");

        ErrorMessageDTO errorMessage = ObjectMapperUtils.getEntityFromString(response.getBody(), ErrorMessageDTO.class);
        Assert.assertEquals(errorMessage.getErrorCode(), HttpStatus.SC_BAD_REQUEST);
    }
}
