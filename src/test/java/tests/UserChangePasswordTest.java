package tests;

import Pages.*;
import data.Exlreader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserChangePasswordTest extends TestBase {
    HomePage HomeObject;
    UserDashboard UserDashboardObject ;
    UserChangePasswordPage UserChangePasswordPageObject ;
    UserLoginPage LoginPageObject ;


    @DataProvider(name = "TestData1")
    public  Object [][] UserData () throws IOException {
        Exlreader Read = new Exlreader();
        return Read.GetExlData(0,5);
    }


    @Test(dataProvider = "TestData1")

    public void UserCanChangePassword(String name , String lastName , String email , String Pass , String Cpass){

        // object from the logon test case
        HomeObject = new HomePage(driver);
        HomeObject.Click_login();

        LoginPageObject = new UserLoginPage(driver);
        LoginPageObject.Userlogin(email,Pass);

        // Assert that user login successfully
        Assert.assertEquals(true , HomeObject.logOutLink.isDisplayed());

        // open my account
        HomeObject = new HomePage(driver);
        HomeObject.Click_MyAccount();

        // open page ChangePassword
        UserDashboardObject = new UserDashboard(driver);
        UserDashboardObject.OpenChangePasswordPage();

        // change password form
        UserChangePasswordPageObject = new UserChangePasswordPage(driver);
        UserChangePasswordPageObject.UserChangePassword(Pass,"Max@123","Max@123");

        // Assertion
        Assert.assertEquals(true , UserChangePasswordPageObject.ChangePasswordSuccessMessage.getText().equalsIgnoreCase("Password was changed"));
    }
}
