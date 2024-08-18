package selenium.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

public class HoverTest {
    private WebDriver driver;
    private WebDriverWait wait;

    private static final String URL = "https://the-internet.herokuapp.com/hovers";

    private static final By AVATAR = By.cssSelector(".figure img");
    private static final By VIEW_PROFILE_LINK = By.cssSelector(".figure a");
    private static final By AVATAR_TEXT = By.cssSelector(".figure h5");
    private static final By PROFILE = By.cssSelector("h1");

    private static final String EXPECTED_PROFILE_TEXT = "Not Found";

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(URL);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void profileTextTest() {
        List<WebElement> avatars = driver.findElements(AVATAR);
        List<WebElement> links = driver.findElements(VIEW_PROFILE_LINK);


        Actions actions = new Actions(driver);
        actions.moveToElement(avatars.get(0)).perform();
        links.get(0).click();

        WebElement profile = driver.findElement(PROFILE);
        String actualProfiletext = profile.getText();
        Assert.assertEquals(actualProfiletext, EXPECTED_PROFILE_TEXT);
    }

    @Test
    public void avatarTextTest() {
        WebElement avatar = driver.findElement(AVATAR);
        WebElement avatarText = driver.findElement(AVATAR_TEXT);


        Actions actions = new Actions(driver);
        actions.moveToElement(avatar).perform();

        Assert.assertTrue(avatarText. isDisplayed());
        Assert.assertTrue(avatarText. getText().contains("user1"));
    }

    @Test
    public void avatarLinksTest() {
        List<WebElement> avatars = driver.findElements(AVATAR);
        List<WebElement> links = driver.findElements(VIEW_PROFILE_LINK);


        Actions actions = new Actions(driver);
        IntStream.range(0,3).forEach(i -> {
            actions.moveToElement(avatars.get(i)).perform();
            Assert.assertTrue(links.get(i).isDisplayed());
        });
    }
}
