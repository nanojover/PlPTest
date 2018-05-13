package com.packlink.steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.fail;

public class CommonSteps {
    private static Properties properties = new Properties();
    private static WebDriver driver;

    @Before()
    public void init(Scenario scenario) throws Exception {
        String fileProperties = "./properties/properties1.properties";
        try {
            properties.load(new FileInputStream(fileProperties));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @After()
    public void after(Scenario scenario) throws Exception {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
//        driver.quit();
        driver.close();
    }

    public static void startBrowser(String browser) {
        switch (browser) {
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
                CommonSteps.setDriver(new FirefoxDriver());
                break;
            default:
                fail("Non valid browser value");
                break;
        }


    }

    public static void goToURL(String url) {
        CommonSteps.getDriver().get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static void setDriver(WebDriver driver) {
        CommonSteps.driver = driver;
    }
}
