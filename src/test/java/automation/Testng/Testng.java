package automation.Testng;

import automation.PageOjectModel.base.BaseSetup;
import automation.PageOjectModel.pages.SignInPage;
import common.helpers.Helpers;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ultilities.Log;
import utils.listeners.ReportListener;




@Listeners(ReportListener.class)
@Epic("Regression Test CRM")
@Feature("Project Test")
public class Testng {

    private WebDriver driver;
    private SignInPage signInPage;
    private String url = "/Dashboard";
    private Helpers helpers;

    @BeforeClass
    public void setupBrowser() {
        //driver = getDriver();  //extends BaseSetup
        driver = new BaseSetup().setupDriver("chrome");
    }

    @Step("Truy cập trang")
    @Test(description = "Truy cập trang url")
    public void run() throws InterruptedException {
        Log.info("123");
        signInPage = new SignInPage(driver);
        driver.get("https://rise.fairsketch.com/");
        driver.findElement(By.xpath("//div[normalize-space()='Client']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Sign in']")).click();
        Thread.sleep(3000);
        System.out.println(url);
        WebElement check1 = driver.findElement(By.xpath("//h1[normalize-space()='Projects']"));
        System.out.println(check1.getText());

    }
    @AfterClass
    public void closeBrowser() {
        driver.close();
    }

}
