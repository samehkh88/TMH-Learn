package steps;

import Pages.HomePage;
import Pages.UserRegisterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import tests.TestBase;

import java.io.IOException;

public class UserRegistrationTest extends TestBase {

    UserRegisterPage RegisterPageObject ;
    HomePage HomepageObject ;


    @Given("The User in home page")
    public void the_user_in_home_page() {
        Assert.assertEquals(true , true);

    }

    @When("the user click on register link")
    public void the_user_click_on_register_link() {
        driver.navigate().to("https://demo.nopcommerce.com/register?returnUrl=%2F");

    }

    //@And("I_entered <firstname>, <lastname> ,<email> , <password>,<cpassword>" )
    @When("I entered {string} , {string} , {string} , {string} , {string}")
    public void I_entered (String firstname , String lastname , String email , String passwork , String cpassword) {
        RegisterPageObject = new UserRegisterPage(driver);
        RegisterPageObject.UserRegister
                (firstname,lastname,email,passwork ,cpassword);

    }
    @When("the registration page display successfully")
    public void the_registration_page_display_successfully() {
        Assert.assertEquals( "Your registration completed", RegisterPageObject.SuccessMessage.getText());
    }
    @Then("the user can logout")
    public void the_user_can_logout() {
        HomepageObject = new HomePage(driver);
        HomepageObject.Click_LogOut();
    }
}
