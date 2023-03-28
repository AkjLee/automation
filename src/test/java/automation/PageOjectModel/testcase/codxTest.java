package automation.PageOjectModel.testcase;
import automation.PageOjectModel.base.BaseSetup;
import automation.PageOjectModel.base.TestListener;
import common.helpers.CaptureHelpers;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.*;
import ultilities.Log;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class codxTest {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void homePage() throws Exception {
        driver.get("https://anhtester.com");
        //step này cố tình Fail để chụp màn hình lại
        Assert.assertEquals(driver.getTitle(), "Anh Tester - Automation Testi");
    }

    @AfterClass
    public void tearDown() throws Exception {
        Thread.sleep(1000);
        driver.quit();
    }
}
