package pages;
import modeles.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.net.URL;

public class ProductsPage extends BasePage {
    private String PRODUCTS_URL = "https://www.saucedemo.com/inventory.html";
    private static final String ADD_TO_CART_LOCATOR = ("//*[text()='%s']/../../..//button");
    private static final String ADD_TO_CART_CSS = ".btn_inventory";
    private static final String CART_CSS = ".shopping_cart_link";
    private static final String PRODUCT_INFO_LOCATOR = ("//*[text() = '%s']");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductsPage openPage() {
        driver.get(PRODUCTS_URL);
        isPageOpened();
        return this;
    }

    @Override
    protected ProductsPage isPageOpened() {
        waitForNumberOfElements(By.cssSelector(ADD_TO_CART_CSS),6);
        return this;
    }

    public CartPage clickCart(){
        driver.findElement(By.cssSelector(CART_CSS)).click();
        return new CartPage(driver);
    }

    public ProductsPage addToCart(Product product){
        isPageOpened();
        By addToCartXpath = By.xpath(String.format(ADD_TO_CART_LOCATOR, product.getProductName()));
        driver.findElement(addToCartXpath).click();
        return this;
    }

    public InventoryItemPage openItemPage(Product product){
        isPageOpened();
        By productNameXpath = By.xpath(String.format(PRODUCT_INFO_LOCATOR, product.getProductName()));
        driver.findElement(productNameXpath).click();
        return new InventoryItemPage(driver);
    }

    public void urlValidate(){
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, PRODUCTS_URL, "Пользователь находится на неправильной странице");
    }
}

