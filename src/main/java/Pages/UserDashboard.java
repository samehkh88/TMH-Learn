package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserDashboard extends PageBase{

    public UserDashboard(WebDriver driver) {
        super(driver);
    }

    /*
    @FindBy(xpath = "//li[@class='customer-addresses.inactive']/a")
    WebElement MyAddress ;
*/
    @FindBy(linkText = "Addresses")
    WebElement MyAddress ;

    @FindBy(linkText = "Change password")
    WebElement ChangePassword ;

    public void OpenMyAddressPage()
    {
        ClickButton(MyAddress);
    }

    public void OpenChangePasswordPage()
    {
        ClickButton(ChangePassword);
    }
}
