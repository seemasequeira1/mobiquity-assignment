package automation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EmployeeTest extends LoginTest {

    @Test(priority=1)
    public void addEmployee(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("#bAdd")).click();
        driver.findElement(By.cssSelector("body > div > div > div > form > fieldset > label:nth-child(3) > input")).sendKeys("Mona");
        driver.findElement(By.cssSelector("body > div > div > div > form > fieldset > label:nth-child(4) > input")).sendKeys("Lisa");
        driver.findElement(By.cssSelector("body > div > div > div > form > fieldset > label:nth-child(5) > input")).sendKeys("2019-08-22");
        driver.findElement(By.cssSelector("body > div > div > div > form > fieldset > label:nth-child(6) > input")).sendKeys("test@gmail.com");
        driver.findElement(By.cssSelector("body > div > div > div > form > fieldset > div > button:nth-child(2)")).click();
        WebElement nameElement = driver.findElementByXPath("//*[contains(text(), 'Mona Lisa')]");
        Assert.assertEquals("Mona Lisa", nameElement.getText());

    }

    @Test(priority=2)
    public void updateEmployee(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByXPath("//*[contains(text(), 'Mona Lisa')]").click();
        driver.findElement(By.cssSelector("#bEdit")).click();
        driver.findElement(By.cssSelector("body > div > div > div > form > fieldset > label:nth-child(3) > input")).clear();
        driver.findElement(By.cssSelector("body > div > div > div > form > fieldset > label:nth-child(3) > input")).sendKeys("Mona1");
        driver.findElement(By.cssSelector("body > div > div > div > form > fieldset > div > button:nth-child(1)")).click();
        WebElement nameElement = driver.findElementByXPath("//*[contains(text(), 'Mona1 Lisa')]");
        Assert.assertEquals("Mona1 Lisa", nameElement.getText());
    }

    @Test(priority=3)
    public void deleteEmployee(){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElementByXPath("//*[contains(text(), 'Mona1 Lisa')]").click();
        driver.findElement(By.cssSelector("#bDelete")).click();
        driver.switchTo().alert().accept();
       try {
           WebElement nameElement = driver.findElementByXPath("//*[contains(text(), 'Mona1 Lisa')]");
       }catch (NoSuchElementException e){

       }

    }

}
