package pages;

import modeles.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageFactory extends BasePage {

    @FindBy(id = "user-name")
    WebElement userNameInput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(css = ".btn_action")
    WebElement loginButton;
    public static final String LOGIN_URL = "https://www.saucedemo.com/index.html";

    public LoginPageFactory(WebDriver driver){
        super(driver);

    }
    @Override
    public LoginPageFactory openPage(){
        driver.get(LOGIN_URL);
        PageFactory.initElements(driver,this);
        return this;
    }

    @Override
    protected LoginPageFactory isPageOpened() {
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }

    public ProductsPage login (User user){
        userNameInput.sendKeys(user.getUserName());
        passwordInput.sendKeys(user.getPassword());
        loginButton.click();
        return new ProductsPage(driver);
    }
}
