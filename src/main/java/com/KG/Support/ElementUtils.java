package com.KG.Support;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;

import java.io.*;
import java.util.*;

import static com.KG.Support.BaseClass.driver;
import static org.junit.Assert.*;

public class ElementUtils {


    private Properties prop;
    private FileInputStream fileInputStream;


    //click button with fluent wait
    public ElementUtils clickBtn(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        element.click();
        return this;
    }

    public String getTextOfElement(By by) {
        return driver.findElement(by).getText();

    }

    public ElementUtils assertURL(String expectedURL) {
        String actualURL = driver.getCurrentUrl();
        assertEquals(expectedURL, actualURL);
        return this;
    }

    //explicit wait element to be present
    public ElementUtils waitForElementVisible(By by) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.presenceOfElementLocated(by));
        return this;
    }

    public String pickAtRandomWithInRange(String[] lot) {
        String[] prefix = lot;
        Random random = new Random();
        String randomPick = prefix[random.nextInt(prefix.length)];
        return randomPick;

    }

    //get properties method
    public String getProperty(String key) {

        try {
            prop = new Properties();
            fileInputStream = new FileInputStream("src/test/Resources/config.properties");
            prop.load(fileInputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop.getProperty(key);
    }


    //browser selector choose between chrome and phantomJS. specify the desired browser in the config.properties
    public WebDriver browser() {

        if (getProperty("BROWSER").equalsIgnoreCase("chrome")) {
            ChromeDriverManager.getInstance().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            driver = new ChromeDriver(options);
        } else if (getProperty("browser").equalsIgnoreCase("phantomJS")) {
            Capabilities caps = new DesiredCapabilities();
            ((DesiredCapabilities) caps).setJavascriptEnabled(true);
            ((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
            ((DesiredCapabilities) caps).setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "headless\\phantomjs.exe");
            driver = new PhantomJSDriver(caps);


        }
        return driver;
    }

    //screen capture upon failure. the images are stored under output folder. and also the report.html is a consolidated report of the results
    public void captureScreenShot(String screenShotName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source, new File("./output/" + screenShotName + ".png"));
        System.out.println("screenShot taken");
    }

}







