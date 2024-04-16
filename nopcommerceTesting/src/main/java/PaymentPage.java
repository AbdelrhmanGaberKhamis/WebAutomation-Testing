import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentPage extends PageBase{
    public PaymentPage(WebDriver driver) {
        super(driver);
    }
    private By PlaceOrderBtn=By.xpath("/html/body/div[3]/main/div[2]/div/div[3]/div[4]/ol/li[3]/div/form/fieldset/div[1]/div/div/div[2]/div[2]/div[4]/div/button");

    private By Text=By.xpath("/html/body/div[3]/main/div[2]/div/div[3]/aside/div[2]/div/div/div[1]/table/tbody/tr[3]/th/strong");

    private By Text1=By.className("billing-address-details");
    public CheckOutSuccess ClickingOnPlaceOrder()
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Text1));
        driver.findElement(PlaceOrderBtn).click();
        return new CheckOutSuccess(driver);
    }

    public String GetPlaceOrderText()
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(PlaceOrderBtn));
        return driver.findElement(PlaceOrderBtn).getText();
    }
}
