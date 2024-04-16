import org.testng.Assert;
import org.testng.annotations.Test;

public class ShoppingCartPageTest extends TestBase{


    @Test
    public void TC_ValidRedirection() {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        homePage.ChoosingAProduct();
        productPage.ChoosingSize();
        productPage.ChoosingColor();
        productPage.CLearQuantity();
        productPage.SetQuantity("2");
        productPage.AddToCart();
        productPage.RedirectToShoppingCartPage();
        shoppingCartPage.ClickingOnChkOutBtn();
        String Expected="Shipping Address";
        System.out.println(shippingPage.getShippingAddressText());
        String Actual=shippingPage.getShippingAddressText();
        Assert.assertEquals(Actual,Expected);
    }
    @Test
    public void TC_InValidRedirection() {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        homePage.ChoosingAProduct();
        productPage.ChoosingSize();
        productPage.ChoosingColor();
        productPage.CLearQuantity();
        productPage.SetQuantity("2");
        productPage.AddToCart();
        ShoppingCartPage shoppingCartPage= productPage.RedirectToShoppingCartPage();
        shoppingCartPage.clearQty();
        shoppingCartPage.SetQty("0");
        shoppingCartPage.ClickingOnUpdateCartBtn();
        String Expected="Please enter a number greater than 0 in this field.";
        String Actual=shoppingCartPage.getUpdateQtyAlertText();
        Assert.assertEquals(Actual,Expected);
    }
}
