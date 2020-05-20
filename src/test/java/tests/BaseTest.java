package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import steps.SauceDemoSteps;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    private WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    OverviewPage overviewPage;
    LoginPageFactory loginPageFactory;
    InventoryItemPage inventoryItemPage;
    CheckoutPageFactory checkoutPageFactory;
    protected SauceDemoSteps steps;

    @BeforeMethod
    public void setUp(ITestContext context) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage=new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        overviewPage = new OverviewPage(driver);
        loginPageFactory = new LoginPageFactory(driver);
        inventoryItemPage = new InventoryItemPage(driver);
        checkoutPageFactory = new CheckoutPageFactory(driver);
        context.setAttribute("driver", driver);
        steps = new SauceDemoSteps(driver);
    }

    @AfterMethod(alwaysRun =true)
    public void closeBrowser() {
        driver.quit();
    }
}
