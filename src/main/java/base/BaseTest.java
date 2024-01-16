package base;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    public WebDriver initializeDriver() throws IOException
    {
        Properties prop = new Properties();
        FileInputStream fileInStream = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\configurations\\BrowserConfig.properties");
        prop.load(fileInStream);
        String browserName = prop.getProperty("browser");

        if(browserName.contains("chrome"))
        {
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver();
            if(browserName.contains("headless"))
            {
                options.addArguments("headless");
            }

            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440, 900));
        }
        else if(browserName.equalsIgnoreCase("firefox"))
        {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\browserDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("Null: wrong browser");
        }
        System.out.println("Browser Name: " + browserName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }
    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(filePath));
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"//src//main//reports//"+ testCaseName +".png");
        FileUtils.copyFile(source,file );
        return System.getProperty("user.dir")+"//src//main//reports//"+ testCaseName +".png";
    }
    @BeforeMethod(alwaysRun = true)
    public void launchApplication() throws IOException {
        driver = initializeDriver();
    }

    @AfterMethod
    public void tearDown()
    {
        driver.close();
    }
}

