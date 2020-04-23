package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private String LOGIN_URL = "https://www.saucedemo.com/inventory.html";
    private static final String ADD_TO_CART_LOCATOR = ("//*[text()='%s']/../../..//button");
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(LOGIN_URL);
    }

    public void addToCart(String productName){
        By addToCartXpath = By.xpath(String.format(ADD_TO_CART_LOCATOR, productName));
        driver.findElement(addToCartXpath).click();
    }
}

