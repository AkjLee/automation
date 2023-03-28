package automation.PageOjectModel.pages;

import common.helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class ProjectPage {

    private WebDriver driver;
    private Helpers helpers;
    private By projectBtn = By.xpath("//a[contains(@href,'https://rise.fairsketch.com/projects/all_projects')]");
    private By addnewprojectBtn = By.xpath("//a[normalize-space()='Add project']");
    private By titleTxt = By.xpath("//input[@id='title']");
    private By descTxt = By.xpath("//textarea[@id='description']");
    private By startdateTxt = By.xpath("//input[@id='start_date']");
    private By deadlineTxt = By.xpath("//input[@id='deadline']");
    private By priceTxt = By.xpath("//input[@id='price']");
    //private By labelTxt = By.xpath("(//div[@id='s2id_project_labels'])");
    //private By labelTxt1 = By.xpath("//body[1]/div[11]/ul[1]/li[2]");
    private By saveBtn = By.xpath("//button[normalize-space()='Save']");
    //Check list projects
    private  By searchTxt = By.xpath("//input[@placeholder='Search']");
    private  By listxpath = By.xpath("//body//tbody/tr");
    //private  By listxpath1 = By.xpath("//body//tbody/tr["+i+"]");
    //private  By listxpath2 = By.xpath("//body//tbody/tr["+i+"]/td["+j+"]");




    public ProjectPage(WebDriver driver){

        this.driver =  driver;
        helpers = new Helpers(driver);

    }
    public void addnewproject(){

        helpers.waitForPageLoaded();
        helpers.clickElement(projectBtn);
        helpers.clickElement(addnewprojectBtn);
        helpers.delay(1);
        helpers.setText(titleTxt, "Title Test Name Test 1");
        helpers.setText(descTxt, "Test description name 1");
        helpers.setText(startdateTxt, "02-08-2022");
        helpers.setText(deadlineTxt, "20-12-2022");
        helpers.setText(priceTxt ,"1230");
        //helpers.clickElement(labelTxt);
        helpers.clickElement(saveBtn);
        helpers.delay(3);
    }

    public void enterSearchValue(String value) throws InterruptedException {
        helpers.clickElement(projectBtn);
        Thread.sleep(2000);
        helpers.setTextEnter(searchTxt, "title");
    }

    public void listCheck(int column, String value) {
        List<WebElement> row = driver.findElements(By.xpath("//table//tbody/tr"));
        int rowTotal = row.size(); //Lấy ra số dòng
        System.out.println("Tìm thấy số dòng là " + rowTotal); // kiểm tra có bao nhiêu phân tử trong 1 cột
        for (int i = 1; i <= rowTotal; i++) {
            //Tìm đến element thứ i cụ thể trong listcheck
            WebElement elementCheck = driver.findElement(By.xpath("//body//tbody//tr["+i+"]//td["+column+"]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", elementCheck);
            System.out.print(value + " - ");
            System.out.println(elementCheck.getText());
            Assert.assertTrue(elementCheck.getText().toUpperCase().contains(value.toUpperCase()), "Dòng số " + i + " không chứa giá trị tìm kiếm.");
        }
    }
}
