package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.ReusableMethods;

public class PageObject3 extends ReusableMethods
{
    WebDriver driver;
    public PageObject3(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
