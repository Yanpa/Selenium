package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TabletsPage {
    WebDriver webDriver;
    WebDriverWait wait;

    By productTitleLocator = new By.ById("ContentDescription][1][name1");
    By productDescriptionLocator = new By.ById("tinymce");
    By shortenedProductDescriptionLocator = new By.ById("tinymce");
    By tabLocator = new By.ById("myTab");
    By productLabelLocator = new By.ById("ContentProductLabelId");
    By contentTableLocator = new By.ByClassName("contentTable");
    By checkboxLocator = new By.ById("ContentModify][");
    By dropdownDivLocator = new By.ByClassName("multiAction");
    By dropdownMenuLocator = new By.ById("multiaction");

    public TabletsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(this.webDriver, Duration.ofSeconds(10));
    }

    public EditTabletPage createNewProduct(String tabletName){
        selectContentParent();
        setTabletName(tabletName);
        fillDescriptions();
        switchTabs();
        selectProductLabel();
        clickSubmitButton();

        return new EditTabletPage(webDriver);
    }

    private void selectContentParent(){
        Select contentParent = new Select(webDriver.findElement(By.id("ContentParentId")));
        contentParent.selectByVisibleText("Tablets");
    }

    private void setTabletName(String nameOfNewTablet){
        WebElement productTitle = webDriver.findElement(productTitleLocator);
        productTitle.sendKeys(nameOfNewTablet);
    }

    private void fillDescriptions(){
        webDriver.switchTo().frame("content_description_1_ifr");
        WebElement productDescription = webDriver.findElement(productDescriptionLocator);
        productDescription.sendKeys("This tablet is shown to withstand from the strongest attacks. That's why we ironically named it crack");

        webDriver.switchTo().defaultContent();

        webDriver.switchTo().frame("content_short_description_1_ifr");
        WebElement shortenedProductDescription = webDriver.findElement(shortenedProductDescriptionLocator);
        shortenedProductDescription.sendKeys("This is a indestructible tablet");

        webDriver.switchTo().defaultContent();
    }

    private void switchTabs(){
        WebElement tab = webDriver.findElement(tabLocator);
        List<WebElement> dataTabs = tab.findElements(new By.ByTagName("li"));
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].click();", dataTabs.get(1).findElement(new By.ByTagName("a")));
    }

    private void selectProductLabel(){
        Select productLabel = new Select(webDriver.findElement(productLabelLocator));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", productLabel);
        wait.until(ExpectedConditions.elementToBeClickable(webDriver.findElement(productLabelLocator)));
        productLabel.selectByVisibleText("New");
    }

    private void clickSubmitButton(){
        WebElement submitButton = webDriver.findElement(new By.ById("submitbutton"));
        submitButton.click();
    }

    public void deactivateTablet(){
        locateAndClickCheckbox();
        locateAndSelectDeactivateInDropdown();
        acceptAlert();
    }

    private void locateAndClickCheckbox(){
        List<WebElement> contentTableRows = webDriver.findElement(contentTableLocator).findElements(new By.ByTagName("tr"));
        System.out.println(contentTableRows.size());

        List<WebElement> contentTableCols = contentTableRows.get(contentTableRows.size() - 2).findElements(new By.ByTagName("td"));
        contentTableCols.get(contentTableCols.size() - 1).findElement(checkboxLocator).click();
    }

    private void locateAndSelectDeactivateInDropdown(){
        Select contentParent = new Select(webDriver.findElement(dropdownDivLocator).findElement(dropdownMenuLocator));
        contentParent.selectByVisibleText("Deactivate");
    }

    private void acceptAlert(){
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = webDriver.switchTo().alert();

        alert.accept();
    }
}
