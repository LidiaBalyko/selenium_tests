package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicLoadingTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final String URL ="https://the-internet.herokuapp.com/dynamic_loading";

    private static final By EXAMPLE_1_LINK = By.cssSelector("[href ='/dynamic_loading/1']");
    private static final By EXAMPLE_2_LINK = By.cssSelector("[href ='/dynamic_loading/2']");
    private static final By START_BUTTON = By.cssSelector("div#start button");
    private static final By FINISH_MESSAGE = By.cssSelector("div#finish");

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
  //      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get (URL);
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void hiddenElementTest() {
        driver.findElement(EXAMPLE_1_LINK).click();
        driver.findElement(START_BUTTON).click();
        WebElement finishMessage = driver.findElement(FINISH_MESSAGE);
        wait.until(ExpectedConditions.visibilityOf(finishMessage));
        String actualText = finishMessage.getText();
        Assert.assertEquals(actualText, "Hello World!");
        Assert.assertTrue(finishMessage.isDisplayed());
    }

    @Test
        public void nonExistedElementTest() {
            driver.findElement(EXAMPLE_2_LINK).click();
            driver.findElement(START_BUTTON).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(FINISH_MESSAGE));
            WebElement finishMessage = driver.findElement(FINISH_MESSAGE);
     //         wait.until(ExpectedConditions.visibilityOf(finishMessage));
            String actualText = finishMessage.getText();
            Assert.assertEquals(actualText, "Hello World!");
            Assert.assertTrue(finishMessage.isDisplayed());
    }
}

