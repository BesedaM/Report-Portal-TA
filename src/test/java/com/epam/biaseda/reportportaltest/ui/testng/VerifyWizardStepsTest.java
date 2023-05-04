package com.epam.biaseda.reportportaltest.ui.testng;

import com.epam.biaseda.reportportaltest.ui.logic.LoginServiceUILogic;
import com.epam.biaseda.reportportaltest.ui.page.block.WizardStep;
import com.epam.biaseda.reportportaltest.ui.service.LaunchStatisticsChartUIService;
import com.epam.biaseda.reportportaltest.ui.service.SelectWidgetTypeUIService;
import com.epam.biaseda.reportportaltest.ui.service.DashboardUIService;
import com.epam.biaseda.reportportaltest.ui.service.DashboardsUIService;
import com.epam.biaseda.reportportaltest.ui.testng.dataprovider.CustomDataProvider;
import com.epam.biaseda.reportportaltest.ui.validation.AddNewWidgetLightboxBaseValidation;
import com.epam.biaseda.reportportaltest.ui.validation.DashboardUIValidation;
import com.epam.biaseda.reportportaltest.ui.validation.DashboardsUIValidation;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

import java.util.List;

@Feature("Widgets")
@Story("[UI] Verify Widget creation Wizard steps test")
public class VerifyWizardStepsTest extends BaseUITest {

    private final String DASHBOARD_TITLE = "DEMO DASHBOARD";
    private final String WIDGET_TYPE = "Launch statistics chart";
    private final String FILTER_NAME = "DEMO_FILTER";

    private List<WizardStep> wizardStepsStep01;
    private List<WizardStep> wizardStepsStep02;
    private List<WizardStep> wizardStepsStep03;

    @Test(description = "login to Report Portal")
    public void login() {
        LoginServiceUILogic.login();
        DashboardsUIValidation.checkDashboardsTableNotEmpty();
    }

    @Test(dependsOnMethods = "login",
            description = "open Dashboards page and validate it")
    public void openDashboardsPage() {
        DashboardsUIService.openDashboard(DASHBOARD_TITLE);
        DashboardUIValidation.checkDashboardsTableNotEmpty();
    }

    @Test(dependsOnMethods = "openDashboardsPage",
            description = "open Add New Widget Lightbox")
    public void openAddNewWidgetLightbox() {
        DashboardUIService.addNewWidget();
        AddNewWidgetLightboxBaseValidation.validateLightboxHeader();
        wizardStepsStep01 = SelectWidgetTypeUIService.getWizardSteps();
    }

    @Test(dataProvider = "wizardStepsStep01", dataProviderClass = CustomDataProvider.class,
            dependsOnMethods = "openAddNewWidgetLightbox",
            description = "verify Wizard steps on Select widget Type lightbox")
    public void verifyWizardStepsOnFirstStep(String stepNumber, String name, String status) {
        AddNewWidgetLightboxBaseValidation.validateWizardSteps(wizardStepsStep01.get(Integer.parseInt(stepNumber)-1), stepNumber, name, status);
    }

    @Test(dependsOnMethods = "verifyWizardStepsOnFirstStep",
            description = "select widget type and go to next step")
    public void selectWidgetType() {
        SelectWidgetTypeUIService.selectWidgetType(WIDGET_TYPE);
        SelectWidgetTypeUIService.goToNextStep();
        AddNewWidgetLightboxBaseValidation.validateLightboxHeader();
        wizardStepsStep02 = SelectWidgetTypeUIService.getWizardSteps();
    }

    @Test(dataProvider = "wizardStepsStep02", dataProviderClass = CustomDataProvider.class,
            dependsOnMethods = "selectWidgetType",
            description = "verify Wizard steps on Configure widget Type lightbox")
    public void verifyWizardStepsOnSecondStep(String stepNumber, String name, String status) {
        AddNewWidgetLightboxBaseValidation.validateWizardSteps(wizardStepsStep02.get(Integer.parseInt(stepNumber)-1), stepNumber, name, status);
    }

    @Test(dependsOnMethods = "verifyWizardStepsOnSecondStep",
            description = "select filter and go to final step")
    public void selectFilter() {
        LaunchStatisticsChartUIService.selectFilter(FILTER_NAME);
        LaunchStatisticsChartUIService.goToNextStep();
        AddNewWidgetLightboxBaseValidation.validateLightboxHeader();
        wizardStepsStep03 = SelectWidgetTypeUIService.getWizardSteps();
    }

    @Test(dataProvider = "wizardStepsStep03", dataProviderClass = CustomDataProvider.class,
            dependsOnMethods = "selectFilter",
            description = "verify Wizard steps on Save widget Type lightbox")
    public void verifyWizardStepsOnThirdStep(String stepNumber, String name, String status) {
        AddNewWidgetLightboxBaseValidation.validateWizardSteps(wizardStepsStep03.get(Integer.parseInt(stepNumber)-1), stepNumber, name, status);
    }
}
