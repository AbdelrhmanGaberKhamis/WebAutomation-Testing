import org.testng.Assert;
import org.testng.annotations.Test;

public class ShippingPageTest extends TestBase{
    @Test
    public void TC_ValidShippingAddress()
    {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        homePage.ChoosingAProduct();
        productPage.ChoosingSize();
        productPage.ChoosingColor();
        productPage.CLearQuantity();
        productPage.SetQuantity("2");
        productPage.AddToCart();
        productPage.RedirectToShoppingCartPage();
        shoppingCartPage.ClickingOnChkOutBtn();
        shippingPage.SetEmailAddress("Abdinaaas9999@yahoo.com");
        shippingPage.SetFirstName("Abdelrhman");
        shippingPage.SetSecondName("Gaber");
        shippingPage.SetStreet("Campchezar");
        shippingPage.SetCity("Alex");
        shippingPage.chooseState();
        shippingPage.SetPostalCode("25162");
        shippingPage.SetPhoneNumber("01144411074");
        shippingPage.SelectShippingMethodToBeFixed();
        shippingPage.ClickingOnNextBtn();
        String Expected="Place Order";
        String Actual=paymentPage.GetPlaceOrderText();
        Assert.assertEquals(Actual,Expected);
    }
}
