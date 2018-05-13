package pageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitElement;

public class ShipmentsPage extends CommonPage {

    public ShipmentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "query")
    private static WebElement searchBox;

//    @FindBy(id = "openCreateShipmentFromHeader")
//    private static WebElement openCreateShipmentFromHeader;

//    @FindBy(xpath = "//*[@id='openCreateShipmentFromHeader']")
//    private static WebElement openCreateShipmentFromHeader;

//    @FindBy(css = "ng-click=\"appHeaderCtrl.addShipment()\"")
//    private static WebElement openCreateShipmentFromHeader;

//    @FindBy(css = "#openCreateShipmentFromHeader")
//    private static WebElement openCreateShipmentFromHeader;

    @FindBy(css = ".eb-add-shipment__btn")
    private static WebElement openCreateShipmentFromHeader;


    public static void insertSearch(String emailValue) {
        searchBox.sendKeys(emailValue);
    }

    public static void checkShipmentScreen() {
        WaitElement.waitForElement(driver, searchBox);

        Assert.assertTrue(searchBox.getAttribute("clickable"), true);
        Assert.assertTrue(searchBox.getAttribute("longClickable"), true);
        Assert.assertTrue(searchBox.isEnabled());
    }

    public static void clickCreateShipment(){
        openCreateShipmentFromHeader.click();
    }
}
