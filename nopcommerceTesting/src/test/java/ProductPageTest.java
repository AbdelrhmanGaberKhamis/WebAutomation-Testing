import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTest extends TestBase{


    @Test
    public void TC_validAddToCart() {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
       homePage.ChoosingAProduct();
       productPage.ChoosingSize();
       productPage.ChoosingColor();
       productPage.CLearQuantity();
       productPage.SetQuantity("2");
       productPage.AddToCart();
       String Expected="You added Hero Hoodie to your shopping cart.";
       String Actual= productPage.AddedToCartAlert();
       Assert.assertEquals(Actual,Expected);
    }
    @Test
    public void TC_VerifyNotChoosingSize()
    {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        homePage.ChoosingAProduct();
        // productPage.ChoosingSize();
        productPage.ChoosingColor();
        productPage.CLearQuantity();
        productPage.SetQuantity("2");
        productPage.AddToCart();
        String Expected="This is a required field.";
        String Actual= productPage.getSizeAlert();
        Assert.assertEquals(Actual,Expected);
    }
    @Test
    public void TC_VerifyNotChoosingColor()
    {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        homePage.ChoosingAProduct();
        productPage.ChoosingSize();
        //productPage.ChoosingColor();
        productPage.CLearQuantity();
        productPage.SetQuantity("2");
        productPage.AddToCart();
        String Expected="This is a required field.";
        String Actual= productPage.getColorAlert();
        Assert.assertEquals(Actual,Expected);
    }
    @Test
    public void TC_VerifyZeroQuantity()
    {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        homePage.ChoosingAProduct();
        productPage.ChoosingSize();
        productPage.ChoosingColor();
        productPage.CLearQuantity();
        productPage.SetQuantity("0");
        productPage.AddToCart();
        String Expected="Please enter a quantity greater than 0.";
        String Actual= productPage.getQuantityAlert();
        Assert.assertEquals(Actual,Expected);
    }
    @Test
    public void TC_VerifyNegativeQuantity()
    {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        homePage.ChoosingAProduct();
        productPage.ChoosingSize();
        productPage.ChoosingColor();
        productPage.CLearQuantity();
        productPage.SetQuantity("-1");
        productPage.AddToCart();
        String Expected="Please enter a quantity greater than 0.";
        String Actual= productPage.getQuantityAlert();
        Assert.assertEquals(Actual,Expected);
    }

}
