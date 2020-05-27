package pages;

import modeles.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CartPage extends BasePage {

    private static final By CART_ITEM = By.cssSelector(".cart_item");
    private String productQuantityLocator = "//*[contains(text(),'%s')]/../../..//div[@class='cart_quantity']";
    private String productPriceLocator = "//*[contains(text(),'%s')]/../../..//div[@class='inventory_item_price']";
    private String productDetailsLocator = "//*[contains(text(),'%s')]/../..//div[@class= 'inventory_item_desc']";
    private static final By CHECKOUT_BUTTON = By.cssSelector(".checkout_button");
    private static final By CONTINUE_SHOPPING_BUTTON = By.xpath("//*[text()= 'Continue Shopping']");
    private static final String URL = "https://www.saucedemo.com/cart.html";
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CartPage openPage(){
        driver.get(URL);
        return this;
    }

    @Override
    protected CartPage isPageOpened() {
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(CHECKOUT_BUTTON));
    return this;
    }

    public CartPage validateNumberOfProducts(int number){
        Assert.assertEquals(driver.findElements(CART_ITEM).size(),number, "Количество айтемов неверное");
        return this;
    }

    public CartPage validateProductDetails(Product product) {
        String actualPrice = driver.findElement(
                By.xpath(String.format(productPriceLocator, product.getProductName()))).getText();
        Assert.assertEquals(actualPrice, String.valueOf(product.getPrice()),
                "Price is invalid");
        String actualDetails = driver.findElement(
                By.xpath(String.format(productDetailsLocator,product.getProductName()))).getText();
        Assert. assertEquals(actualDetails,product.getDetails());
        return this;
    }

    public CheckoutPageFactory clickCheckout(){
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutPageFactory(driver);
    }

    public ProductsPage clickContinueShopping(){
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        return new ProductsPage(driver);
    }
}
