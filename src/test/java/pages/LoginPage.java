package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginPage extends BasePage {

    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn_action");
    private static final By ERROR_BUTTON = By.className("error-button");
    private static final By ERROR_TEXT = By.cssSelector("h3");
    private String expectedErrorOfLockedUser = "Epic sadface: Sorry, this user has been locked out.";
    private String expectedErrorOfIncorrectLogin = "Epic sadface: Username and password do not match any user in this service";
    public static final String LOGIN_URL = "https://www.saucedemo.com/index.html";

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void openPage(){
        driver.get(LOGIN_URL);
    }

    public void login (String userName, String password){
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void blockedLogin (String userName, String password){
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        String actualText =  driver.findElement(ERROR_TEXT).getText();
        Assert.assertEquals(actualText,expectedErrorOfLockedUser, "Текст не совпадает" );
    }

    public void incorrectLogin (String userName, String password){
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        String actualText =  driver.findElement(ERROR_TEXT).getText();
        Assert.assertEquals(actualText,expectedErrorOfIncorrectLogin, "Текст не совпадает" );
    }

}
