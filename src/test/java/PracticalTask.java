import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class PracticalTask {
    WebDriver webDriver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();

        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @Test
    public void testPracticePage() {
        HomePage homePage = new HomePage(webDriver);

        homePage.getLoginPage()
                .logIn("admin", "password")
                .clickOnCategoriesAndProducts()
                .goToCreateNewForm()
                .createNewProduct("TabletOfGold")
                .clickSubmitButton()
                .deactivateTablet();
    }
}
