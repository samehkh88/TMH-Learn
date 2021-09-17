package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.sql.Struct;

public class PageBase {

    public PageBase (WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    protected WebDriver driver;

    protected static void ClickButton(WebElement button)
    {
        button.click();
    }

    protected static void SendData(WebElement FieldText , String value)
    {
        FieldText.sendKeys(value);
    }
    protected static void EmptyData(WebElement FieldText)
    {
        FieldText.clear();
    }



}
