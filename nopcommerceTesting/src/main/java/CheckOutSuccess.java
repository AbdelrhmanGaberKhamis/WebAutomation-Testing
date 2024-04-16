import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutSuccess extends PageBase{
    public CheckOutSuccess(WebDriver driver) {
        super(driver);
    }

    private By successText= By.xpath("/html/body/div[2]/main/div[1]/h1/span");

    public String GetSuccessChkOutText()
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(successText));
        return driver.findElement(successText).getText();
    }
}
