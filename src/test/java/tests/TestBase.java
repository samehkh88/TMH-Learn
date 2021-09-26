package tests;

import helper.Help;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestBase extends AbstractTestNGCucumberTests {


    protected static WebDriver driver;

    @BeforeSuite
    @Parameters({"Browser"})
    public void StartDriver(@Optional("chrome") String BrowserName) throws InterruptedException {
        if (BrowserName.equalsIgnoreCase("firefox")) {
            // data for firfox
            driver = new FirefoxDriver();
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
        } else if
        (BrowserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
            driver = new ChromeDriver();
        } else if
        (BrowserName.equalsIgnoreCase("chrome-headless")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors");
            driver = new ChromeDriver(options);
        }


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.get("https://frontend.nopcommerce.com/");
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");


    }

    //take screenshot when test case fail
    @AfterMethod
    public void failTestCase(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("failed");
            Help.TakeScreenShot(driver, result.getName());
        }
    }

    @AfterClass
    public void WaitAfterClass() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @AfterSuite
    public void StopDriver() {
        driver.quit();
    }

}
