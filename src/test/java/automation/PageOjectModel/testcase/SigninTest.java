package automation.PageOjectModel.testcase;

//import PageOjectModel.base.*;
import automation.PageOjectModel.base.SetupBrowser;
import automation.PageOjectModel.pages.DashboardPage;
import automation.PageOjectModel.pages.ProjectPage;
import automation.PageOjectModel.pages.SignInPage;

import automation.PageOjectModel.base.TestListener;
import common.helpers.ExcelHelpers;
import common.helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Listeners(TestListener.class)
public class SigninTest {
    private Helpers helpers;
    private WebDriver driver;
    public SignInPage signInPage;
    private DashboardPage dashboardPage;
    private ProjectPage projectPage;
    private ExcelHelpers excel;

//    @BeforeClass
//    public void run() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        helpers = new Helpers(driver);
//        signInPage = new SignInPage(driver);
//        dashboardPage = new DashboardPage(driver);
//        projectPage = new ProjectPage(driver);
//        driver.get("https://rise.fairsketch.com/
//        driver = new SetupBrowser().setupDriver("chrome");
//        helpers  = new Helpers(driver);
//        excel = new ExcelHelpers();
//    }
    @BeforeClass
    public void setupDriver(){
        driver = new SetupBrowser().setupDriver("chrome");
       // driver = getDriver();
        excel = new ExcelHelpers();
    }


    @Test(priority = 1)
    public void signInPage() throws Exception {

        // Setup đường dẫn của file excel
        excel.setExcelFile("src/test/resources/Book1.xlsx", "Sheet1");

        signInPage = new SignInPage(driver);
        driver.get("https://rise.fairsketch.com/");

        //helpers.waitForPageLoaded();
        // Đọc data từ file excel
        signInPage.singInPage(excel.getCellData("email", 1), excel.getCellData("password", 1));
       // signInPage.singInPage("client@demo.com","riseDemo");
        //Ghi data vào file excel
        Thread.sleep(3000);
        excel.setCellData("Nhập xem thử đúng không !!!", 5, 0);

        Thread.sleep(1000);

    }
//    @Test(priority = 2)
//    public void checkPage() throws InterruptedException {
//
//        //helpers.waitForPageLoaded();
//        dashboardPage.checkPage();
//        Thread.sleep(1000);
//    }
//
//    @Test(priority = 3)
//    public void addProject() throws InterruptedException {
//
//        //helpers.waitForPageLoaded();
//        projectPage.addnewproject();
//        Thread.sleep(1000);
//    }
//    @Test(priority = 4)
//    public void searchProject() throws InterruptedException {
//        projectPage.enterSearchValue("title");
//        Thread.sleep(2000);
//        projectPage.listCheck(2, "title");
//    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }


//    public void setDriver(WebDriver driver) {
//        this.driver = driver;
//    }
}
