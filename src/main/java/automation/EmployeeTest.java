package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AddEmployeeTest extends LoginTest {

    @Test
    public void addEmployee(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#bAdd")).click();
        driver.findElement(By.cssSelector("body > div > div > div > form > fieldset > label:nth-child(3) > input")).sendKeys("Firstname");
        driver.findElement(By.cssSelector("body > div > div > div > form > fieldset > label:nth-child(4) > input")).sendKeys("Lastname");
        driver.findElement(By.cssSelector("body > div > div > div > form > fieldset > label:nth-child(5) > input")).sendKeys("2019-08-22");
        driver.findElement(By.cssSelector("body > div > div > div > form > fieldset > label:nth-child(6) > input")).sendKeys("test@gmail.com");
        driver.findElement(By.cssSelector("body > div > div > div > form > fieldset > div > button:nth-child(2)")).click();

        

    }

}
