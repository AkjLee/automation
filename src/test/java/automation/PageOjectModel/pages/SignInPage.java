package automation.PageOjectModel.pages;

import common.helpers.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {

    private WebDriver driver;
    Helpers helpers;

    private By emailTxt = By.id("email");
    private By passwordTxt = By.id("password");
    private By loginBtn = By.xpath("//button[normalize-space()='Sign in']");

    public SignInPage(WebDriver driver){

        this.driver = driver;
        helpers = new Helpers(driver);

    }
    public DashboardPage singInPage (String email, String password){
        helpers.waitForPageLoaded();
        helpers.setText(emailTxt,email);
        helpers.setText(passwordTxt, password);
        helpers.clickElement(loginBtn);
        return new DashboardPage(driver);
    }



}
