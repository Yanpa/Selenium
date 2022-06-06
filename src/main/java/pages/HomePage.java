package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private final String HOME_PAGE_URL = "https://demo.vamshop.com/";
    WebDriver webDriver;

    By adminAreaLocator = new By.ByClassName("page");
    By loginButtonLocator = new By.ByTagName("a");

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void locateAndClickTheLoginButton(){
        WebElement adminArea = webDriver.findElement(adminAreaLocator);
        WebElement loginButton = adminArea.findElement(loginButtonLocator);
        
        loginButton.click();
    }

    private void inItPage(){
        this.webDriver.get(HOME_PAGE_URL);
    }

    public LogInPage getLoginPage(){
        inItPage();
        locateAndClickTheLoginButton();
        return new LogInPage(webDriver);
    }
}
