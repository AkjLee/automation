package automation.Initialization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class InitRecordVideo {

    public WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        // Gọi lại hàm startRecord
        RecordVideo.startRecord("ManageDocument");
    }

    @AfterClass
    public void tearDown() throws Exception {
        // Gọi lại hàm startRecord
        RecordVideo.stopRecord();
        driver.quit();
    }
}
