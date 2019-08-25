package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTest {


    public static void loginTest() {
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();

        driver.get("http://cafetownsend-angular-rails.herokuapp.com/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#login-form > fieldset > label:nth-child(3) > input")).sendKeys("Luke");
        driver.findElement(By.cssSelector("#login-form > fieldset > label:nth-child(4) > input")).sendKeys("Skywalker");
        driver.findElement(By.cssSelector("#login-form > fieldset > button")).click();
    }
}
