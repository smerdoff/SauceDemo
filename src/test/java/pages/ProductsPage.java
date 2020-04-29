package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    private String LOGIN_URL = "https://www.saucedemo.com/inventory.html";
    private static final String ADD_TO_CART_LOCATOR = ("//*[text()='%s']/../../..//button");
    private static final String ADD_TO_CART_CSS = ".btn_inventory";
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(LOGIN_URL);
       waitForNumberOfElements(By.cssSelector(ADD_TO_CART_CSS),6);
    }

    public void addToCart(String productName){
        waitForNumberOfElements(By.cssSelector(ADD_TO_CART_CSS),6);
        By addToCartXpath = By.xpath(String.format(ADD_TO_CART_LOCATOR, productName));
        driver.findElement(addToCartXpath).click();
    }
}

