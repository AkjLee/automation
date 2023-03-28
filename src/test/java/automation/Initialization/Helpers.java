package automation.Initialization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {

    WebDriver driver;

    public Helpers(WebDriver _driver){this.driver = _driver;}

    public void delay (int second){
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void  setText (By by, String value){
        // Thời gian chờ cho webdrivewait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //Chờ đời kiểm tra click
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        //Sendkeys
        driver.findElement(by).sendKeys(value);
    }


    public void clickElement(By by){
        // Thời gian chờ cho webdrivewait
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //Chờ đời kiểm tra click
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        //Click
        driver.findElement(by).click();
    }
}
