package tests;
    
import modeles.Consumer;
import modeles.Product;
import modeles.User;
import org.testng.annotations.Test;


public class SauceDemoTest extends BaseTest {
    String onesieDesc = "Rib snap infant onesie for the junior automation engineer in development. Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.";

    @Test
    public void loginTest(){
        User user = new User("standard_user", "secret_sauce");
        loginPageFactory
                .openPage()
                .login(user)
                .urlValidate()
                ;
    }

    @Test
    public void validateCartDetails(){
        User user = new User("standard_user", "secret_sauce");
        String tShirtDetails = "Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.";
        Product tShirt = new Product("Sauce Labs Bolt T-Shirt", "15.99",tShirtDetails );
        String jacketDetails = "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";
        Product jacket = new Product("Sauce Labs Fleece Jacket", "49.99", jacketDetails);
        loginPageFactory
                .openPage()
                .login(user)
                .addToCart(tShirt)
                .addToCart(jacket)
                .clickCart()
                .validateProductDetails(tShirt)
                .validateProductDetails(jacket)
                ;
    }

    @Test
    public void validateItemDetailsInItemPage(){
        String bikeLightDetails = "A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.";
        User user = new User("standard_user", "secret_sauce");
        Product bikeLight = new Product("Sauce Labs Bike Light", "$9.99", bikeLightDetails);
        loginPageFactory
                .openPage()
                .login(user)
                .openItemPage(bikeLight)
                .validateProductDetails(bikeLight)
        ;
    }

    @Test
    public void addItemToCartViaItemPage(){
        User user = new User("standard_user", "secret_sauce");
        Product onesie = new Product("Sauce Labs Onesie", "7.99", onesieDesc);
        loginPageFactory
                .openPage()
                .login(user)
                .openItemPage(onesie)
                .addToCart()
                .openCart()
                .validateProductDetails(onesie)
                ;
        }

    @Test
    public void cancelOfPurchase() {
        User user = new User("standard_user", "secret_sauce");
        Product onesie = new Product("Sauce Labs Onesie", "7.99", onesieDesc);
        Consumer consumer = new Consumer("Eug", "Smerdoff", "123321");
        loginPageFactory
                .openPage()
                .login(user)
                .addToCart(onesie)
                .clickCart()
                .clickCheckout()
                .fillInputs(consumer)
                .clickContinue()
                .clickCancel()
                .urlValidate()
                ;
    }

    @Test
    public void continueShopping() {
        User user = new User("standard_user", "secret_sauce");
        Product onesie = new Product("Sauce Labs Onesie", "7.99", onesieDesc);
        loginPageFactory
                .openPage()
                .login(user)
                .addToCart(onesie)
                .clickCart()
                .clickContinueShopping()
                .urlValidate()
                ;
    }
}


