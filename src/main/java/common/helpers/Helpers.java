package common.helpers;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class Helpers {

    private WebDriver driver;
    private final int timeoutWaitForPageLoad = 20;
    private WebDriverWait wait;


    public Helpers(WebDriver _driver){
        driver = _driver;
    }

    public void delay (int second){
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Ham setText
    public void  setText (By by, String value){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        //Sendkeys
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(value);
    }

    // Ham click
    public void clickElement(By by){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        //Click
        driver.findElement(by).click();
    }

    public void setTextEnter(By by, String text){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));

        driver.findElement(by).sendKeys(text, Keys.ENTER) ;
    }

    // Ham verifyURL
    public boolean  verifyURL (String url){

        System.out.println(driver.getCurrentUrl());
        System.out.println(url);

        return driver.getCurrentUrl().contains(url);//true/false
    }

    //Ham verifyEmlementText
    public boolean verifyEmlementText (By by,String textValue){

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        System.out.println(textValue);

        return driver.findElement(by).getText().equals(textValue);
    }

    // Ham kiểm tra element có tồn tại hay không
    public boolean verifyEmlementExit (By by){

        List<WebElement> listElement =driver.findElements(by);
         int total = listElement.size();
         if (total > 0){
             return true;
         }
         return false;
    }

    // Hàm chờ
    public void waitForPageLoaded(){

        //Wait for jquery to load
        ExpectedCondition<Boolean>jQueryLoad = new ExpectedCondition<Boolean>(){
          @Override
          public Boolean apply(WebDriver driver){
              try {
                  return ((long) ((JavascriptExecutor) driver).executeScript("return jQuery.active")==0);
              } catch (Exception e){
                  return true;
              }
          }
        };

        //Wait for Javascript to load
        ExpectedCondition<Boolean>jsLoad = new ExpectedCondition<Boolean>(){
            @Override
            public Boolean apply(WebDriver driver){
                    return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                            .toString().equals("complete");
            }
        };

        try {
            wait = new WebDriverWait(driver, timeoutWaitForPageLoad);
            wait.until(jQueryLoad);
            wait.until(jsLoad);
        }catch (Throwable error){
            Assert.fail("Quá thời gian load trang");
        }

    }



    // Ham check listcheck

}
