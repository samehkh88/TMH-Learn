package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Register")
    WebElement RegisterLink;

    @FindBy(xpath = "//a[contains(@class,'ico-login')]")
    public WebElement LoginLink;

    @FindBy(xpath = "//a[contains(@class,'ico-logout')]")
    public WebElement logOutLink;

    @FindBy(xpath = "//a[contains(@class,'ico-account')]")
    public WebElement MyAccountLink;


    public void Click_register() {

        System.out.println("the button link is : " + RegisterLink.getText());
    }

    public void Click_login() {
        ClickButton(LoginLink);
    }

    public void Click_LogOut() {
        ClickButton(logOutLink);
    }

    public void Click_MyAccount() {
        ClickButton(MyAccountLink);
    }
}

