package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.PublicKey;

public class ContactUsPage extends PageBase {
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FullName")
    private WebElement YourName;

    @FindBy(id = "Email")
    private WebElement Email;

    @FindBy(id = "Enquiry")
    private WebElement Message;

    @FindBy(xpath = "//button[contains(@class,'contact-us-button')]")
    private WebElement SubmitButton;

    @FindBy(xpath = "//div[@class='result']")
    public WebElement SuccessMessage;

    @FindBy(linkText = "Contact us")
    public WebElement ContactLink ;


    public void ClickContactLink()
    {
        ClickButton(ContactLink);
    }
    public void SubmitContact(String name, String email, String message) {
        SendData(YourName, name);
        EmptyData(Email);
        SendData(Email, email);
        SendData(Message, message);
        ClickButton(SubmitButton);
    }
}

