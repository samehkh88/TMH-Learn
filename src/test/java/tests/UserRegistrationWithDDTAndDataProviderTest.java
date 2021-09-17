package tests;

import Pages.HomePage;
import Pages.UserRegisterPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserRegistrationWithDDTAndDataProviderTest extends TestBase {
    HomePage HomeObject;
    UserRegisterPage RegisterPageObject ;

// here the way to create data provider
    @DataProvider(name = "TestData")
    public static Object [][] UserData () {
        return new Object[][]
                {
                        {"marian", "magdy", "jack@yahoo.com", "123456789", "123456789"}
                        ,
                        {"meena", "antoun","meena@yahoo.com", "123456789", "123456789"}
                };
    }

    @Test(dataProvider = "TestData")
    public void UserCanRegisterSuccessfully(String name , String lastName , String email , String Pass , String Cpass)
    {
        // user click register on home page
        driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");
        HomeObject = new HomePage(driver);

        RegisterPageObject = new UserRegisterPage(driver);
        RegisterPageObject.UserRegister
                (name,lastName,email,Pass ,Cpass);
        Assert.assertEquals( "Your registration completed", RegisterPageObject.SuccessMessage.getText());

        HomeObject.Click_LogOut();
    }
}
