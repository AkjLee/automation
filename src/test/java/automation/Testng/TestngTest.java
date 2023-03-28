package automation.Testng;

import automation.Initialization.RecordVideo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class TestngTest {
     WebDriver driver;

    @BeforeClass
    public void setupClass() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Gọi lại hàm startRecord
        RecordVideo.startRecord("ManageDocument");
    }
//    @Test
//    public void test01() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MINUTES);
//
//        driver.get("http://3.0.18.73/");
//
//        Thread.sleep(2000);
//
//        driver.quit();
//    }
    @Test
    public void main() throws InterruptedException {

        driver.get("http://3.0.18.73/");

        By Account = By.xpath("//input[@placeholder='Tài khoản']");
        driver.findElement(Account).sendKeys("Admin");

        //Chọn và nhập mật khẩu
        By Password = By.xpath("//input[@placeholder='Mật khẩu']");
        driver.findElement(Password).sendKeys("hs@12345");

        //Kiểm tra nút đăng nhập có hiển thị không
        WebElement element2 = driver.findElement(By.xpath("//input[@placeholder='Mật khẩu']"));
        if (element2.isEnabled() == true){
            System.out.println(" Đúng ");
        }
        else {
            System.out.println(" Sai ");
        }

        //Click btn đăng nhập
        By BtnLoginAccount = By.xpath("//button[contains(text(),'Đăng nhập')]");
        driver.findElement(BtnLoginAccount).click();
        Thread.sleep(1000);

        //Check xem có phải đang ở trang chủ cms không
        WebElement element = driver.findElement(By.xpath("//h1[contains(text(),'Trang chủ')]"));
        if (element.isDisplayed() == true){
            System.out.println("Đã vào trang chủ thành công!!!");
            System.out.println(element.getText());
        }

        //Vào trang mã giảm giá
        By BtnMGG = By.xpath("//li[15]//a[1]");
        driver.findElement(BtnMGG).click();

        //check đã vào trang mã giảm giá chưa
        WebElement element1 = driver.findElement(By.xpath("//h1[contains(text(),'Mã giảm giá')]"));
        if (element1.isDisplayed() == true){
            System.out.println("Đã vào trang mã giảm giá");
            System.out.println(element1.getText());
        }

        //Chọn nút thêm mới
        By BtnAdd = By.xpath("//a[@title='Thêm mới']");
        driver.findElement(BtnAdd).click();

        By InputName = By.xpath("//input[@name='name']");
        driver.findElement(InputName).sendKeys("Name1");

        By InputCodename = By.xpath("//input[@name='code']");
        driver.findElement(InputCodename).sendKeys("Code123");

        By InputDescription = By.xpath("//textarea[@name='description']");
        driver.findElement(InputDescription).sendKeys("Test01");

        By SelectApplyTarget = By.xpath("//select[@name='applyTarget']");
        driver.findElement(SelectApplyTarget).click();

        By BtnText1 = By.xpath("//option[contains(text(),'Tất cả')]");
        driver.findElement(BtnText1).click();

        By SelectType = By.xpath("//select[@name='type']");
        driver.findElement(SelectType).click();

        By BtnText2 = By.xpath("//option[contains(text(),'miên phí')]");
        driver.findElement(BtnText2).click();

        By SelectCondition = By.xpath("//select[@name='condition']");
        driver.findElement(SelectCondition).click();

        By BtnText3 = By.xpath("//option[contains(text(),'không áp dụng điều kiện giảm')]");
        driver.findElement(BtnText3).click();

        By InputTotal = By.xpath("//input[@name='total']");
        driver.findElement(InputTotal).sendKeys("Total01");

        By InputPrice = By.xpath("//input[@name='price']");
        driver.findElement(InputPrice).sendKeys("1000");

        By SelectStatus = By.xpath("//select[@name='status']");
        driver.findElement(SelectStatus).click();

        By BtnText4 = By.xpath("//option[contains(text(),'không hoạt động')]");
        driver.findElement(BtnText4).click();

        By SelectNumberMax = By.xpath("//body/div[@id='app']/div[1]/div[1]/section[2]/div[1]/div[2]/form[1]/div[10]/div[1]/select[1]");
        driver.findElement(SelectNumberMax).click();

        By BtnText5 = By.xpath("//option[contains(text(),'có hạn')]");
        driver.findElement(BtnText5).click();

        By InputExpiredDate = By.xpath("//input[@name='expiredDate']");
        driver.findElement(InputExpiredDate).sendKeys("0208002000153011");

        By InputBeginDate = By.xpath("//input[@name='beginDate']");
        driver.findElement(InputBeginDate).sendKeys("0208002001153011" );

        By InputPercent = By.xpath("//input[@name='percent']");
        driver.findElement(InputPercent).sendKeys("10");

        By SelectKm = By.xpath("//body[1]/div[2]/div[1]/div[1]/section[2]/div[1]/div[2]/form[1]/div[14]/div[1]/select[1]");
        driver.findElement(SelectKm).click();

        By BtnText6 = By.xpath("//option[@value='-1']");
        driver.findElement(BtnText6).click();

        By InputNumJourney = By.xpath("//input[@name='numJourney']");
        driver.findElement(InputNumJourney).sendKeys("1");

        By SelectApplicableCity = By.xpath("//select[@name='applicableCity']");
        driver.findElement(SelectApplicableCity).click();

        By BtnText7 = By.xpath("//option[@value='Thừa Thiên Huế']");
        driver.findElement(BtnText7).click();

        By BtnContains = By.xpath("//button[contains(text(),'Lưu')]");
        driver.findElement(BtnContains).click();

        Thread.sleep(2000);

    }

    @AfterTest
    public void tearDownTestCase() throws Exception {
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDownClass() throws Exception {
        // Gọi lại hàm startRecord
        RecordVideo.stopRecord();
        driver.quit();
    }
}
