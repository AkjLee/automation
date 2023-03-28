package automation.Testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class AutoPhanTrang {
    WebDriver driver;

    //Phân trang và check
    @Test
    public void checkDataTableWithPagination() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://datatables.net/");

        By title_H1 = By.xpath("//div[@class='fw-hero']//h1");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(title_H1));

        Thread.sleep(1000);

        By button_Next = By.xpath("//a[@id='example_next']");
        By label_Info_PageTotal = By.xpath("//div[@id='example_info']");
        String info = driver.findElement(label_Info_PageTotal).getText(); //Showing 1 to 10 of 57 entries

        System.out.println("Chuỗi chứa số item: " + info);

        //Mình tách cái chuỗi trên với ký tự khoảng trắng rồi lấy phần tử thứ 5 tính từ 0
        //Để bắt tổng số Item
        ArrayList< String > arrayListString = new ArrayList < > ();
        for (String s: info.split(" ")) {
            arrayListString.add(s);
        }

        int itemTotal = Integer.parseInt(arrayListString.get(5));
        System.out.println("Tổng số item: " + itemTotal);

        int itemTotalOnePage = 10; //mặc định như mẫu. Tuỳ vào hệ thống mình thay đổi theo
        System.out.println("Số item trên 1 trang: " + itemTotalOnePage);

        double pageTotal = (double) itemTotal / (double) itemTotalOnePage;

        DecimalFormat df = new DecimalFormat("#"); //Làm tròn số đến phần đơn vị của phần thập phân
        //Ví dụ 5.7 thì làm tròn 6 kiểu vậy
        int pageTotalInt = Integer.parseInt(df.format(pageTotal));
        System.out.println("Tổng số trang: " + df.format(pageTotalInt));

        //FOR này chạy tới < pageTotalInt để nó không click thêm lần cuối cùng
        //VD: 6 trang thì nó chỉ click 5 lần thôi chứ hả =))
        for (int i = 1; i < pageTotalInt; i++) {
            //Gọi hàm Check data bên trên lại
            checkContainsSearchTableByColumn(1, "");
            Thread.sleep(1000);
            //Click Next
            driver.findElement(button_Next).click();
        }

        Thread.sleep(2000);


    }

    private void checkContainsSearchTableByColumn(int i, String s) {
    }
}
