import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage extends PageBase {
    public SignInPage(WebDriver driver) {
        super(driver);
    }
    private By Email= By.id("email");
    private By Password=By.id("pass");
    private By SignInButton=By.id("send2");

    private By InvalidSignInAlert=By.xpath
            ("/html/body/div[2]/main/div[2]/div[2]/div/div/div");

    private By InvalidEmailAlert=By.id("email-error");

    private By BlankPasswordAlert=By.id("pass-error");


    public void setEmail(String email)
    {
        driver.findElement(Email).sendKeys(email);
    }
    public void setPassword(String password)
    {
        driver.findElement(Password).sendKeys(password);
    }


    public MyAccountPage ClickingOnSignInButton()
    {
        driver.findElement(SignInButton).click();
        return new MyAccountPage(driver);
    }

    public String getInValidSignInAlert()
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(InvalidSignInAlert));
        return driver.findElement(InvalidSignInAlert).getText();
    }

    public String   getInValidEmailAlert()
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(InvalidEmailAlert));
        return driver.findElement(InvalidEmailAlert).getText();
    }

    public String getBlankPasswordAlert()
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(BlankPasswordAlert));
        return driver.findElement(BlankPasswordAlert).getText();
    }
}
