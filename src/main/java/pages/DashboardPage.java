package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPage {
    WebDriver webDriver;
    By categoriesAndProducts = new By.ByClassName("btn-default");

    public DashboardPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public ContentPage clickOnCategoriesAndProducts(){
        locateAndClickCategoriesAndProducts();
        return new ContentPage(webDriver);
    }

    private void locateAndClickCategoriesAndProducts(){
        List<WebElement> menuButtons = webDriver.findElements(categoriesAndProducts);
        WebElement categoriesAndProducts = menuButtons.get(2);
        categoriesAndProducts.click();
    }
}
