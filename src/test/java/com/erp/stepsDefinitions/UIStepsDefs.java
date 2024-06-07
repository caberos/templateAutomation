package com.erp.stepsDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.erp.ui.pages.BasePage;
import org.erp.ui.pages.HomePage;

public class UIStepsDefs {

    HomePage homePage;

    @When("open the page")
    public void openThePage() throws Exception {
        homePage = new HomePage();
        homePage.initialize();
    }

    @Then("close the browser")
    public void closeTheBrowser() throws InterruptedException {
        homePage.getDriver().close();
    }
}
