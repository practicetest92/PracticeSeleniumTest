package Page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Set;

public class PracticePage {

    WebDriver driver;
    public static String productName;

    public PracticePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "nav-link-accountList")
    public WebElement signInAndAccountListBtn;

    @FindBy(id = "ap_email")
    public WebElement emailInputBox;

    @FindBy(id = "ap_password")
    public WebElement passwordInputBox;

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchTextBox;

    @FindBy(xpath = "//div[@data-cel-widget='search_result_2']//span[@class='a-size-base-plus a-color-base a-text-normal']")
    public WebElement firstProductName;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCartBtn;

    @FindBy(name = "proceedToRetailCheckout")
    public WebElement proceedToBuyBtn;

    @FindBy(id = "sw-gtc")
    public WebElement goToCardBtn;

    @FindBy(xpath = "//span[@class='a-truncate-cut']")
    public WebElement productNameInCart;

    @FindBy(css = "#addres-select>h1")
    public WebElement selectAddressTitle;

    @FindBy(id = "address-ui-widgets-enterAddressFullName")
    public WebElement fullName;

    @FindBy(id = "address-ui-widgets-enterAddressPhoneNumber")
    public WebElement mobileNumber;

    @FindBy(id = "address-ui-widgets-enterAddressPostalCode")
    public WebElement pincode;

    @FindBy(id = "address-ui-widgets-enterAddressLine1")
    public WebElement addressLine1;

    @FindBy(className = "a-button-input")
    public WebElement useThisAddressBtn;

    @FindBy(css = ".a-container>div>h1")
    public WebElement selectPaymentMethodTitle;

    @FindBy(css = ".a-declarative a-button-text ")
    public WebElement deliveryToThisAddressBtn;


    public void doLogin() {
        signInAndAccountListBtn.click();
        emailInputBox.sendKeys("practicetest146@gmail.com", Keys.ENTER);
        passwordInputBox.sendKeys("Practice@123", Keys.ENTER);

    }

    public void doSearchProduct() {
        searchTextBox.sendKeys("Zelda socks", Keys.ENTER);
        productName = firstProductName.getText();
        Assert.assertTrue(productName.contains("Socks"), "Invalid Product");
    }

    public void doClickOnSearchProduct() {
        firstProductName.click();
        String parentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equalsIgnoreCase(parentWindow)) {
                driver.switchTo().window(window);
            } else {
                continue;
            }
        }
        Assert.assertTrue(addToCartBtn.isDisplayed());
    }

    public void doClickOnAddToCartBtn() {
        addToCartBtn.click();
        Assert.assertTrue(proceedToBuyBtn.isDisplayed());
    }

    public void navigateToCartAndVerifyProduct() {
        goToCardBtn.click();
        String productInCart = productNameInCart.getText();
        Assert.assertTrue(productInCart.contains("Socks"));
    }

    public void doClickOnProceedToBuyBtn() {
        proceedToBuyBtn.click();
        Assert.assertEquals(selectAddressTitle.getText(), "Select a delivery address");
    }
}
