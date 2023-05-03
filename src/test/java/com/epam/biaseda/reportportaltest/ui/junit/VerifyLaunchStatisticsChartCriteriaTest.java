package com.epam.biaseda.reportportaltest.ui.junit;

import com.epam.biaseda.reportportaltest.ui.logic.LoginServiceUILogic;
import com.epam.biaseda.reportportaltest.ui.service.LaunchStatisticsChartUIService;
import com.epam.biaseda.reportportaltest.ui.service.DashboardUIService;
import com.epam.biaseda.reportportaltest.ui.service.DashboardsUIService;
import com.epam.biaseda.reportportaltest.ui.service.SelectWidgetTypeUIService;
import com.epam.biaseda.reportportaltest.ui.validation.AddNewWidgetLightboxBaseValidation;
import com.epam.biaseda.reportportaltest.ui.validation.LaunchStatisticsChartUIValidation;
import com.epam.biaseda.reportportaltest.ui.validation.DashboardUIValidation;
import com.epam.biaseda.reportportaltest.ui.validation.DashboardsUIValidation;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;

@Feature("Widgets")
@Story("[UI] Verify Launch Statistics Chart Criteria Test")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VerifyLaunchStatisticsChartCriteriaTest extends BaseJUnitUITest {

    private final String DASHBOARD_TITLE = "DEMO DASHBOARD";
    private final String WIDGET_TYPE = "Launch statistics chart";

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
        LaunchStatisticsChartUIService.openCriteriaForWidgetDropdown();
    }

    @ParameterizedTest
    @DisplayName("verify criteria for 'Launch statistics chart' widget")
    @Order(5)
    @CsvFileSource(resources = "/data/launch_statistics_chart_criteria.csv")
    public void verifyCriteriaForWidget(String menuItem) {
        LaunchStatisticsChartUIValidation.verifyCriteriaForWidgetDropdownMenu(menuItem);
    }
}
