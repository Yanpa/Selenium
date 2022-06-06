package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContentPage {
    WebDriver webDriver;
    By createNewProductLocator = new By.ByClassName("cus-add");

    public ContentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public TabletsPage goToCreateNewForm(){
        clickOnCreateNewButton();

        return new TabletsPage(webDriver);
    }

    private void clickOnCreateNewButton(){
        WebElement createNewProduct = webDriver.findElement(createNewProductLocator);
        createNewProduct.click();
    }
}
