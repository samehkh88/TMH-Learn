package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterPage extends PageBase {

    public UserRegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    WebElement MaleGender;

    @FindBy(id = "gender-female")
    WebElement FemaleGender;

    @FindBy(id = "FirstName")
    WebElement firstName;

    @FindBy(id = "LastName")
    WebElement LastName;

    @FindBy(id = "Email")
    WebElement EmailField;

    @FindBy(id = "Password")
    WebElement PasswordField;

    @FindBy(id = "ConfirmPassword")
    WebElement ConfirmPassword;

    @FindBy(id = "register-button")
    WebElement RegisterButton;

    @FindBy(className = "result")
    public WebElement SuccessMessage;

    public void UserRegister(String Fname, String Lname, String Email, String Password, String CPassword) {
        ClickButton(MaleGender);
        SendData(firstName, Fname);
        SendData(LastName, Lname);
        SendData(EmailField, Email);
        SendData(PasswordField, Password);
        SendData(ConfirmPassword, CPassword);
        ClickButton(RegisterButton);
    }

}
