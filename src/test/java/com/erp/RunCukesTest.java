package com.erp;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:build/reports/cucumber-reports.html",
                "json:target/cucumber-reports/cucumber.json", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},

        glue = {"com.erp.stepsDefinitions"},
        features = {"src/test/resources/features"},
        monochrome = true
)
public class RunCukesTest {
}