package automation.Testng;

import automation.Initialization.SetupBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestAsserts2 extends SetupBrowser {
    @Test
    public void main() throws InterruptedException {

        driver.get("https://demo.activeitzone.com/ecommerce/login");

         By emailTxt = By.id("email");
         driver.findElement(emailTxt).sendKeys("admin@example.com");
         By passwordTxt = By.id("password");
         driver.findElement(passwordTxt).sendKeys("123456");
         By loginBtn = By.xpath("//button[normalize-space()='Login']");
         driver.findElement(loginBtn).click();
        Thread.sleep(1000);
         By salerBtn =By.xpath("//span[normalize-space()='Sales']");
         driver.findElement(salerBtn).click();
        Thread.sleep(1000);
         By allorderBtn =By.xpath("//span[normalize-space()='All Orders']");
         driver.findElement(allorderBtn).click();
         By searchTxt = By.xpath("//input[@id='search']");
        driver.findElement(searchTxt).sendKeys("123", Keys.ENTER);
        Thread.sleep(1000);

        var listcheck = driver.findElements(By.xpath("//body//div[@class='card-body']//tbody/tr"));
        System.out.println(listcheck.size()); // kiểm tra có bao nhiêu phân tử trong 1 cột
        for (int i = 1; i <= listcheck.size(); i ++){
            //Tìm đến element thứ i cụ thể trong listcheck
            WebElement checkList = driver.findElement(By.xpath("//tbody/tr["+i+"]"));
            System.out.println(" "+i+" ");
            System.out.println(checkList.getText());

            var listcheck2 = driver.findElements(By.xpath("//body//div[@class='card-body']//tbody/tr"));
            // System.out.println(listcheck2.size()); //Kiểm tra trong 1 hàng có bao nhiêu phần tử
            for (int j = 1; j <= listcheck2.size(); j ++){
                WebElement checkList2 = driver.findElement(By.xpath("//tbody/tr["+i+"]/td["+j+"]"));
                //System.out.println(" "+j+" ");
                //assertEquals(checkList2.getText().equals("Test AutoMation"));// kiểm tra trong mảng có test automation không
                //softassert.assertEquals(checkList2.getText() ,"Test AutoMation");

                //System.out.println(checkList2.getText());
            }
        }
        Thread.sleep(1000);

    }
}
