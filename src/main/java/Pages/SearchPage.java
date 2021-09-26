package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchPage extends PageBase {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "small-searchterms")
    WebElement SearchTextBox;

    @FindBy(xpath = "//ul[@id='ui-id-1']/li/a/span")
    java.util.List<WebElement> SearchList;

    @FindBy(xpath = "//button[contains(@class, 'search-box-button')]")
    WebElement SearchButton;

    public void SearchNormal(String value) {
        SendData(SearchTextBox, value);
        ClickButton(SearchButton);
    }

    public void SearchWithAutoComplete(String value, String CompareValue) {

        SendData(SearchTextBox, value);

        int size = SearchList.size();

        for (int i = 0; i < SearchList.size(); i++) {
            if (SearchList.get(i).getText().contentEquals(CompareValue)) {

                SearchList.get(i).click();
            }
        }
    }


}

