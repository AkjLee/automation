package automation.Testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        WebDriver driver;

        WebDriverManager.chromedriver().setup();// Gọi phiên bản brower

        driver = new ChromeDriver(); // Khởi tạo giá trị cho brower

        driver.get("http://3.0.18.73/");

        driver.quit();
    }
}
