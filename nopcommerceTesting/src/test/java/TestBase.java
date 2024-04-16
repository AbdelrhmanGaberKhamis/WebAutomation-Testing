import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestBase {
    protected WebDriver driver;

    protected HomePage homePage;
    protected SignInPage signInPage;

    protected CreateAccountPage createAccountPage;

    protected ProductPage productPage;
    protected ShippingPage shippingPage;
    protected ShoppingCartPage shoppingCartPage;
    protected PaymentPage paymentPage;
    protected CheckOutSuccess checkOutSuccess;
    @BeforeClass
    public void Setup()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        createAccountPage=new CreateAccountPage(driver);
        signInPage = new SignInPage(driver);
        homePage= new HomePage(driver);
        productPage=new ProductPage(driver);
        shoppingCartPage=new ShoppingCartPage(driver);
        shippingPage=new ShippingPage(driver);
        paymentPage=new PaymentPage(driver);
        checkOutSuccess=new CheckOutSuccess(driver);

    }



    @AfterClass
    public void Close()
    {
        driver.quit();
    }


}
