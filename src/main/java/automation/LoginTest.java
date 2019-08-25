package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    ChromeDriver driver;

    @BeforeSuite
    public void doLoginTest() {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://cafetownsend-angular-rails.herokuapp.com/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#login-form > fieldset > label:nth-child(3) > input")).sendKeys("Luke");
        driver.findElement(By.cssSelector("#login-form > fieldset > label:nth-child(4) > input")).sendKeys("Skywalker");
        driver.findElement(By.cssSelector("#login-form > fieldset > button")).click();

    }

    @AfterSuite
    public void doLogoutTest(){
        driver.findElement(By.cssSelector("body > div > header > div > p.main-button")).click();
        driver.quit();
    }
}
