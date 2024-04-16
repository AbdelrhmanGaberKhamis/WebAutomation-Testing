import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends PageBase{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    private By SuccefulCreateAccountMessage = By.cssSelector
            ("div[class^='message-success']");




    private By EmailInfo=By.cssSelector
            ("#maincontent > div.columns > div.column.main > div.block.block-dashboard-info > div.block-content > div > div.box-content > p");

    private By signOutButton= By.xpath
            ("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a");
    private By drpDownMenu=By.cssSelector("[data-action='customer-menu-toggle']");

    private By SuccessfullRegistrationMsg =By.className("message-success");;

    public String getCreateAccountSuccessfulyAlert()
    {
        wait=new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(SuccessfullRegistrationMsg));
        return driver.findElement(SuccefulCreateAccountMessage).getText();
    }



    public String getValidSignInAlert()
    {
        wait=new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(drpDownMenu));
        driver.findElement(drpDownMenu).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(signOutButton));
        String signout = driver.findElement(signOutButton).getText();
        return signout;

    }




}

