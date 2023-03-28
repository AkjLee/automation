package automation.Testng;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static automation.Initialization.Init.*;

public class Login_tosend {
    public  static  void  main (String[] args) throws Exception {
        System.out.println("Hello");
        Setup();
        driver.get("https://student.husc.edu.vn/Account/Login");

//        By Btnlogin = By.xpath("//a[@id='btn-login']");
//        driver.findElement(Btnlogin).click();
        //Chọn và nhập tài khoản
        By Account = By.xpath("//input[@id='loginID']");
        driver.findElement(Account).sendKeys("18T1021332");
        //Chọn và nhập mật khẩu
        By Password = By.xpath("//input[@id='password']");
        driver.findElement(Password).sendKeys("lenguyentri");
        //Click btn đăng nhập
        By BtnLoginAccount = By.xpath("//button[contains(text(),'Đăng nhập')]");
        driver.findElement(BtnLoginAccount).click();
        //Click btn tin nhắn
        By BtnMessage = By.xpath("//a[@id='linkMessage']");
        driver.findElement(BtnMessage).click();
        //Click btn soạn thư
        By BtnWrapper = By.xpath("//body/div[@id='wrapper']/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]");
        driver.findElement(BtnWrapper).click();
        //Nhập người gửi đến
        By txtDear = By.xpath("//body/div[@id='wrapper']/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/span[1]/span[1]/span[1]/ul[1]/li[1]/input[1]");
        driver.findElement(txtDear).sendKeys("Nguyễn Kim Ngàn");
        Thread.sleep(2000);
//        By clickBtn1 = By.xpath("//li[@role='treeitem']");
//        driver.findElement(clickBtn1).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();

        Thread.sleep(1000);
        //Nhập tiêu đề gửi
        By txtTitle = By.xpath("//input[@id='title']");
        driver.findElement(txtTitle).sendKeys("Test AutoMation");
//        By clickContent = By.xpath("//body/div[@id='wrapper']/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[6]/div[1]");
        //Vào khung iframe/frame
        WebElement element = driver.findElement(By.id("content_ifr"));
        driver.switchTo().frame(element);
        Thread.sleep(1000);
        //Nhập nôi dung
        By Content = By.xpath("//body");
        driver.findElement(Content).sendKeys("Test11");
        //Thoát khỏi khung iframe/frame
        driver.switchTo().defaultContent();
        Thread.sleep(2000);
        //Click btn gửi tin nhắn
        By btnGet = By.xpath("//button[contains(text(),'Gửi tin nhắn')]");
        driver.findElement(btnGet).click();

        Thread.sleep(2000);
        Close();

    }
}
