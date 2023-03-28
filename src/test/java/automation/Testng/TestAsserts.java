package automation.Testng;

import automation.Initialization.InitRecordVideo;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestAsserts extends InitRecordVideo {

    @Test
    public void RunTestAsserts () throws Exception {

        int a = 0;
        //Khởi tạo softassert
        SoftAssert softassert = new SoftAssert();

        //Khai báo đối tượng softassert
        driver.get("https://student.husc.edu.vn");
        Thread.sleep(500);

        //Login account
        driver.findElement(By.xpath("//input[@id='loginID']")).sendKeys("18T1021332");

        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("lenguyentri");

        driver.findElement(By.xpath("//button[contains(text(),'Đăng nhập')]")).click();
        Thread.sleep(500);
        // Open Page Home
        WebElement header = driver.findElement(By.xpath("//h2[normalize-space()='THÔNG BÁO']"));
        softassert.assertEquals(header.getText(),"THÔNG BÁO");
        System.out.println(header.getText());

        //Chọn Menu Message/Create
        driver.findElement(By.xpath("//a[@id='linkMessage']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@href='/Message/Create']")).click();
        Thread.sleep(500);

//        //Soạn thư
//        driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']")).sendKeys("Nguyễn Kim Ngàn");
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//li[@role='treeitem']")).sendKeys(Keys.ENTER);
//        Thread.sleep(500);
//        driver.findElement(By.xpath("//input[@id='title']")).sendKeys("Test AutoMation");
//        Thread.sleep(500);
//        //Vào iframe
//        WebElement element = driver.findElement(By.id("content_ifr"));
//        driver.switchTo().frame(element);
//        Thread.sleep(500);
//
//        //Nhập nội dung
//        By Content = By.xpath("//body");
//        driver.findElement(Content).sendKeys("Test"+a+"");
//
//        //Thoát iframe/frame
//        driver.switchTo().defaultContent();
//        Thread.sleep(500);
//        //Gửi tin nhắn
//        driver.findElement(By.xpath("//button[contains(text(),'Gửi tin nhắn')]")).click();
//        Thread.sleep(1000);

        // Vào trang tin nhắn đã gửi
        driver.findElement(By.xpath("//a[contains(text(),'Tin nhắn đã gửi')]")).click();

        //Tìm kiếm nội dung
        driver.findElement(By.xpath("//input[@id='__messageSearch']")).sendKeys("Test AutoMation");
        Thread.sleep(500);
        //ENTER
        driver.findElement(By.xpath("//input[@id='__messageSearch']")).sendKeys(Keys.ENTER);
        Thread.sleep(500);

        var listcheck = driver.findElements(By.xpath("//body/div[@id='wrapper']/div[3]/div[1]/div[1]//tbody/tr"));
        System.out.println(listcheck.size()); // kiểm tra có bao nhiêu phân tử trong 1 cột
        for (int i = 1; i <= listcheck.size(); i ++){
            //Tìm đến element thứ i cụ thể trong listcheck
            WebElement checkList = driver.findElement(By.xpath("//tbody/tr["+i+"]"));
           // System.out.println(" "+i+" ");
            //System.out.println(checkList.getText());

            var listcheck2 = driver.findElements(By.xpath("//body/div[@id='wrapper']/div[3]/div[1]/div[1]//tbody/tr"));
             System.out.println(listcheck2.size()); //Kiểm tra trong 1 hàng có bao nhiêu phần tử
            for (int j = 1; j <= listcheck2.size(); j ++){
                WebElement checkList2 = driver.findElement(By.xpath("//tbody/tr["+i+"]/td["+j+"]"));
                //System.out.println(" "+j+" ");
                //assertEquals(checkList2.getText().equals("Test AutoMation"));// kiểm tra trong mảng có test automation không
               softassert.assertEquals(checkList2.getText() ,"Test AutoMation");

                //System.out.println(checkList2.getText());
            }
        }
        Thread.sleep(1000);

        softassert.assertAll();


    }

}
