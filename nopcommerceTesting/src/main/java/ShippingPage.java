import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class ShippingPage extends PageBase{

    public ShippingPage(WebDriver driver) {
        super(driver);
    }
    private By ShippingAddressText = By.cssSelector("#shipping > div.step-title");

    private By EmailAddress=By.xpath
            ("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form[1]/fieldset/div/div/input");

    private By FirstName=By.xpath
            ("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[1]/div/input");

    private By LastName =By.xpath
            ("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[2]/div/input");

    private By StreetAddress =By.xpath
            ("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/fieldset/div/div[1]/div/input");
    private By City =By.xpath
            ("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[4]/div/input");


//    private By selectState =By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[5]/div/select");
//    Select state = new Select(driver.findElement(selectState));



    private By postalCode =By.xpath
            ("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[7]/div/input");

    //private By country=By.cssSelector("div[class='control']>select[name='region_id']");
    private By country=By.xpath
            ("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[8]/div/select");

   // Select dropMenu=new Select(driver.findElement(country));



    //WebElement dropdown = driver.findElement(By.cssSelector("div[class='control']>select[name='region_id']"));

    //Select selectCountry = new Select(dropdown);


    private By phoneNumber =By.xpath
            ("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[1]/div[2]/form[2]/div/div[9]/div/input");
    private By shippingMethodBtn=
            By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[2]/div/div[3]/form/div[1]/table/tbody/tr[2]/td[1]/input");

    private By NextBtn=
            By.xpath("/html/body/div[2]/main/div[2]/div/div[3]/div[4]/ol/li[2]/div/div[3]/form/div[3]/div/button");

    public String getShippingAddressText() {
        wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(ShippingAddressText));
        return driver.findElement(ShippingAddressText).getText();
    }
    public void SetEmailAddress(String email)
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(EmailAddress));
        driver.findElement(EmailAddress).sendKeys(email);
    }

    public void SetFirstName(String firstname)
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.textToBePresentInElementValue(EmailAddress,"Abdinaaas9999@yahoo.com"));
        driver.findElement(FirstName).sendKeys(firstname);
    }

    public void SetSecondName(String lastname)
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LastName));
        driver.findElement(LastName).sendKeys(lastname);
    }
    public void SetStreet(String street)
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(StreetAddress));
        driver.findElement(StreetAddress).sendKeys(street);
    }

    public void SetCity(String city)
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(City));
        driver.findElement(City).sendKeys(city);
    }
    public void chooseState()
    {
        WebElement regionSelect = driver.findElement(By.name("region_id"));
        Select regionDropdown = new Select(regionSelect);
        regionDropdown.selectByValue("18"); // selects the "Florida" option
    }
    public void SetPostalCode(String postCode)
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(postalCode));
        driver.findElement(postalCode).sendKeys(postCode);
    }
    public void chooseCountry()
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(country));
        //dropMenu.selectByVisibleText("United States");
    }

    public void SetPhoneNumber(String postCode)
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNumber));
        driver.findElement(phoneNumber).sendKeys(postCode);
    }
    public void SelectShippingMethodToBeFixed()
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(shippingMethodBtn));
        driver.findElement(shippingMethodBtn).click();
    }
    public PaymentPage ClickingOnNextBtn()
    {
        wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(NextBtn));
        driver.findElement(NextBtn).click();
        return new PaymentPage(driver);
    }
}
