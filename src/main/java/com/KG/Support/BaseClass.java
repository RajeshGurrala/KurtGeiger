package com.KG.Support;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import java.io.IOException;

public class BaseClass {

    public static WebDriver driver;
    WebModel webModel =new WebModel();

    @Before
    public void startUp() {
        try {
            driver = webModel.getUtils().browser();
          driver.get(webModel.getUtils().getProperty("url"));
            driver.manage().window().maximize();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
          webModel.getUtils().captureScreenShot(scenario.getName());
       }
        driver.close();
        driver.quit();
    }
}