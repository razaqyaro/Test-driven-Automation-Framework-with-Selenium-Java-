package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ReusableMethods
{
    WebDriver driver;
    public ReusableMethods(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**
     *
     *   @FindBy(css = ".btn.btn-custom[routerlink='/dashboard/cart']")
     *     WebElement cartLocator;
     *     WebDriver driver;
     *
     *     @FindBy(css = ".btn.btn-custom[routerlink='/dashboard/myorders']")
     *     WebElement orderHeader;
     *
     *     public AbstractComponent(WebDriver driver) {
     *         this.driver = driver;
     *         PageFactory.initElements(driver, this);
     *     }
     *
     *     public void waitForElementToAppear(By findBy)
     *     {
     *         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
     *         wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
     *     }
     *
     *     public void waitForElementToAppear(WebElement element)
     *     {
     *         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
     *         wait.until(ExpectedConditions.visibilityOf(element));
     *     }
     *
     *     public void waitForElementToDisappear(WebElement element)
     *     {
     *         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
     *         wait.until(ExpectedConditions.invisibilityOf(element));
     *     }
     *
     *     public CartPage goToCartPage()
     *     {
     *         cartLocator.click();
     *         CartPage cartPage = new CartPage(driver);
     *         return cartPage;
     *     }
     *
     * */
}
