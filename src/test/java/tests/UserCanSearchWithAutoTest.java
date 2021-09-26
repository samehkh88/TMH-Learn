package tests;

import Pages.ProductDetailsPage;
import Pages.SearchPage;
import data.Exlreader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserCanSearchWithAutoTest extends TestBase {

    SearchPage SearchPageObject;

    // here the way to create data provider for read data from exl
    @DataProvider(name = "ProductSearch")
    public Object[][] UserData() throws IOException {
        Exlreader Read = new Exlreader();
        return Read.GetExlData(1, 3);
    }

    @Test(dataProvider = "ProductSearch")
    public void UserCanSearchWith_AutoComplete_Successfully(String SearchText, String ProductName, String AssertText) {
        SearchPageObject = new SearchPage(driver);
        SearchPageObject.SearchWithAutoComplete(SearchText, ProductName);


        // Assertion
        ProductDetailsPage ProductDetailsPageObject = new ProductDetailsPage(driver);
        Assert.assertEquals(true, ProductDetailsPageObject.ProductName.getText().equalsIgnoreCase(AssertText));
    }
}
