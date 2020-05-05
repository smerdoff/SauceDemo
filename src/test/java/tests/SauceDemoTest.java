package tests;
    
import modeles.User;
import org.testng.annotations.Test;
import pages.CartPage;


public class SauceDemoTest extends BaseTest {

    @Test
    public void loginTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.validateNumberOfProducts(1);
        cartPage.validateProductDetails("Sauce Labs Fleece Jacket", 1, 49.99);
    }

    @Test
    public void loginOfLockedOutUser() {
        loginPage.openPage();
        loginPage.blockedLogin("locked_out_user", "secret_sauce");
    }

    @Test
    public void incorrectLogin(){
        loginPage.openPage();
        loginPage.incorrectLogin("standard_user", "password");
    }

    @Test
    public void checkoutFields(){
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Onesie");
        cartPage.openPage();
        cartPage.clickCheckout();
        checkoutPage.fillInputs("Firstname", "LastName", "11111");
        checkoutPage.checkoutStepTwoURLValidation();
    }

    @Test
    public void purchaseTest(){
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Onesie");
        cartPage.openPage();
        cartPage.clickCheckout();
        checkoutPage.fillInputs("Firstname", "LastName", "11111");
        overviewPage.validateNumberOfProducts(2);
        overviewPage.validateProductDetails("Sauce Labs Fleece Jacket", 1, "$49.99");
        overviewPage.validateProductDetails("Sauce Labs Onesie", 1, "$7.99");
        overviewPage.clickFinish();
        overviewPage.finishURLValidation();
    }

    @Test
    public void cancelCheckout(){
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Onesie");
        cartPage.openPage();
        cartPage.clickCheckout();
        checkoutPage.fillInputs("Firstname", "LastName", "11111");
        checkoutPage.clickCancel();
    }

    @Test
    public void placeholdersTest(){
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        productsPage.addToCart("Sauce Labs Onesie");
        cartPage.openPage();
        cartPage.clickCheckout();
        checkoutPage.firstNamePlaceholderTest();
        checkoutPage.lastNamePlaceholderTest();
        checkoutPage.zipCodePlaceholderTest();
    }

    @Test
    public void loginTwoTest(){
        User user = new User("standard_user", "secret_sauce");
        loginPageFactory
                .openPage()
                .login(user)
                .addToCart("Sauce Labs Fleece Jacket")
                .addToCart("Sauce Labs Onesie")
                .clickCart()
                .validateNumberOfProducts(2)
                ;
    }
}


