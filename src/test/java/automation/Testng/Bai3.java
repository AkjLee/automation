package automation.Testng;

import automation.Initialization.SetupBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class Bai3 extends SetupBrowser {

    @Test
    public void Actions () throws InterruptedException {

        Actions action = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //js.executeScript(java.lang.String script, java.lang.Object... args)

        driver.get("https://google.com");

        WebElement btnSearch = driver.findElement(By.xpath("//input[@title='Tìm kiếm']"));
        action.sendKeys(btnSearch, "anh tester").build().perform();
        Thread.sleep(500);

        action.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(500);

        WebElement btnClick = driver.findElement(By.xpath("//h3[normalize-space()='Anh Tester - Automation Testing']"));
        action.click(btnClick).build().perform();
        Thread.sleep(500);

        WebElement btnClick2 = driver.findElement(By.xpath("//a[contains(text(),'Tất Cả Khóa Học')]"));
        //action.moveToElement(btnClick2).build().perform();
        js.executeScript("arguments[0].scrollIntoView(true);",btnClick2);
        Thread.sleep(2000);
        action.click(btnClick2).build().perform();

        WebElement btnSearch2 = driver.findElement(By.xpath("//input[@placeholder='Search courses']"));
        action.sendKeys(btnSearch2, "Selenium Java").build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(500);

        WebElement btn = driver.findElement(By.xpath("//input[@placeholder='Tìm kiếm khóa học . . .']"));
        btn.clear();

        WebElement text = driver.findElement(By.xpath("//span[normalize-space()='1']"));
        action.doubleClick(text).build().perform();
        Thread.sleep(500);
        // crtl + a để bôi
//        action.keyDown( Keys.CONTROL ).sendKeys( "a" ).keyUp( Keys.CONTROL ).build().perform();
//        Thread.sleep(1000);
        //Ctrl + c để copy
        action.keyDown( Keys.CONTROL ).sendKeys( "c" ).keyUp( Keys.CONTROL ).build().perform();
        Thread.sleep(500);

        action.click(btn).build().perform();

        action.keyDown( Keys.CONTROL ).sendKeys( "v" ).keyUp( Keys.CONTROL ).build().perform();
        Thread.sleep(500);
        action.sendKeys(Keys.ENTER).build().perform();

        Thread.sleep(2000);

    }
}
