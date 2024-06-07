package org.erp.ui.pages;

import org.erp.ui.webdriver.FactoryDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.erp.ui.configuration.UIConfiguration.BROWSER;
import static org.erp.ui.configuration.UIConfiguration.URL;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() throws Exception {
        this.driver = FactoryDriver.getWebDriver(BROWSER);
    }

    public void initialize() {
        this.driver.manage().window().maximize();
        this.driver.navigate().to(URL);
    }

    public WebDriver getDriver(){
        return driver;
    }

}
