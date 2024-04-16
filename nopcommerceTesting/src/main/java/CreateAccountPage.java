import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccountPage extends PageBase{
    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }
    private By FirstName = By.id("firstname");
    private By LastName = By.id("lastname");
    private By EmailAddress = By.id("email_address");
    private By Password = By.id("password");
    private By PasswordConfirmation = By.id("password-confirmation");

    private  By CreateAnAccountButton = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");

    private final By nameErrorMsg = By.xpath("/html/body/div[2]/main/div[2]/div[2]/div/div/div");

    private final By AlreadyAccountLinkLocator = By.xpath("//div[@class='message-error error message']");
    private final By SamePassTextLocator = By.xpath("//div[@id='password-confirmation-error']");
    private final By ClassPassErrorTextLocator = By.xpath("//div[@id='password-error']");
    private final By EmailMsgLocator = By.cssSelector("#email_address-error.mage-error");

    private final By errorPasswordLength=By.xpath("/html/body/div[2]/main/div[3]/div/form/fieldset[2]/div[2]/div/div[1]");



    public void setFirstName(String firstName)
    {
        driver.findElement(FirstName).sendKeys(firstName);
    }

    public void setLastName(String lastName)
    {
        driver.findElement(LastName).sendKeys(lastName);
    }

    public void setEmailAddress(String emailAddress)
    {
        driver.findElement(EmailAddress).sendKeys(emailAddress);
    }

    public void setPassword(String password)
    {
        driver.findElement(Password).sendKeys(password);
    }

    public void setPasswordConfirmation(String passwordConfirmation)
    {
        driver.findElement(PasswordConfirmation).sendKeys(passwordConfirmation);
    }

    public MyAccountPage ClickingOnCreateAccount()
    {
        driver.findElement(CreateAnAccountButton).click();
        return new MyAccountPage(driver);
    }

    public String getNameErrorMsg() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameErrorMsg));
        return driver.findElement(nameErrorMsg).getText();
    }

    public String getAlreadyAccountText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AlreadyAccountLinkLocator));
        return driver.findElement(AlreadyAccountLinkLocator).getText();
    }

    public String getEmailErrorText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmailMsgLocator));
        return driver.findElement(EmailMsgLocator).getText();
    }

    public String getSamePassText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SamePassTextLocator));
        return driver.findElement(SamePassTextLocator).getText();
    }

    public String getPassErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorPasswordLength));
        return driver.findElement(errorPasswordLength).getText();
    }
    public String getClassPassErrorText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ClassPassErrorTextLocator));
        return driver.findElement(ClassPassErrorTextLocator).getText();
    }
}
