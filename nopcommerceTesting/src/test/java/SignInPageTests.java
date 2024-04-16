import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SignInPageTests extends TestBase {


    @Test
    public void ValidSignIn()
    {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        SignInPage signInPage = homePage.SignInAndRedirect();
        signInPage.setEmail("abdinaas@yahoo.com");
        signInPage.setPassword("123456Ahmed#");
        MyAccountPage myAccountPage= signInPage.ClickingOnSignInButton();
        String Actual = myAccountPage.getValidSignInAlert(); // assert that signOut Button Appears
        String Expected="Sign Out";
        Assert.assertEquals(Actual,Expected);
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        homePage.ClickingOnSignOutButton();
    }
    @Test
    public void InvalidEmailFormatSignIn()
    {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        SignInPage signInPage = homePage.SignInAndRedirect();
        signInPage.setEmail("abdinaas");
        signInPage.setPassword("123456Ahmed#");
        MyAccountPage myAccountPage= signInPage.ClickingOnSignInButton();
        String Actual = signInPage.getInValidEmailAlert();
        String Expected = "Please enter a valid email address (Ex: johndoe@domain.com).";
        Assert.assertEquals(Actual,Expected);
    }
    @Test
    public void InvalidEmailSignIn()
    {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        homePage.SignInAndRedirect();
        signInPage.setEmail("tommith@yahoo.com");
        signInPage.setPassword("123456Ahmed#");
        MyAccountPage myAccountPage= signInPage.ClickingOnSignInButton();
        String Actual = signInPage.getInValidSignInAlert();
        String Expected = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        Assert.assertEquals(Actual,Expected);
    }
    @Test
    public void InvalidPasswordSignIn()
    {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        SignInPage signInPage = homePage.SignInAndRedirect();
        signInPage.setEmail("abdinaas@yahoo.com");
        signInPage.setPassword("123456Ahmed");
        MyAccountPage myAccountPage= signInPage.ClickingOnSignInButton();
        String Actual = signInPage.getInValidSignInAlert();
        String Expected = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        Assert.assertEquals(Actual,Expected);
    }
    @Test
    public void BlankPasswordSignIn()
    {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        SignInPage signInPage = homePage.SignInAndRedirect();
        signInPage.setEmail("abdinaas@yahoo.com");
        signInPage.setPassword("");
        MyAccountPage myAccountPage= signInPage.ClickingOnSignInButton();
        String Actual = signInPage.getBlankPasswordAlert();
        String Expected = "This is a required field.";
        Assert.assertEquals(Actual,Expected);
    }
    @Test
    public void BlankEmailSignIn()
    {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        SignInPage signInPage = homePage.SignInAndRedirect();
        signInPage.setEmail("");
        signInPage.setPassword("123456Ahmed#");
        MyAccountPage myAccountPage= signInPage.ClickingOnSignInButton();
        String Actual = signInPage.getInValidEmailAlert();
        String Expected = "This is a required field.";
        Assert.assertEquals(Actual,Expected);
    }
}
