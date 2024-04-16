import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage extends PageBase{
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private By size=By.id("option-label-size-143-item-167");

    private By color=By.id("option-label-color-93-item-52");

    private By quantity=By.id("qty");

    private By AddToCartBtn=By.id("product-addtocart-button");
    private By AddedToCartText=By.xpath("//*[@id='maincontent']/div[1]/div[2]/div/div/div");

    private By sizeAlertText=By.xpath("//*[@id='super_attribute[143]-error']");
    private By colorAlertText=By.xpath("//*[@id='super_attribute[93]-error']");

    private By quantityErrorText=By.id("qty-error");

    private By ShoppingCartButton = By.xpath("//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div/a");

    public void ChoosingSize()
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(size));
        driver.findElement(size).click();

    }
    public void ChoosingColor()
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(color));
        driver.findElement(color).click();
    }

    public void SetQuantity(String qty)
    {
        driver.findElement(quantity).sendKeys(qty);
    }
    public void AddToCart()
    {
        driver.findElement(AddToCartBtn).click();
    }

    public String AddedToCartAlert() {
        wait= new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AddedToCartText));
        return driver.findElement(AddedToCartText).getText();
    }
    public String getSizeAlert() {
        wait= new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(sizeAlertText));
        return driver.findElement(sizeAlertText).getText();

    }
    public String getColorAlert() {
        wait= new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(colorAlertText));
        return driver.findElement(colorAlertText).getText();

    }

    public String getQuantityAlert() {
        wait= new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(quantityErrorText));
        return driver.findElement(quantityErrorText).getText();

    }
    public void CLearQuantity() {
        driver.findElement(quantity).clear();
    }
    public ShoppingCartPage RedirectToShoppingCartPage()
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ShoppingCartButton));
        driver.findElement(ShoppingCartButton).click();
        return new ShoppingCartPage(driver);
    }


}
