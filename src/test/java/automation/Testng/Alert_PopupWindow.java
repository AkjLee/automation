package automation.Testng;

import automation.Initialization.SetupBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;

import java.util.Set;

public class Alert_PopupWindow extends SetupBrowser {
    // Alert
    @Test (priority = 1)
    public void alert () throws InterruptedException{

        SoftAssert softassert = new SoftAssert();
        Actions action = new Actions(driver);


        driver.get("https://demo.guru99.com/test/delete_customer.php");
        Thread.sleep(1000);

        WebElement btnProm =driver.findElement(By.xpath("//input[@name='cusid']"));
        action.sendKeys(btnProm,"123").build().perform();
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.switchTo().alert().accept();
        Thread.sleep(500);
    }
    // Alert 2
    @Test (priority = 2)
    public void alert2() throws InterruptedException {
        SoftAssert softassert = new SoftAssert();
        Actions action = new Actions(driver);

        driver.get("http://demo.automationtesting.in/Alerts.html");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']")).click();
        //button[normalize-space()='click the button to demonstrate the prompt box']
        //Nhấn sendKeys vào ô text
        driver.switchTo().alert().sendKeys("Anh Tester");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        WebElement demo = driver.findElement(By.id("demo1"));
        System.out.println(demo.getText());
        softassert.assertEquals(demo.getText().equals("Anh Tester"),"Không phải txt này!!!");
        Thread.sleep(2000);
    }
    // Popup Window
    @Test(priority = 3)
    public void popupWindow () throws InterruptedException, AWTException {
        Robot robot = new Robot();
        Actions action = new Actions(driver);

        driver.get("https://demo.automationtesting.in/Windows.html");
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[normalize-space()='Open Seperate Multiple Windows']")).click();
        Thread.sleep(500);
        //Click ra 2 trang vkl
        WebElement btn123 = driver.findElement(By.xpath("//body/div[1]/div[1]/div[1]/div[1]/div[2]/div[3]/button[1]"));
        action.click(btn123).build().perform();
        Thread.sleep(500);

        //Lưu trang tabl cũ
        String MainWindow = driver.getWindowHandle();
        System.out.println(MainWindow);

        // Tạo trang tabl mới
        Set<String> windows = driver.getWindowHandles();

        for (String window : windows) {
            System.out.println(window);
            if (!MainWindow.equals(window)) {
                //So sánh nếu thằng nào khác thằng Chính (đầu tiên) thì chuyển hướng qua nó mới thao tác được
                //Switch to Child window
                driver.switchTo().window(window);
                Thread.sleep(2000);
                System.out.println("Đã chuyển đến lớp Window con");

                //Một số hàm hỗ trợ
                System.out.println(driver.switchTo().window(window).getTitle());
                System.out.println(driver.switchTo().window(window).getCurrentUrl());
                if(driver.switchTo().window(window).getTitle().contains("Index")){
                driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gmail.com");
                driver.findElement(By.xpath("//img[@id='enterimg']")).click();
                Thread.sleep(1000);
                //Get text trang sau khi Submit
                System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'Register')]")).getText());
                Thread.sleep(1000);
                }
                else {
                // Closing the Child Window.
                Thread.sleep(1000);
                driver.close();}
            }
        }
        // Switching to Parent window (Main Window)
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        Thread.sleep(2000);

    }
    // Popup Window 2
    @Test (priority = 4)
    public void TestPopup02() throws InterruptedException {
        driver.get("http://demo.guru99.com/popup.php");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();

        // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
        String MainWindow = driver.getWindowHandle();
        System.out.println(MainWindow);

        // Get all new opened tab Window.
        Set<String> windows = driver.getWindowHandles();

        //Set là một Collection để lưu các phần tử giá trị KHÔNG trùng lặp.
        //Cách duyệt từng phần tử không trùng lặp trong Collection (Set) - Java Basic
        for (String window : windows) {
            System.out.println(window);
            if (!MainWindow.equals(window)) {
                //So sánh nếu thằng nào khác thằng Chính (đầu tiên) thì chuyển hướng qua nó mới thao tác được
                //Switch to Child window
                driver.switchTo().window(window);
                Thread.sleep(2000);
                System.out.println("Đã chuyển đến lớp Window con");

                //Một số hàm hỗ trợ
                System.out.println(driver.switchTo().window(window).getTitle());
                System.out.println(driver.switchTo().window(window).getCurrentUrl());
                Thread.sleep(1000);
                driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
                driver.findElement(By.name("btnLogin")).click();
                Thread.sleep(1000);
                //Get text trang sau khi Submit
                System.out.println(driver.findElement(By.xpath("//table//td//h2")).getText());
                // Closing the Child Window.
                Thread.sleep(2000);
                driver.close();
            }
        }
        // Switching to Parent window (Main Window)
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        Thread.sleep(2000);
    }

    //Upload file
    @Test(priority = 5)
    public void testUploadfile() throws InterruptedException {

        driver.get("https://demo.automationtesting.in/Register.html");

        WebElement btn = driver.findElement(By.xpath("//input[@id='imagesrc']"));
        btn.sendKeys("C:\\Users\\Admin\\Pictures\\Visafe\\cms-cauhinh-form.png");


        Thread.sleep(2000);
    }


}
