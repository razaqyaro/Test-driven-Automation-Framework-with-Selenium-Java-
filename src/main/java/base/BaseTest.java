package base;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {
    public WebDriver driver;
    final String userDirectory = "user.dir";
    public WebDriver initializeDriver() throws IOException
    {
        final String userDirectory = "user.dir";
        Properties prop = new Properties();
        try (FileInputStream fileInStream = new FileInputStream(System.getProperty(userDirectory) + "//src//main//java//configurations//BrowserConfig.properties")) {
            prop.load(fileInStream);
        }
        String browserName = prop.getProperty("browser");
        if(browserName.contains("chrome"))
        {
            ChromeOptions options = new ChromeOptions();
               // System.setProperty("webdriver.chrome.driver",System.getProperty(userDirectory)+ "//src//browserDrivers//chromedriver.exe");
                var headless = Boolean.parseBoolean(System.getenv("HEADLESS_CHROME"));
                options.addArguments(String.valueOf(headless));
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440, 900));
        }


        return driver;
    }
    public static String setBaseUrl() throws IOException {
        Properties prop = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "//src/main/java/configurations/BrowserConfig.properties")) {
            prop.load(fileInputStream);
        }
        return prop.getProperty("baseUrl");
    }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        String jsonContent = FileUtils.readFileToString(new File(filePath));
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty(userDirectory)+"//src//main//java//reports//"+ testCaseName +".png");
        FileUtils.copyFile(source,file );
        return System.getProperty(userDirectory)+"//src//main//java//report//"+ testCaseName +".png";
    }


}

