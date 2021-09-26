package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLoginPage extends PageBase {
    public UserLoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    WebElement EmailField;

    @FindBy(id = "Password")
    WebElement PasswordField;

    @FindBy(xpath = " //button[text()='Log in']")
    WebElement SubmitButton;

    public void Userlogin(String Email, String password) {
        SendData(EmailField, Email);
        SendData(PasswordField, password);
        ClickButton(SubmitButton);
    }


}
