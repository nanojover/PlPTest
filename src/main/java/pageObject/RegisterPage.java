package pageObject;

import DTOs.RegisterDataDTO;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitElement;

public class RegisterPage extends CommonPage {

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "register-email")
    public static WebElement email;

    @FindBy(id = "register-tel")
    private static WebElement phone;

    @FindBy(id = "register-password")
    private static WebElement password;

    @FindBy(id = "register-shipments")
    private static WebElement shipments;

    @FindBy(id = "register-platform")
    private static WebElement platform;

    @FindBy(id = "register-ecommerce")
    private static WebElement ecommerce;

    @FindBy(id = "register-submit")
    private static WebElement submitButton;

    @FindBy(id = "nav-button")
    private static WebElement loginButton;

    @FindBy(id = "register-error-msg")
    private static WebElement registerErrorMessage;

    private static void insertEmail(String emailValue) {
        email.sendKeys(emailValue);
    }

    private static void insertPhone(String phoneValue) {
        phone.sendKeys(phoneValue);
    }

    private static void insertPassword(String passwordValue) {
        password.sendKeys(passwordValue);
    }

    private static void insertShipments(String shipmentValue) {
        shipments.sendKeys(shipmentValue);
    }

    private static void insertPlatform(String platformValue) {
        platform.sendKeys(platformValue);
    }

    private static void insertEcommerce(String ecommerceValue) {
        ecommerce.sendKeys(ecommerceValue);
    }

    public static void fillForm(RegisterDataDTO information) {
        WaitElement.waitForElement(driver, email);

        if (!"null".equals(information.getEmail())) {
            insertEmail(information.getEmail());
        }
        if (!"null".equals(information.getPhone())) {
            insertPhone(information.getPhone());
        }
        if (!"null".equals(information.getPassword())) {
            insertPassword(information.getPassword());
        }

        if (!"null".equals(information.getShipments())) {
            insertShipments(information.getShipments());
        }

        if (!"null".equals(information.getPlatform())) {
            insertPlatform(information.getPlatform());
        }
        if (!"null".equals(information.getEcomerce())) {
            insertEcommerce(information.getEcomerce());
        }
    }

    public static void clickSubmit() {
        submitButton.click();
    }

    public static void checkLoginScreen() {
        WaitElement.waitForElement(driver, email);

        Assert.assertTrue(email.getAttribute("clickable"), true);
        Assert.assertTrue(email.getAttribute("longClickable"), true);
        Assert.assertTrue(email.isEnabled());

        Assert.assertTrue(phone.getAttribute("clickable"), true);
        Assert.assertTrue(phone.getAttribute("longClickable"), true);
        Assert.assertTrue(phone.isEnabled());

        Assert.assertTrue(password.getAttribute("clickable"), true);
        Assert.assertTrue(password.getAttribute("longClickable"), true);
        Assert.assertTrue(password.isEnabled());

        Assert.assertTrue(shipments.getAttribute("clickable"), true);
        Assert.assertTrue(shipments.getAttribute("longClickable"), true);
        Assert.assertTrue(shipments.isEnabled());

        Assert.assertTrue(platform.getAttribute("clickable"), true);
        Assert.assertTrue(platform.getAttribute("longClickable"), true);
        Assert.assertTrue(platform.isEnabled());

        Assert.assertTrue(ecommerce.getAttribute("clickable"), true);
        Assert.assertTrue(ecommerce.getAttribute("longClickable"), true);
        Assert.assertTrue(ecommerce.isEnabled());

    }

    public static void checkErrorMessage(String errorMessage) {
        WaitElement.waitForElement(driver, registerErrorMessage);
        Assert.assertTrue(errorMessage.equals(registerErrorMessage.getText()));
    }
}
