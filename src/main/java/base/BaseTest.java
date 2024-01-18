package base;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.firefox.FirefoxDriver;



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
        String chromeBrowser = prop.getProperty("chromeBrowser");
        String firefoxBrowser = prop.getProperty("firefoxBrowser");
        String edgeBrowser = prop.getProperty("edgeBrowser");
        if(chromeBrowser.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if(firefoxBrowser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if(edgeBrowser.equalsIgnoreCase("edge"))
        {
            driver = new FirefoxDriver();
        }
        else {
            System.out.println("The browser type is not configured.");
        }


        return driver;
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

//    @AfterMethod
//    public void tearDown()
//    {
//
//    }
}

