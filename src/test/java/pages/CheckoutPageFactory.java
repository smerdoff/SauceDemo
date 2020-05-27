package pages;

import modeles.Consumer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPageFactory extends BasePage {

    private String CHECKOUT_URL = "https://www.saucedemo.com/checkout-step-one.html";

    @FindBy(id = "first-name")
    WebElement fistNameInput;

    @FindBy(id = "last-name")
    WebElement lastNameInput;

    private static final By ZIP_INPUT = By.id("postal-code");
    @FindBy(id = "postal-code")
    WebElement zipInput;

    @FindBy(css = "[value = CONTINUE]")
    WebElement continueButton;

    @FindBy(css = ".cart_cancel_link")
    WebElement cancelButton;

    public CheckoutPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected BasePage openPage() {
        driver.get(CHECKOUT_URL);
        return this;
    }

    @Override
    protected BasePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(cancelButton));
        return this;
    }

    public CheckoutPageFactory fillInputs(Consumer consumer) {
        fistNameInput.sendKeys(consumer.getFirstName());
        lastNameInput.sendKeys(consumer.getLastName());
        zipInput.sendKeys(consumer.getZipCode());
        return this;
    }

    public OverviewPage clickContinue() {
        continueButton.click();
        return new OverviewPage(driver);
    }
}
