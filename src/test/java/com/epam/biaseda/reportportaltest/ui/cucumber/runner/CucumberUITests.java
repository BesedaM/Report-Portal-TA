package com.epam.biaseda.reportportaltest.ui.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/feature"},
        glue = {"com.epam.biaseda.reportportaltest.ui.cucumber.hook",
                "com.epam.biaseda.reportportaltest.ui.cucumber.step"},
        plugin = {"pretty",
                "html:target/report/report.html"}
)
public class CucumberUITests extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
