package automation.Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static automation.Initialization.Init.*;


public class Checkbox {
    public static void main (String [] args) throws Exception{
        Setup();
        //Khởi tạo trang web muốn kiểm tra
//        driver.get("");
        driver.navigate().to("https://ej2.syncfusion.com/demos/multi-select/checkbox/");

        //Dùng findElements để lấy tổng số lượng thẻ div trong class
        //Vì class giống nhau nên dùng findElements
        var listCheckbox =driver.findElements(By.xpath("//table[@id='property']//div[@class='e-checkbox-wrapper e-wrapper']"));
        System.out.println(listCheckbox.size());
        //Dùng hàm for để chạy từ 1 đến hết số lượng trong listcheck
        for (int i = 1; i <= listCheckbox.size(); i ++){
            //Tìm đến element thứ i cụ thể trong listcheck
            WebElement checkbox = driver.findElement(By.xpath("//tbody/tr["+ i +"]/td[1]/div[1]/div[1]/label[1]/span[2]"));
                    if (checkbox.isSelected() == true){
                        System.out.println("Check box thứ "+i+" chưa được chọn !!!");
                    }
                    else {
                        System.out.println("Check box th "+i+" đã được chọn!!!");
                    }
        }
        Thread.sleep(2000);
        //Kiểm tra từng nút check box
        WebElement btnIcon = driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/label[1]/span[2]"));
        if(btnIcon.isDisplayed() == true){
            System.out.println("Đã chọn nút btn");
            Thread.sleep(1000);
            System.out.println(btnIcon.getText());
        }
        else {
            driver.findElement(By.xpath("//tbody/tr[1]/td[1]/div[1]/div[1]/label[1]/span[2]")).click();
            Thread.sleep(1000);
        }


        Close();
    }
}
