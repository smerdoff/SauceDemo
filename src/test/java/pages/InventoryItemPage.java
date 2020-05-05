package pages;

import modeles.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class InventoryItemPage extends BasePage {
    private String productPriceLocator = ".inventory_details_price";
    private String productNameLocator = ".inventory_details_name";
    private String productDescriptionLocator = ".inventory_details_desc";
    private static final By ADD_TO_CART_BUTTON = By.cssSelector(".btn_primary");
    private static final By CART_BUTTON = By.cssSelector(".shopping_cart_link");


    public InventoryItemPage(WebDriver driver) {super(driver);}

    @Override
    protected BasePage openPage() {
        isPageOpened();
        return this;
    }

    @Override
    protected BasePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(ADD_TO_CART_BUTTON));
        return this;
    }

    public InventoryItemPage validateProductDetails(Product product){
        String actualPrice = driver.findElement(By.cssSelector(productPriceLocator)).getText();
        String actualProductName = driver.findElement(By.cssSelector(productNameLocator)).getText();
        String actualDescription = driver.findElement(By.cssSelector(productDescriptionLocator)).getText();
        Assert.assertEquals(actualPrice,product.getPrice(), "Цены продукта не совпадают");
        Assert.assertEquals(actualProductName,product.getProductName(), "Названия продукта не совпадают");
        Assert.assertEquals(actualDescription,product.getDetails(), "Описания продукта не совпадают");
        return this;
    }

    public InventoryItemPage addToCart(){
        driver.findElement(ADD_TO_CART_BUTTON).click();
        return this;
    }

    public CartPage openCart(){
        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }
}
