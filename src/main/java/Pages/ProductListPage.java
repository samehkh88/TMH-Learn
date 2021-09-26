package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductListPage extends PageBase {
    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[@class='product-title']/a")
    List<WebElement> ProductTitle;


    public void GetProductFromList(String ProductName) {
        for (int x = 0; x < ProductTitle.size(); x++) {
            if (ProductTitle.get(x).getText().equalsIgnoreCase(ProductName)) {
                ProductTitle.get(x).click();
            }
        }
    }
}
