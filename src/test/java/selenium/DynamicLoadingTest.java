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
import selenium.page.DynamicLoadingPage;

import java.time.Duration;

public class DynamicLoadingTest extends BaseTest {

    private DynamicLoadingPage dynamicLoadingPage;

    @BeforeMethod
    public void openBrowser() {
        dynamicLoadingPage = homePage.navigateToDynamicLoadingPage();
    }

   @Test
    public void hiddenElementTest() {
        dynamicLoadingPage.clickExample1Link();
        dynamicLoadingPage.clickStartButton();
        String actualText = dynamicLoadingPage.getFinishMessageText();
        Assert.assertEquals(actualText, "Hello World!");
        Assert.assertTrue(dynamicLoadingPage.isFinishMessageDisplayed());
    }

    @Test
        public void nonExistedElementTest() {
            dynamicLoadingPage.clickExample2Link();
            dynamicLoadingPage.clickStartButton();
            String actualText = dynamicLoadingPage.getFinishMessageText();
            Assert.assertEquals(actualText, "Hello World!");
            Assert.assertTrue(dynamicLoadingPage.isFinishMessageDisplayed());
    }
}

