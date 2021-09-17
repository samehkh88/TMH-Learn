package tests;

import Pages.HomePage;
import Pages.UserRegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserRegistrationTest extends TestBase {
    HomePage HomeObject;
    UserRegisterPage RegisterPageObject ;


    @Test
    public void UserCanRegisterSuccessfully()
    {
        // user click register on home page
        driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
        HomeObject = new HomePage(driver);

        RegisterPageObject = new UserRegisterPage(driver);
        RegisterPageObject.UserRegister
        ("sameh","khalil","44@yahoo.com","Test@123" ,"Test@123");
        Assert.assertEquals( "Your registration completed", RegisterPageObject.SuccessMessage.getText());

        HomeObject.Click_LogOut();
    }
}
