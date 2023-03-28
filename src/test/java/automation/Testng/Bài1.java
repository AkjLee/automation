package automation.Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static automation.Initialization.Init.*;

public class Bài1 {
    public static void main(String[] args) throws Exception {

        Setup();

        driver.navigate().to("https://anhtester.com");

        By BtnLogin = By.xpath("//a[@id='btn-login']");
        driver.findElement(BtnLogin).click();
        Thread.sleep(1000);

        By InputLogin = By.xpath("//input[@placeholder='Email']");
        driver.findElement(InputLogin).sendKeys("trilee2912@gmail.com");
        Thread.sleep(1000);

        By InputPassword = By.xpath("//input[@placeholder='Password']");
        driver.findElement(InputPassword).sendKeys("lenguyentri2820");
        Thread.sleep(2000);

        //Vào khung iframe/frame
        WebElement element = driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']"));
        driver.switchTo().frame(element);
        Thread.sleep(1000);
        //Nhập nôi dung
        By Content = By.xpath("//iframe[@title='reCAPTCHA']");
        driver.findElement(Content).click();
        Thread.sleep(1000);
        //Thoát khỏi khung iframe/frame
        driver.switchTo().defaultContent();

        By BtnLoginAccount = By.xpath("//button[@id='login']");
        driver.findElement(BtnLoginAccount).click();
        Thread.sleep(1000);

        By BtnPoss = By.xpath("//li[@class='sidenav__item']//a[contains(text(),'Posts')]");
        driver.findElement(BtnPoss).click();
        Thread.sleep(1000);

        By BtnDangbai = By.xpath("//a[@id='btn-dangbai']");
        driver.findElement(BtnDangbai).click();
        Thread.sleep(1000);

        By InputTieuDe = By.xpath("//input[@id='_name_for_slug']");
        driver.findElement(InputTieuDe).sendKeys("Tiêu đề 1");
        Thread.sleep(1000);

        By InputSlug = By.xpath("//input[@id='_slug']");
        driver.findElement(InputSlug).sendKeys("Slug01");
        Thread.sleep(1000);

        By InputThumb = By.xpath("//input[@id='inp_thumb']");
        driver.findElement(InputThumb).sendKeys("data:image/png;base64,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");
        Thread.sleep(1000);

        //Vào khung iframe/frame
        WebElement element1 = driver.findElement(By.id("mceu_30"));
        driver.switchTo().frame(element1);
        Thread.sleep(1000);
        //Nhập nôi dung
        By Content1 = By.xpath("//body");
        driver.findElement(Content1).sendKeys("Mô tả này rất dài!!!");
        Thread.sleep(1000);
        //Thoát khỏi khung iframe/frame
        driver.switchTo().defaultContent();

        for (int i = 0; i < 2; i ++) {
            By InputTagsinput = By.xpath("//div[@class='bootstrap-tagsinput']//input[@placeholder='Nhấn enter để chọn nhiều']");
            driver.findElement(InputTagsinput).sendKeys("Tag0"+i+"");
            Actions action = new Actions(driver);
            action.sendKeys(Keys.ENTER).build().perform();
            Thread.sleep(1000);
        }
        Thread.sleep(1000);

        By InputMetatitle = By.xpath("//input[@id='meta_title']");
        driver.findElement(InputMetatitle).sendKeys("Metatitle 01");
        Thread.sleep(1000);

        By InputArea = By.xpath("//textarea[@id='meta_des']");
        driver.findElement(InputArea).sendKeys("Area 001");
        Thread.sleep(1000);

        //Vào khung iframe/frame
        WebElement element2 = driver.findElement(By.id("tinymce"));
        driver.switchTo().frame(element2);
        Thread.sleep(1000);
        //Nhập nôi dung
        By Content2 = By.xpath("//body");
        driver.findElement(Content2).sendKeys("Nội dung này cũng rất dài!!!");
        Thread.sleep(1000);
        //Thoát khỏi khung iframe/frame
        driver.switchTo().defaultContent();
        Thread.sleep(1000);

        By BtnContains = By.xpath("//button[contains(text(),'Tạo bài viết')]");
        driver.findElement(BtnContains).click();


        Thread.sleep(1000);
        Close();
    }
}
