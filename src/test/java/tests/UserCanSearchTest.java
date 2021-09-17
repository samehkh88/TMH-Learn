package tests;

import Pages.ProductDetailsPage;
import Pages.ProductListPage;
import Pages.SearchPage;
import data.Exlreader;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserCanSearchTest extends TestBase {

    SearchPage SearchPageObject ;
    ProductListPage ProductListPageObject ;
    // here the way to create data provider for read data from exl
    @DataProvider(name = "Productsearch")
    public  Object [][] UserData () throws IOException {
        Exlreader Read = new Exlreader();
        return Read.GetExlData(1,3);
    }

    @Test(dataProvider = "Productsearch")
    public void UserCanSearchSuccessfully(String SearchText, String ProductName , String AssertText)
    {
        SearchPageObject = new SearchPage(driver);
        SearchPageObject.SearchNormal( SearchText);

        ProductListPageObject = new ProductListPage(driver);
        ProductListPageObject.GetProductFromList(ProductName);


        // Assertion
        ProductDetailsPage ProductDetailsPageObject = new ProductDetailsPage(driver);
        Assert.assertEquals(true ,ProductDetailsPageObject.ProductName.getText().equalsIgnoreCase(AssertText));
    }
}
