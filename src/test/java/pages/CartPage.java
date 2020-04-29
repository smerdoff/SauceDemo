package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartPage extends BasePage {

    private static final By CART_ITEM = By.cssSelector(".cart_item");
    private String productQuantityLocator = "//*[contains(text(),'%s')]/../../..//div[@class='cart_quantity']";
    private String productPriceLocator = "//*[contains(text(),'%s')]/../../..//div[@class='inventory_item_price']";
    private static final By CHECKOUT_BUTTON = By.className("checkout_button");
    private static final String URL = "https://www.saucedemo.com/cart.html";
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openPage(){
        driver.get(URL);
    }

    public void validateNumberOfProducts(int number){
        Assert.assertEquals(driver.findElements(CART_ITEM).size(),number, "Количество айтемов неверное");
    }

    public void validateProductDetails(String productName, int quantity, double price){
        String actualQuantity = driver.findElement(By.xpath(String.format(productQuantityLocator,productName))).getText();
        Assert.assertEquals(actualQuantity, String.valueOf(quantity), "message");
        String actualPrice = driver.findElement(
                By.xpath(String.format(productPriceLocator, productName))).getText();
        Assert.assertEquals(actualPrice, String.valueOf(price),
                "Price is invalid");
    }

    public void clickCheckout(){
        driver.findElement(CHECKOUT_BUTTON).click();
    }
}
