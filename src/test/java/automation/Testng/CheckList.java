package automation.Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static automation.Initialization.Init.*;

public class CheckList {
    public static void main(String [] args) throws Exception{
        Setup();

        driver.navigate().to("https://demoqa.com/radio-button");
        Thread.sleep(1000);

//        By clickBnt = By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[3]");
//        driver.findElement(clickBnt).click();
//        Thread.sleep(1000);
        //Kiểm tra nut đã được chọn hay chưa
        WebElement btnIcon = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[3]"));
        if(btnIcon.isSelected() == true){
            System.out.println("Đã chọn nút btn");
            Thread.sleep(1000);
            System.out.println(btnIcon.getText());
        }
        else { // nếu nut chưa bật thì bật nút lên
            System.out.println("Chưa chọn nút btn");
            btnIcon.click();
            System.out.println("Đã được chọn");
        }
        //isSelected: xem phần tử có được chọn hay ko
        //isEnabled: xem phần tử web này có đang bật hay ko
        //isDisplayed: xem phần tử có hiện trong 1 trang hay ko

        //Kiểm tra nút "NO" có được chọn hay không
        WebElement btnNo = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[4]"));
        if (btnNo.isSelected() == true){
            System.out.println("Được chọn !!!!!");
        }
        else {
            System.out.println("Không được chọn !!!!!");

        }

        var listcheck = driver.findElements(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]//input[@type='radio']"));
        System.out.println(listcheck.size());
        for (int i = 1; i <= listcheck.size(); i ++){
            //Tìm đến element thứ i cụ thể trong listcheck
            WebElement checkbox = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div["+i+"]"));

            if (checkbox.isSelected() == true){
                System.out.println("Check box thứ "+i+" đã được chọn !!!");
            }
            else {
                System.out.println("Check box th "+i+" chưa được chọn !!!");

            }
        }
        Thread.sleep(2000);


        Close();

    }
}
