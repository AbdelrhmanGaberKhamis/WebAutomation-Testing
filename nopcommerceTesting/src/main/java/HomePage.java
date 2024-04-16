import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    private By CreateAccountButton = By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li:nth-child(3) > a");
    private By SignInButton =By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.authorization-link > a");

    private By signOutButton = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");
    private By dropDownButton=By.cssSelector("[data-action='customer-menu-toggle']");

    private By hoodieProduct=By.xpath("//*[@id='maincontent']/div[3]/div/div[3]/div[3]/div/div/ol/li[4]/div/a/span/span/img");

    public CreateAccountPage CreateAccountButton()
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreateAccountButton));
        driver.findElement(CreateAccountButton).click();
        return new CreateAccountPage(driver);
    }
    public SignInPage SignInAndRedirect()
    {
        driver.findElement(SignInButton).click();
        return new SignInPage(driver);
    }
    public void ClickingOnSignOutButton()
    {
        driver.findElement(dropDownButton).click();
        driver.findElement(signOutButton).click();
    }

    public ProductPage ChoosingAProduct()
    {
    driver.findElement(hoodieProduct).click();
    return new ProductPage(driver);
    }

}
