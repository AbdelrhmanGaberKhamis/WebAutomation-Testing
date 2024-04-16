import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentPageTest extends TestBase{
    @Test
    public void TC_ValidPlacingOrder()
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
        paymentPage.ClickingOnPlaceOrder();
        String Expected ="Thank you for your purchase!";
        String Actual = checkOutSuccess.GetSuccessChkOutText();
        Assert.assertEquals(Actual,Expected);
    }
}
