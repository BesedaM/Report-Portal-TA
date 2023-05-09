package com.epam.biaseda.reportportaltest.ui.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/java/com/epam/biaseda/reportportaltest/ui/cucumber/feature/WidgetTypes.feature"},
        glue = {"com.epam.biaseda.reportportaltest.ui.cucumber.hook","com.epam.biaseda.reportportaltest.ui.cucumber.step"},
        plugin = {"pretty"}
)
public class WidgetTypesUITest extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
