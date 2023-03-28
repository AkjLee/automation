package automation.Testng;

import automation.Initialization.SetupBrowser;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class spamer extends SetupBrowser {

    @Test
    public void spamPig () throws InterruptedException {

        Actions actions = new Actions(driver);
        driver.get("https://www.skype.com/en/");

        WebElement clickbtn1 = driver.findElement(By.xpath("//a[@class='btn secondaryCta small usernameBtn notAuthenticated']"));
        actions.click(clickbtn1).build().perform();
        Thread.sleep(500);

        WebElement clickbtn2 = driver.findElement(By.xpath("//a[normalize-space()='Use Skype online']"));
        actions.click(clickbtn2).build().perform();
        Thread.sleep(1000);

        WebElement clickbtn3 = driver.findElement(By.xpath("//input[@id='i0116']"));
        actions.sendKeys(clickbtn3, "trilee2820@gmail.com").build().perform();
        Thread.sleep(500);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(1000);

        WebElement clickbtn4 = driver.findElement(By.id("i0118"));
        actions.sendKeys(clickbtn4 ,"lenguyentri2820").build().perform();
        Thread.sleep(500);
        actions.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(500);

        WebElement clickbtn5 = driver.findElement(By.xpath("//input[@id='idSIButton9']"));
        actions.click(clickbtn5).build().perform();
        Thread.sleep(500);

        WebElement clickbtn6 = driver.findElement(By.xpath("//div[@data-text-as-pseudo-element='Con Lợn Hay Nghịp']"));
        actions.click(clickbtn6).build().perform();
        Thread.sleep(2000);
        for(int i = 1; i < 10; i++) {
            WebElement clickbtn7 = driver.findElement(By.xpath("//div[@class='public-DraftStyleDefault-block public-DraftStyleDefault-ltr']"));
            actions.sendKeys(clickbtn7, "Đây là tin nhắn spam con lợn" + " " + i + " ").build().perform();
            actions.sendKeys(Keys.ENTER).build().perform();
            Thread.sleep(200);
        }
    }
}
