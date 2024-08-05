package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
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

public class LoginTest {

    private WebDriver driver;

    private static final String URL = "https://magento.softwaretestingboard.com/";
    private static final String Email = "testlida9@gmail.com";
    private static final String Password = "K_Ev2hU@7NUF7si";
    private static final String USER_NAME = "Anna Sant";


    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //      driver.manage().window().setSize(new Dimension(1000, 400));
        driver.get(URL);
    }

    @Test
    public void signInTest() {
        By signInLinkLocator = By.cssSelector(".panel .authorization-link a");
        WebElement signInLink = driver.findElement(signInLinkLocator);
        signInLink.click();

        By emailFieldLocator = By.cssSelector("#email");
        WebElement emailField = driver.findElement(emailFieldLocator);
        emailField.sendKeys(Email);

        By passwordFieldLocator = By.cssSelector("input[name='login[password]']");
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.sendKeys(Password);

        By signInButtonLocator = By.cssSelector("button.login");
        WebElement signInButton = driver.findElement(signInButtonLocator);
        signInButton.click();

        By welcomeMessageLocator = By.cssSelector(".page-header .welcome");
        WebElement welcomeMessage = driver.findElement(welcomeMessageLocator);

        Assert.assertTrue(welcomeMessage.isDisplayed());

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.textToBePresentInElement(welcomeMessage, USER_NAME));
        Assert.assertTrue(welcomeMessage.getText().contains(USER_NAME));
    }


    @AfterMethod
    public void closeBrowser() {
//        driver.close();
        driver.quit();
    }
}
