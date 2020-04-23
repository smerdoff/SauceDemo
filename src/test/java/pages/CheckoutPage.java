package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private String CHECKOUT_URL = "https://www.saucedemo.com/checkout-step-one.html";
    private static final By FIRST_NAME_INPUT = By.id("first-name");
    private static final By LAST_NAME_INPUT = By.id("last-name");
    private static final By ZIP_INPUT = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.cssSelector("[value = CONTINUE]");
    private static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link");
    private String expectedFirstnamePlaceholder = "First Name";
    private String expectedlastnamePlaceholder = "Last Name";
    private String expectedZipCodePlaceholder = "Zip/Postal Code";

    public void openPage(){
        driver.get(CHECKOUT_URL);
    }

    public void fillInputs(String firstName, String lastName, String zipCode){
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_INPUT).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void clickCancel(){
        driver.findElement(CANCEL_BUTTON).click();
    }

    public void firstNamePlaceholderTest(){
        String firstNamePlaceholder = driver.findElement(FIRST_NAME_INPUT).getAttribute("placeholder");
        Assert.assertEquals(firstNamePlaceholder, expectedFirstnamePlaceholder, "Не совпадают плейсхолдер имени");
    }

    public void lastNamePlaceholderTest(){
        String lastNamePlaceholder = driver.findElement(LAST_NAME_INPUT).getAttribute("placeholder");
        Assert.assertEquals(lastNamePlaceholder, expectedlastnamePlaceholder, "Не совпадают плейсхолдер имени");
    }

    public void zipCodePlaceholderTest(){
        String zipCodePlaceholder = driver.findElement(ZIP_INPUT).getAttribute("placeholder");
        Assert.assertEquals(zipCodePlaceholder, expectedZipCodePlaceholder, "Не совпадают плейсхолдер имени");
    }
}
