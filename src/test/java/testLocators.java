import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testLocators {

        @Test
        public void findLocators() {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/index.html");
            driver.findElement(By.cssSelector(".login_logo"));
            driver.findElement(By.cssSelector(".bot_column"));
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.cssSelector(".btn_action")).click();
            driver.findElement(By.id("item_4_title_link"));
            driver.findElement(By.xpath("//*[@id='item_4_img_link']/../..//button"));
            driver.findElement(By.xpath("//*[@id = 'item_4_img_link']//img")).click();
            driver.findElement(By.className("btn_primary"));
            driver.findElement(By.className("inventory_details_back_button")).click();
            driver.findElement(By.id("item_0_title_link"));
            driver.findElement(By.xpath("//*[@id='item_0_img_link']/../..//button")).click();
            driver.findElement(By.xpath("//*[@id = 'item_0_img_link']//img"));
            driver.findElement(By.id("item_1_title_link"));
            driver.findElement(By.xpath("//*[@id='item_1_img_link']/../..//button"));
            driver.findElement(By.xpath("//*[@id = 'item_1_img_link']//img"));
            driver.findElement(By.id("item_5_title_link"));
            driver.findElement(By.xpath("//*[@id='item_5_img_link']/../..//button"));
            driver.findElement(By.xpath("//*[@id = 'item_5_img_link']//img"));
            driver.findElement(By.id("item_2_title_link"));
            driver.findElement(By.xpath("//*[@id='item_3_img_link']/../..//button")).click();
            driver.findElement(By.xpath("//*[@id = 'item_3_img_link']//img"));
            driver.findElement(By.className("product_sort_container"));
            driver.findElement(By.id("shopping_cart_container")).click();
            driver.findElement(By.id("item_0_title_link"));
            driver.findElement(By.xpath("//*[@id = 'item_0_title_link']/..//button")).click();
            driver.findElement(By.xpath("//*[text()='Continue Shopping' ]"));
            driver.findElement(By.className("checkout_button")).click();
            driver.findElement(By.id("first-name")).sendKeys("asd");
            driver.findElement(By.id("last-name")).sendKeys("pass");
            driver.findElement(By.id("postal-code")).sendKeys("123321");
            driver.findElement(By.className("cart_cancel_link"));
            driver.findElement(By.cssSelector("[value = CONTINUE]")).click();
            driver.findElement(By.className("cart_item_label"));
            driver.findElement(By.className("cart_button")).click();
            driver.findElement(By.xpath("//*[text()= 'Open Menu']")).click();
            driver.findElement(By.xpath("//*[text()= 'All Items']"));
            driver.findElement(By.xpath("//*[text()= 'About']"));
            driver.findElement(By.xpath("//*[text()= 'Logout']"));
            driver.findElement(By.xpath("//*[text()= 'Reset App State']"));
            driver.quit();
        }
}
