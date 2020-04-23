package tests;

import org.testng.annotations.Test;



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
    public void loginOfLockedOutUer() {
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
}


