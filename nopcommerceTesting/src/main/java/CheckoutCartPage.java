import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCartPage extends PageBase{
    public CheckoutCartPage(WebDriver driver) {
        super(driver);
    }

    private By ProccedToCheckoutButton =By.cssSelector(".action .primary .checkout");

    public ShippingPage ClickOnCheckoutButton() {

        driver.findElement(ProccedToCheckoutButton).click();
        return new ShippingPage(driver);
    }
}
