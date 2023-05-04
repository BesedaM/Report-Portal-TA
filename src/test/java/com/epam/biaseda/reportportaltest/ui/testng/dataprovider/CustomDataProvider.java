package com.epam.biaseda.reportportaltest.ui.testng.dataprovider;

import com.epam.biaseda.reportportaltest.core.datareader.ExcelDataReader;
import org.testng.annotations.DataProvider;

public class CustomDataProvider {

    private static final String WIDGET_TYPES_WORKSHEET = "WIDGET_TYPES";
    private static final String WIZARD_STEPS_01_WORKSHEET = "WIZARD_STEPS_01";
    private static final String WIZARD_STEPS_02_WORKSHEET = "WIZARD_STEPS_02";
    private static final String WIZARD_STEPS_03_WORKSHEET = "WIZARD_STEPS_03";

    private CustomDataProvider() {
    }

    @DataProvider(name = "widgetTypes")
    public static Object[][] getWidgetTypes() {
        return ExcelDataReader.init(WIDGET_TYPES_WORKSHEET).readTableData();
    }

    @DataProvider(name = "wizardStepsStep01", parallel = true)
    public static Object[][] getWizardSteps01() {
        return ExcelDataReader.init(WIZARD_STEPS_01_WORKSHEET).readTableData();
    }

    @DataProvider(name = "wizardStepsStep02", parallel = true)
    public static Object[][] getWizardSteps02() {
        return ExcelDataReader.init(WIZARD_STEPS_02_WORKSHEET).readTableData();
    }

    @DataProvider(name = "wizardStepsStep03", parallel = true)
    public static Object[][] getWizardSteps03() {
        return ExcelDataReader.init(WIZARD_STEPS_03_WORKSHEET).readTableData();
    }
}
