package steps;
import io.qameta.allure.Step;

import org.openqa.selenium.WebDriver;
import pages.LoginPageFactory;

public class SauceDemoSteps {

    private LoginPageFactory page;

    public SauceDemoSteps(WebDriver driver) {
        page = new LoginPageFactory (driver);
    }

    @Step("login with next credentials: '{login}' and '{password}' ")
    public SauceDemoSteps login(String login, String password) {
        page
                .openPage()
                .login(login, password)
                .urlValidate();
        return this;
    }
}
