package automation.Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

import static automation.Initialization.Init.*;

public class CheckDroplist {
    public static void main(String[] args) throws Exception {

        Setup();
        //Chạy trang web
        driver.navigate().to("https://techydevs.com/demos/themes/html/trizen-demo/trizen/index.html");

        Thread.sleep(1000);
        //Tìm xpath dropdown
        WebElement element =driver.findElement(By.xpath("//div[@class='form-group select-contain w-auto']//select[@class='select-contain-select']"));
        //Khởi tạo select
        Select selectSimple = new Select(element);
        //Hiển thị 1 giá trị trong dropdow
        selectSimple.selectByVisibleText("First class");
        System.out.println("Chạy lấy được First class rồi nhà :))");
        Thread.sleep(1000);
        //Hiển thị 1 giá trị trong dropdown trong value
        selectSimple.selectByValue("2");
        System.out.println("Chạy ra Business");
        Thread.sleep(1000);
        //Hiển thị 1 giá trị ở vị trí thứ bao nhiêu từ 0 - dropdown
        selectSimple.selectByIndex(0);
        System.out.println("Chạy ra Economy");
        Thread.sleep(1000);
        //Hiển thị gi trị được chọn cuối cùng
        System.out.println(selectSimple.getFirstSelectedOption().getText());
        //So sánh gì trị trả về có đúng không
        if(selectSimple.getFirstSelectedOption().getText().equals("Economy"))  // Không sử dụng được ==
        {
            System.out.println("Đúng");
        } else {
            System.out.println("Sai");
        }
        //Đếm số lượng trong dropdown
        System.out.println(selectSimple.getOptions().size());

        //Kiểm tra xem dropdown có bằng 3 ko
        Assert.assertEquals(3, selectSimple.getOptions().size());


        Thread.sleep(500);
        //Khởi tạo list danh sách trong dropdown
        List<WebElement> getAllOptions =selectSimple.getOptions();

        for (int i = 0; i < getAllOptions.size(); i ++)
        {   //Hiển thị danh sách trong dropdown
            System.out.println(getAllOptions.get(i).getText());

        }

        if (selectSimple.isMultiple() == true)
        {
            System.out.println("Đây là dạng Multiple");
        }
        else {
            System.out.println("Không phải dạng Multiplee ");
        }





        Close();

    }
}
