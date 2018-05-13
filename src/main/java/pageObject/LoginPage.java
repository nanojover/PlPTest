package pageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitElement;

public class LoginPage extends CommonPage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "login-email")
    private static WebElement email;

    @FindBy(id = "login-password")
    private static WebElement passwrod;

    @FindBy(id = "login-submit")
    private static WebElement loginButton;

    private static void insertEmail(String emailValue) {
        email.sendKeys(emailValue);
    }

    private static void insertPassword(String passwordValue) {
        passwrod.sendKeys(passwordValue);
    }

    private static void clickLogin() {
        loginButton.click();
    }

    public static void loginUser(String user, String password) {
        WaitElement.waitForElement(driver, email);

        insertEmail(user);
        insertPassword(password);

        clickLogin();
    }
}
