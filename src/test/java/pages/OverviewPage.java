package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class OverviewPage extends BasePage {

    private static final By CART_ITEM = By.cssSelector(".cart_item");
    private String productQuantityLocator = "//*[contains(text(),'%s')]/../../..//div[@class = 'summary_quantity']";
    private String productPriceLocator = "//*[contains(text(),'%s')]/../..//div[@class = 'inventory_item_price']";
    private static final By FINISH_BUTTON = By.cssSelector(".cart_button");
    private static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link");
    private String FINISH_URL = "https://www.saucedemo.com/checkout-complete.html";
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected BasePage openPage() {
        driver.get(FINISH_URL);
        isPageOpened();
        return this;
    }

    @Override
    protected BasePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FINISH_BUTTON));
        return this;
    }

    public void validateNumberOfProducts(int number){
        Assert.assertEquals(driver.findElements(CART_ITEM).size(),number, "Количество айтемов неверное");
    }

    public void validateProductDetails(String productName, int quantity, String price){
        String actualQuantity = driver.findElement(By.xpath(String.format(productQuantityLocator,productName))).getText();
        Assert.assertEquals(actualQuantity, String.valueOf(quantity), "message");
        String actualPrice = driver.findElement(
                By.xpath(String.format(productPriceLocator, productName))).getText();
        Assert.assertEquals(actualPrice, price,"Price is invalid");
    }

    public void clickFinish(){
        driver.findElement(FINISH_BUTTON).click();
    }

    public ProductsPage clickCancel(){
        driver.findElement(CANCEL_BUTTON).click();
        return new ProductsPage(driver);
    }



    public void finishURLValidation(){
        String URL = driver.getCurrentUrl();
        Assert.assertEquals(FINISH_URL, URL, "The wrong page opened OR page is not opened ");
    }


}
