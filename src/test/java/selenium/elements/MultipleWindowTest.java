package selenium.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MultipleWindowTest {
    private WebDriver driver;

    private static final String URL = "https://the-internet.herokuapp.com/windows";

    private static final By CLICK_HERE_LINK = By.cssSelector(".example a");
    private static final By TEXT_CONTAINER = By.cssSelector(".example");

    private static final String CONTENT = "New Window";

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(URL);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void multipleWindowTest() {
        driver.findElement(CLICK_HERE_LINK).click();
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
        List<String> handles = new ArrayList<>(driver.getWindowHandles());
        String windowHandle = handles.get(1);
        driver.switchTo().window(windowHandle);
        String actualText = driver.findElement(TEXT_CONTAINER).getText();
        Assert.assertEquals(actualText, CONTENT);
    }
}
