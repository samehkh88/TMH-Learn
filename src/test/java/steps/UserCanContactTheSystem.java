package steps;

import Pages.ContactUsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import tests.TestBase;

public class UserCanContactTheSystem extends TestBase {

    ContactUsPage ContactUsPageObject;

    @When("the scroll down to the footer")
    public void the_scroll_down_to_the_footer() {
        // scroll down to footer
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

    }

    @When("the user click on contact form us form")
    public void the_user_click_on_contact_form_us_form() {

        ContactUsPageObject = new ContactUsPage(driver);
        ContactUsPageObject.ClickContactLink();
    }

    @When("the user enter the data {string} , {string} , {string}")
    public void the_user_enter_the_data(String name, String email, String message) {

        ContactUsPageObject.SubmitContact(name, email, message);
    }

    @Then("the success message displayed successfully {string}")
    public void the_success_message_displayed_successfully(String SuccessMessage) {
        Assert.assertTrue(ContactUsPageObject.SuccessMessage.getText().equalsIgnoreCase
                (SuccessMessage));


    }

}
