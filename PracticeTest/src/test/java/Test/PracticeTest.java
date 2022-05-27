package Test;

import Page.PracticePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PracticeTest {

    WebDriver driver;
    PracticePage practicePage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void signIn() {
        practicePage = new PracticePage(driver);
        practicePage.doLogin();
    }

    @Test(priority = 2)
    public void searchProduct() {
        practicePage = new PracticePage(driver);
        practicePage.doSearchProduct();
    }

    @Test(priority = 3)
    public void clickOnSearchProduct() {
        practicePage = new PracticePage(driver);
        practicePage.doClickOnSearchProduct();
    }

    @Test(priority = 4)
    public void clickOnAddToCartBtn() {
        practicePage = new PracticePage(driver);
        practicePage.doClickOnAddToCartBtn();
    }

    @Test(priority = 5)
    public void verifyProductInCart() {
        practicePage = new PracticePage(driver);
        practicePage.navigateToCartAndVerifyProduct();
    }

    @Test(priority = 6)
    public void clickOnProceedToBuyBtn() {
        practicePage = new PracticePage(driver);
        practicePage.doClickOnProceedToBuyBtn();
    }

    @AfterTest
    public void exitBrowser() {
        driver.quit();
    }
}
