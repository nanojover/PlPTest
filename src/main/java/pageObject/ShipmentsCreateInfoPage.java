package pageObject;

import DTOs.SearchDataDTO;
import com.sun.glass.ui.Robot;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitElement;

import java.awt.event.KeyEvent;

public class ShipmentsCreateInfoPage extends CommonPage {
    public ShipmentsCreateInfoPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/article/div/div[1]/create-info/section/form/fieldset[1]/div/shipment-origins/packlink-selector[1]/div/input[1]")
    private static WebElement countryFrom;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/article/div/div[1]/create-info/section/form/fieldset[1]/div/shipment-origins/packlink-selector[2]/div/input[1]")
    private static WebElement cpFrom;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/article/div/div[1]/create-info/section/form/fieldset[2]/div/shipment-origins/packlink-selector[1]/div/input[1]")
    private static WebElement countryTo;

    @FindBy(xpath = "/html/body/div[3]/div[1]/div[2]/article/div/div[1]/create-info/section/form/fieldset[2]/div/shipment-origins/packlink-selector[2]/div/input[1]")
    private static WebElement cpTo;

    @FindBy(xpath = "//*[@id='weight-0']")
    private static WebElement weight;

    @FindBy(xpath = "//*[@id='length-0']")
    private static WebElement length;

    @FindBy(xpath = "//*[@id='width-0']")
    private static WebElement width;

    @FindBy(xpath = "//*[@id='height-0']")
    private static WebElement height;

    @FindBy(css = ".eb-create-shipment__submit-btn")
    private static WebElement createShipmentButton;

    private static void insretCountrFrom(String countryFromValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", countryFrom, countryFromValue);

//        countryFrom.sendKeys(countryFromValue + Keys.RETURN);
    }

    private static void insertCpFrom(String cpFromValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1];", cpFrom, cpFromValue);

//        cpFrom.sendKeys(cpFromValue + Keys.RETURN);
    }

    private static void insertCountryTo(String countryToValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1]", countryTo, countryToValue);
//        countryTo.sendKeys(countryToValue + Keys.RETURN);
    }

    private static void insertCpTo(String cpToValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1]", cpTo, cpToValue);
//        cpTo.sendKeys(cpToValue + Keys.RETURN);
    }

    private static void insertWeight(String weightValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1]", weight, weightValue);
//        weight.sendKeys(weightValue + Keys.RETURN);
    }

    private static void insertWidth(String widthValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1]", width, widthValue);
//        width.sendKeys(widthValue);
    }

    private static void insertLength(String lengthValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1]", length, lengthValue);
//        length.sendKeys(lengthValue);
    }

    private static void insertHeight(String heightValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].value=arguments[1]", height, heightValue);
//        height.sendKeys(heightValue);
    }

    public static void checkShipmentCreateOmfpScreen() {
        WaitElement.waitForElement(driver, countryFrom);

        Assert.assertTrue(countryFrom.getAttribute("clickable"), true);
        Assert.assertTrue(countryFrom.getAttribute("longClickable"), true);
        Assert.assertTrue(countryFrom.isEnabled());

        Assert.assertTrue(cpFrom.getAttribute("clickable"), true);
        Assert.assertTrue(cpFrom.getAttribute("longClickable"), true);
        Assert.assertTrue(cpFrom.isEnabled());

        Assert.assertTrue(countryTo.getAttribute("clickable"), true);
        Assert.assertTrue(countryTo.getAttribute("longClickable"), true);
        Assert.assertTrue(countryTo.isEnabled());

        Assert.assertTrue(cpTo.getAttribute("clickable"), true);
        Assert.assertTrue(cpTo.getAttribute("longClickable"), true);
        Assert.assertTrue(cpTo.isEnabled());

        Assert.assertTrue(weight.getAttribute("clickable"), true);
        Assert.assertTrue(weight.getAttribute("longClickable"), true);
        Assert.assertTrue(weight.isEnabled());

        Assert.assertTrue(width.getAttribute("clickable"), true);
        Assert.assertTrue(width.getAttribute("longClickable"), true);
        Assert.assertTrue(width.isEnabled());

        Assert.assertTrue(length.getAttribute("clickable"), true);
        Assert.assertTrue(length.getAttribute("longClickable"), true);
        Assert.assertTrue(length.isEnabled());

        Assert.assertTrue(height.getAttribute("clickable"), true);
        Assert.assertTrue(height.getAttribute("longClickable"), true);
        Assert.assertTrue(height.isEnabled());

        Assert.assertTrue(createShipmentButton.getAttribute("clickable"), true);
        Assert.assertTrue(createShipmentButton.getAttribute("longClickable"), true);
        Assert.assertTrue(createShipmentButton.isEnabled());
    }

    public static void fillForm(SearchDataDTO information) {
        WaitElement.waitForElement(driver, countryFrom);

        if (!"null" .equals(information.getCountryOrigin())) {
            insretCountrFrom(information.getCountryOrigin());
        }
        if (!"null" .equals(information.getCpOrigin())) {
            insertCpFrom(information.getCpOrigin());
        }
        if (!"null" .equals(information.getCountryDetination())) {
            insertCountryTo(information.getCountryDetination());
        }

        if (!"null" .equals(information.getCpDestination())) {
            insertCpTo(information.getCpDestination());
        }

        if (!"null" .equals(information.getWeight())) {
            insertWeight(information.getWeight());
        }

        if (!"null" .equals(information.getLengthSize())) {
            insertLength(information.getLengthSize());
        }

        if (!"null" .equals(information.getWidthSize())) {
            insertWidth(information.getWidthSize());
        }

        if (!"null" .equals(information.getHeightSize())) {
            insertHeight(information.getHeightSize());
        }
    }

    public static void clickCreateShipmentButton() {
        createShipmentButton.click();
    }
}
