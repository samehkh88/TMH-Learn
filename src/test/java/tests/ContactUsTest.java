package tests;



import Pages.ContactUsPage;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest  extends TestBase{

    ContactUsPage ContactUsPageObject;

    @Test
    public void UserCanContactUs()
    {
        try {
            // scroll down to footer
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,1000)");
        }catch (Exception e)
        {
            System.out.println("the error is : " + e.getMessage());
        }


        //open contact us page
        ContactUsPageObject = new ContactUsPage(driver);
        ContactUsPageObject.ClickContactLink();

        //Submit the form
        ContactUsPageObject.SubmitContact("sameh", "sameh@netservex.com","hello my friend");

        //Assert
        Assert.assertTrue(ContactUsPageObject.SuccessMessage.getText().equalsIgnoreCase("Your enquiry has been successfully sent to the store owner."));
    }
}
