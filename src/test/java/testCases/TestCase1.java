package testCases;

import base.BaseTest;
import data.ReadData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;


public class TestCase1 extends BaseTest
{
    public WebDriver driver;
    @Test
    public void RegistrationTest() throws IOException, InterruptedException {
        driver = initializeDriver();
        Thread.sleep(3000);
        driver.get("https://www.facebook.com");
        driver.findElement(By.cssSelector("[placeholder='Email or phone number']")).sendKeys("razaqyaro@gmail.com");
        getScreenshot("Registration", driver);
    }
    @Test(alwaysRun = true, dataProvider ="getDataFromJson", dataProviderClass = ReadData.class)
    public void LoginTest(HashMap<String, String> logInCredentials) throws IOException, InterruptedException
    {
        String username = logInCredentials.get("Username"), password = logInCredentials.get("Password");

        driver = initializeDriver();
        driver.get(setBaseUrl());
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();

    }
    @Test
    public void AddProductTest()
    {

    }
}
