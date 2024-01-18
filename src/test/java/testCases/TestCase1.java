package testCases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TestCase1 extends BaseTest
{

    @Test
    public void RegistrationTest() throws IOException, InterruptedException {
        driver = initializeDriver();
        driver.get("https://www.facebook.com");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[placeholder='Email or phone number']")).sendKeys("razaqyaro@gmail.com");
        getScreenshot("Registration", driver);
    }
    @Test
    public void LoginTest()
    {

    }
    @Test
    public void AddProductTest()
    {

    }
}
