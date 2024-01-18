package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

public class PageObject2 extends ReusableMethods
{
    WebDriver driver;
    public PageObject2(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
