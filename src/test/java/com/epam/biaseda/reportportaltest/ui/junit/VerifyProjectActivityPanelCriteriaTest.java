package com.epam.biaseda.reportportaltest.ui.junit;

import com.epam.biaseda.reportportaltest.ui.logic.LoginServiceUILogic;
import com.epam.biaseda.reportportaltest.ui.service.*;
import com.epam.biaseda.reportportaltest.ui.validation.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

@Feature("Widgets")
@Story("[UI] Verify Project Activity Panel Criteria Test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VerifyProjectActivityPanelCriteriaTest extends BaseJUnitUITest {

    private final String DASHBOARD_TITLE = "DEMO DASHBOARD";
    private final String WIDGET_TYPE = "Project activity panel";

    @Test
    @DisplayName("login to Report Portal")
    @Order(1)
    public void login() {
        LoginServiceUILogic.login();
        DashboardsUIValidation.checkDashboardsTableNotEmpty();
    }

    @Test
    @DisplayName("open Dashboards page and validate it")
    @Order(2)
    public void openDashboardsPage() {
        DashboardsUIService.openDashboard(DASHBOARD_TITLE);
        DashboardUIValidation.checkDashboardsTableNotEmpty();
    }

    @Test
    @DisplayName("open Add New Widget Lightbox")
    @Order(3)
    public void openAddNewWidgetLightbox() {
        DashboardUIService.addNewWidget();
        AddNewWidgetLightboxBaseValidation.validateLightboxHeader();
    }

    @Test
    @DisplayName("select widget type and go to next step")
    @Order(4)
    public void selectWidgetType() {
        SelectWidgetTypeUIService.selectWidgetType(WIDGET_TYPE);
        SelectWidgetTypeUIService.goToNextStep();
        ProjectActivityPanelUIService.openCriteriaForWidgetDropdown();
    }

    @ParameterizedTest
    @DisplayName("verify criteria for 'Project activity panel' widget")
    @Order(5)
    @CsvFileSource(resources = "/data/project_activity_panel_criteria.csv", delimiter = ';')
    public void verifyCriteriaForWidget(String menuItem) {
        ProjectActivityPanelUIValidation.verifyCriteriaForWidgetDropdownMenu(menuItem);
    }
}
