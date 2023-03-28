package automation.PageOjectModel.testcase;

import automation.PageOjectModel.base.BaseSetup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ultilities.Log;

public class test {
    WebDriver driver;

    @BeforeClass
    public void setupDriver() {
            driver = new BaseSetup().setupDriver("chrome");
    }

    public void gotoPage() {
        Log.info("Success test 3");
        driver.get("https://anhtester.com");
        Log.info("Success test 123");
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
