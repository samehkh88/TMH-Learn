package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserChangePasswordPage extends PageBase {
    public UserChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id ="OldPassword")
    WebElement OldPassword;

    @FindBy(id ="NewPassword")
    WebElement NewPassword;

    @FindBy(id ="ConfirmNewPassword")
    WebElement ConfirmNewPassword;

    @FindBy(xpath = "//button[contains(@class,'change-password-button')]")
    WebElement SubmitButton;

    @FindBy(xpath = "")
    public WebElement ChangePasswordSuccessMessage;

    public void UserChangePassword(String OldPass , String NewPass , String ConfirmNewPass)
    {
        SendData(OldPassword , OldPass);
        SendData(NewPassword , NewPass);
        SendData(ConfirmNewPassword , ConfirmNewPass);
        ClickButton(SubmitButton);
    }
}
