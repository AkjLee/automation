package automation.PageOjectModel.pages;

import common.helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardPage {

    private WebDriver driver;
    private Helpers helpers;
    private By checkText = By.xpath("//h1[normalize-space()='Projects']");
    private String url = "/dashboard";
    public DashboardPage(WebDriver driver){

        driver = driver;
        helpers = new Helpers(driver);

    }

    public ProjectPage checkPage(){

        Assert.assertTrue(helpers.verifyEmlementExit(checkText), " Elements không tồn tại");
        helpers.waitForPageLoaded();
        Assert.assertTrue(helpers.verifyURL(url), "Không phải trang Dashboard");
        helpers.verifyEmlementText(checkText, "Dashboard");

        return new ProjectPage(driver);
    }


}
