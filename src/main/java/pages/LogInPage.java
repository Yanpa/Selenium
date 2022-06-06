package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
    WebDriver webDriver;

    private final By usernameLocator = new By.ById("UserUsername");
    private final By passwordLocator = new By.ById("UserPassword");
    private final By logKeyLocator = new By.ByClassName("cus-key");

    public LogInPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public DashboardPage logIn(String username, String password){
        setUsername(username);
        setPassword(password);
        clickLogInKey();

        return new DashboardPage(webDriver);
    }

    private void setUsername(String usernamePopulate){
        WebElement username = webDriver.findElement(usernameLocator);
        username.sendKeys(usernamePopulate);
    }

    private void setPassword(String passwordPopulate){
        WebElement password = webDriver.findElement(passwordLocator);
        password.sendKeys(passwordPopulate);
    }

    private void clickLogInKey(){
        WebElement logInKey = webDriver.findElement(logKeyLocator);
        logInKey.click();
    }
}
