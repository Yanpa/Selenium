package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditTabletPage {
    WebDriver webDriver;
    WebDriverWait wait;

    By submitButton = new By.ById("submitbutton");
    By chosenTabletToBeEdited = new By.ByXPath(".//a[contains(text(), 'TabletOfGold')]");

    public EditTabletPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(10));
    }

    public TabletsPage clickSubmitButton(){
        clickOnTabletName();
        return new TabletsPage(webDriver);
    }

    private void editTabletStorage(){
        WebElement attributes = webDriver.findElement(new By.ByClassName("cus-tag-green"));
        attributes.click();

        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(new By.ByXPath(".//a[contains(text(), ' Set attributes values')]")))).click();
        webDriver.switchTo().activeElement();

        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(new By.ByXPath(".//div[contains(text(), ' Storage ')]")))).click();
    }

    private void clickOnTabletName(){
        webDriver.findElement(chosenTabletToBeEdited).click();

        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(submitButton)));
        webDriver.findElement(submitButton).click();
    }
}
