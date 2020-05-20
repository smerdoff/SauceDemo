package tests;
import io.qameta.allure.Allure;
import io.qameta.allure.AllureUtils;
import io.qameta.allure.Description;
import modeles.Consumer;
import modeles.Product;
import modeles.User;
import org.testng.annotations.Test;


public class SauceDemoTest extends BaseTest {
    String onesieDesc = "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.";

    @Test(description = "Тест на вход в приложение как стандартный пользователь")
    @Description("Тест на вход в приложение как стандартный пользователь")
    public void loginTest() {
        User user = new User("standard_user","secret_sauce");
        loginPageFactory
                .openPage()
                .loginViaModel(user)
                .urlValidate()
                ;
    }

    @Test(description = "Логин тест через Steps")
    @Description("Тест на вход в приложение как стандартный пользователь")
    public void loginViaSteps() {
        steps.login("standard_user", "secret_sauce");
    }

    @Test(enabled = false)
    public void loginViaCLI() {
        loginPage.openPage();
        loginPage.login(System.getProperty("user"),System.getProperty("password"));
    }

    @Test(description = "Добавление товаров в корзину")
    @Description("Тест на валидацию добавленных товаров в корзину")
    public void validateCartDetails() {
        User user = new User("standard_user", "secret_sauce");
        String tShirtDetails = "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.";
        Product tShirt = new Product("Sauce Labs Bolt T-Shirt", "15.99",tShirtDetails );
        String jacketDetails = "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";
        Product jacket = new Product("Sauce Labs Fleece Jacket", "49.99", jacketDetails);
        loginPageFactory
                .openPage()
                .loginViaModel(user)
                .addToCart(tShirt)
                .addToCart(jacket)
                .clickCart()
                .validateProductDetails(tShirt)
                .validateProductDetails(jacket)
                ;
    }

    @Test(description = "Тест страницы с подробном описанием товара")
    @Description("Тест на валидацию товара в странице с подробным описанием товара")
    public void validateItemDetailsInItemPage(){
        String bikeLightDetails = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
        User user = new User("standard_user", "secret_sauce");
        Product bikeLight = new Product("Sauce Labs Bike Light", "$9.98", bikeLightDetails);
        loginPageFactory
                .openPage()
                .loginViaModel(user)
                .openItemPage(bikeLight)
                .validateProductDetails(bikeLight)
        ;
    }

    @Test()
    @Description("тест на добавление товара в корзину из страницы с подробным описанием товара")
    public void addItemToCartViaItemPage(){
        User user = new User("standard_user", "secret_sauce");
        Product onesie = new Product("Sauce Labs Onesie", "7.99", onesieDesc);
        loginPageFactory
                .openPage()
                .loginViaModel(user)
                .openItemPage(onesie)
                .addToCart()
                .openCart()
                .validateProductDetails(onesie)
                ;
        }

    @Test(description = "тест на отмену покупок. Выход из корзины")
    public void cancelOfPurchase() {
        User user = new User("standard_user", "secret_sauce");
        Product onesie = new Product("Sauce Labs Onesie", "7.99", onesieDesc);
        Consumer consumer = new Consumer("Eug", "Smerdoff", "123321");
        loginPageFactory
                .openPage()
                .loginViaModel(user)
                .addToCart(onesie)
                .clickCart()
                .clickCheckout()
                .fillInputs(consumer)
                .clickContinue()
                .clickCancel()
                .urlValidate()
                ;
    }

    @Test(description = "тест на проверку работы кнопки Continue в корзине")
    public void continueShopping() {
        User user = new User("standard_user", "secret_sauce");
        Product onesie = new Product("Sauce Labs Onesie", "7.99", onesieDesc);
        loginPageFactory
                .openPage()
                .loginViaModel(user)
                .addToCart(onesie)
                .clickCart()
                .clickContinueShopping()
                .urlValidate();
    }
}


