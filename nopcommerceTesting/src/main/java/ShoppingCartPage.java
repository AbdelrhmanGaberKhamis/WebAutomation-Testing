import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage extends PageBase {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    private By chkOutBtn = By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/div[1]/ul/li[1]/button");

    private By setQtyField=By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[3]/div/div/label/input");

    private By updateCartBtn=By.cssSelector("#form-validate > div.cart.main.actions > button.action.update");
    private By UpdateQtyAlert = By.xpath("/html/body/div[2]/main/div[3]/div/div[3]/form/div[1]/table/tbody/tr[1]/td[3]/div/div/label/div");
    public ShippingPage ClickingOnChkOutBtn() {
        wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(chkOutBtn));
        driver.findElement(chkOutBtn).click();
        return new ShippingPage(driver);
    }

    public void clearQty() {
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(setQtyField));
        driver.findElement(setQtyField).clear();
    }
    public void SetQty(String qty) {
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(setQtyField));
        driver.findElement(setQtyField).sendKeys(qty);
    }
    public void ClickingOnUpdateCartBtn() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(updateCartBtn));
        driver.findElement(updateCartBtn).click();
    }
    public String getUpdateQtyAlertText() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(UpdateQtyAlert));
        return driver.findElement(UpdateQtyAlert).getText();
    }
}
