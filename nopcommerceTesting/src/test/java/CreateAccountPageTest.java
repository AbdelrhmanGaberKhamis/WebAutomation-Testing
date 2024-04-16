import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class CreateAccountPageTest extends TestBase{
    WebDriverWait wait;

    @Test
    public void VerifySuccessfullyRegistration() {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        homePage.CreateAccountButton();
        createAccountPage.setFirstName("Abdelrhman");
        createAccountPage.setLastName("Gaber");
        createAccountPage.setEmailAddress("Abdelrhman12326@yahoo.com");
        createAccountPage.setPassword("123457Ahmed#");
        createAccountPage.setPasswordConfirmation("123457Ahmed#");
        MyAccountPage myAccountPage = createAccountPage.ClickingOnCreateAccount();
        String actual = myAccountPage.getCreateAccountSuccessfulyAlert();
        String expected = "Thank you for registering with Main Website Store.";
        Assert.assertTrue(actual.contains(expected), "Actual: " + actual + " is not equal to Expected: " + expected);
        homePage.ClickingOnSignOutButton();
    }
    @Test
    public void TC_VerifyFirstnameField() {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        homePage.CreateAccountButton();
        createAccountPage.setFirstName("&&ziad");
        createAccountPage.setLastName("Mahmoud");
        createAccountPage.setEmailAddress("Ziad##@gmail.com");
        createAccountPage.setPassword("123456Ahmed++");
        createAccountPage.setPasswordConfirmation("123456Ahmed++");
        MyAccountPage myAccountPage = createAccountPage.ClickingOnCreateAccount();
        String actual =createAccountPage.getNameErrorMsg();
        Assert.assertEquals(actual,"First Name is not valid!");
    }
    @Test
    public void TC_VerifyLastnameField() {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        homePage.CreateAccountButton();
        createAccountPage.setFirstName("ziad");
        createAccountPage.setLastName("&&Mahmoud");
        createAccountPage.setEmailAddress("Ziad##@gmail.com");
        createAccountPage.setPassword("123456Ahmed++");
        createAccountPage.setPasswordConfirmation("123456Ahmed++");
        MyAccountPage myAccountPage = createAccountPage.ClickingOnCreateAccount();
        String actual =createAccountPage.getNameErrorMsg();
        Assert.assertEquals(actual,"Last Name is not valid!");
    }
    @Test()
    public void TC_VerifyAlreadyAccount() {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        homePage.CreateAccountButton();
        createAccountPage.setFirstName("Ahmed");
        createAccountPage.setLastName("Mahmoud");
        createAccountPage.setEmailAddress("abdinaas@yahoo.com");
        createAccountPage.setPassword("123456Ahmed#");
        createAccountPage.setPasswordConfirmation("123456Ahmed#");
        MyAccountPage myAccountPage = createAccountPage.ClickingOnCreateAccount();
        String actual =createAccountPage.getAlreadyAccountText();
        Assert.assertEquals(actual,
                    "There is already an account with this email address. " +
                        "If you are sure that it is your email address, " +
                        "click here to get your password and access your account.");
    }
    @Test()
    public void TC_VerifyEmailFormatMsg() {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        homePage.CreateAccountButton();
        createAccountPage.setFirstName("Ahmed");
        createAccountPage.setLastName("Mahmoud");
        createAccountPage.setEmailAddress("ABCDss55");
        createAccountPage.setPassword("123456Ahmed#");
        createAccountPage.setPasswordConfirmation("123456Ahmed#");
        MyAccountPage myAccountPage = createAccountPage.ClickingOnCreateAccount();
        String actual =createAccountPage.getEmailErrorText();
        Assert.assertEquals(actual,"Please enter a valid email address (Ex: johndoe@domain.com).");

    }
    @Test(testName = "TC_VerifyUnmatchedPassMsg", description = "Verify unmatched password and confirm password is not accepted")
    public void TC_VerifyUnmatchedPassMsg() {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        homePage.CreateAccountButton();
        createAccountPage.setFirstName("Ahmed");
        createAccountPage.setLastName("Mahmoud");
        createAccountPage.setEmailAddress("Email12@Vaild.com");
        createAccountPage.setPassword("123456Ahmed#");
        createAccountPage.setPasswordConfirmation("123456Ahmed++");
        MyAccountPage myAccountPage = createAccountPage.ClickingOnCreateAccount();
        String actual =createAccountPage.getSamePassText();
        Assert.assertEquals(actual,"Please enter the same value again.");

    }


    @Test(testName = "TC_VerifyPassword",description = " Verify password Minimum length of  field equal or greater than 8 symbols")
    public void TC_VerifyBlankConfirmationPassword() {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        homePage.CreateAccountButton();
        createAccountPage.setFirstName("Ahmed");
        createAccountPage.setLastName("Mahmoud");
        createAccountPage.setEmailAddress("Email12@Vaild.com");
        createAccountPage.setPassword("123");
        createAccountPage.setPasswordConfirmation("123");
        MyAccountPage myAccountPage = createAccountPage.ClickingOnCreateAccount();
        String actual = createAccountPage.getPassErrorMessage();
        String expected = "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored";
        Assert.assertTrue(actual.contains(expected), "Actual: " + actual + " is not equal to Expected: " + expected);

    }
    @Test(testName = "TC_VerifyPasswordClasses",description = " Verify password Minimum of different classes of characters in password is 3. Classes of characters: Lower Case, Upper Case, Digits, Special Characters.")
    public void TC_VerifyPasswordClasses() {
        driver.navigate().to("https://magento.softwaretestingboard.com/");
        homePage.CreateAccountButton();
        createAccountPage.setFirstName("Ahmed");
        createAccountPage.setLastName("Mahmoud");
        createAccountPage.setEmailAddress("Email12@Vaild.com");
        createAccountPage.setPassword("12345678");
        createAccountPage.setPasswordConfirmation("12345678");
        String actual = createAccountPage.getClassPassErrorText();
        String expected = "Minimum of different classes of characters in password is 3.";
        Assert.assertTrue(actual.contains(expected),"Different classes are not verified");
    }
}
