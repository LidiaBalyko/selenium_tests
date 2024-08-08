package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class IframeTest {

    private WebDriver driver;

    private static final String URL = "https://the-internet.herokuapp.com/iframe";
    private static final By CONTENT_BODY = By.id("tinymce");
    private static final String IFRAME_ID = "mce_0_ifr";

    private static final String CUSTOM_TEXT = "Hello world!";

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
    public void frameTest() {
        driver.switchTo().frame(IFRAME_ID);

        WebElement contentBody = driver.findElement(CONTENT_BODY);
        contentBody.clear();
        contentBody.sendKeys(CUSTOM_TEXT);

        Assert.assertEquals(contentBody.getText(), CUSTOM_TEXT);
    }
}
