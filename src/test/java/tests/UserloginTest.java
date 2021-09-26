package tests;

import Pages.HomePage;
import Pages.UserLoginPage;
import data.Exlreader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserloginTest extends TestBase {
    HomePage HomeObject;
    UserLoginPage LoginPageObject;


    // here the way to create data provider for read data from exl
    @DataProvider(name = "TestData1")
    public Object[][] UserData() throws IOException {
        Exlreader Read = new Exlreader();
        return Read.GetExlData(0, 5);
    }


    @Test(dataProvider = "TestData1")
    public void UserCanLoginSuccessfully(String name, String lastName, String email, String Pass, String Cpass) {
        // user click register on home page

        HomeObject = new HomePage(driver);
        HomeObject.Click_login();

        LoginPageObject = new UserLoginPage(driver);
        LoginPageObject.Userlogin(email, Pass);

        // Assert that user login successfully
        Assert.assertEquals(true, HomeObject.logOutLink.isDisplayed());

        // user will logout
        HomeObject.Click_LogOut();


    }
}
