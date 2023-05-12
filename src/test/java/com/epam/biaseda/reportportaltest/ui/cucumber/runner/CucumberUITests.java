package com.epam.biaseda.reportportaltest.ui.cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/cucumber.feature"},
        glue = {"com.epam.biaseda.reportportaltest.ui.cucumber.hook",
                "com.epam.biaseda.reportportaltest.ui.cucumber.step"},
        plugin = {"pretty",
                "com.epam.biaseda.reportportaltest.ui.cucumber.runner.listener.CucumberTestListener",
                "html:target/report/report.html"}
)
public class CucumberUITests extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
