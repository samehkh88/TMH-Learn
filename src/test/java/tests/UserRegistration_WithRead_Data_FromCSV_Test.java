package tests;

import Pages.HomePage;
import Pages.UserRegisterPage;
import data.Exlreader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserRegistration_WithRead_Data_FromCSV_Test extends TestBase {
    HomePage HomeObject;
    UserRegisterPage RegisterPageObject ;

// here the way to create data provider for read data from exl
    @DataProvider(name = "TestData1")
    public  Object [][] UserData () throws IOException {
        Exlreader Read = new Exlreader();
        return Read.GetExlData(0,5);
    }


    @Test(dataProvider = "TestData1")
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
