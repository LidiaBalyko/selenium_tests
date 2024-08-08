package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class JsAlertTest {
    private WebDriver driver;

    private static final String URL = "https://the-internet.herokuapp.com/javascript_alerts";

    private static final By JS_ALERT_BUTTON = By.xpath("//button[contains(text(), 'JS Alert')]");
    private static final By JS_PROMPT_BUTTON = By.xpath("//button[contains(text(), 'JS Prompt')]");
    private static final By RESULT_MESSAGE = By.cssSelector("#result");

    private static final String MESSAGE = "Hello world!";
    private static final String EXPECTED_ALERT_TEXT= "I am a JS Alert";

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
    public void jsAlertTest() {
        driver.findElement(JS_ALERT_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        String actualAlertText = alert.getText();
        Assert.assertEquals(actualAlertText, EXPECTED_ALERT_TEXT);
    }

    @Test
    public void jsPromptTest() {
        driver.findElement(JS_PROMPT_BUTTON).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(MESSAGE);
        alert.accept();
        String actualMessageText = driver.findElement(RESULT_MESSAGE).getText();
        Assert.assertTrue(actualMessageText.contains(MESSAGE));
    }
}
