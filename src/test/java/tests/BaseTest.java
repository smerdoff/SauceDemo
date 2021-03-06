package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.SauceDemoSteps;
import utils.CapabilitiesGenerator;

import java.util.concurrent.TimeUnit;
@Listeners(TestListener.class)
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
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
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
