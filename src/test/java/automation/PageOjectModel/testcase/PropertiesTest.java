package automation.PageOjectModel.testcase;

import automation.PageOjectModel.base.BaseSetup;
import automation.PageOjectModel.base.SetupBrowser;
import automation.PageOjectModel.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ultilities.PropertiesFile;

public class PropertiesTest {

    private WebDriver driver;
    private SignInPage signInPage;


    @BeforeClass
    public void setupDriver (){

       // PropertiesFile.setPropertiesFile();

        //doc data tu file properties voi key la "browser"
        driver = new BaseSetup().setupDriver(PropertiesFile.getPropValue("browser"));

       // driver = getDriver();
    }

    @Test
    public  void signinRise () throws InterruptedException {
       // signInPage = new SignInPage(driver);

        driver.get("https://google.com");
        //driver.get("https://rise.fairsketch.com/");
        Thread.sleep(3000);
        //Doc data tu file properties
//        signInPage.singInPage(PropertiesFile.getPropValue("email"), PropertiesFile.getPropValue("password"));

    }



    @AfterClass
    public void tearDown(){
        driver.quit();
    }



}
