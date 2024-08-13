package selenium.luma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import selenium.data.DataProviderClass;
import selenium.luma.page.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {

    private WebDriver driver;

    private static final String URL = "https://magento.softwaretestingboard.com/";
    private static final String EMAIL = "testlida9@gmail.com";
    private static final String INVALID_EMAIL = "testlida9";
    private static final String PASSWORD = "K_Ev2hU@7NUF7si";
    private static final String INVALID_PASSWORD = "K_Ev2hU@7NUF7";
    private static final String USER_NAME = "Anna Sant";
    private static final String REQUIRED_FIELDS_ERROR_MESSAGE_TEXT = "This is a required field.";
    private static final String INVALID_EMAIL_ERROR_MESSAGE_TEXT = "Please enter a valid email address (Ex: johndoe@domain.com).";
    private static final String INVALID_SIGN_IN_ERROR_MESSAGE_TEXT = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";

    private LoginPage loginPage;

    @BeforeMethod
    public void goToSignInPage() {
        loginPage = homePage.clickSighInLink();
    }

    @Test
    public void signInTest() {
        loginPage.fillEmailField(EMAIL);
        loginPage.fillPasswordField(PASSWORD);
        homePage = loginPage.clickSignInButton();
        Assert.assertTrue(homePage.isWelcomeMessageDisplayed());
        Assert.assertTrue(homePage.checkWelcomeMessageContains(USER_NAME));
    }

    @Test
    public void signInErrorTest() {
        loginPage.clickSignInButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.isEmailErrorDisplayed());
        softAssert.assertTrue(loginPage.isPasswordErrorDisplayed());
        softAssert.assertTrue(loginPage.getPasswordErrorMessageText().contains(REQUIRED_FIELDS_ERROR_MESSAGE_TEXT));
        softAssert.assertTrue(loginPage.getEmailErrorMessageText().contains(REQUIRED_FIELDS_ERROR_MESSAGE_TEXT));
        softAssert.assertAll();
    }

    @Test
    public void invalidEmailTest() {
        loginPage.fillEmailField(INVALID_EMAIL);
        loginPage.fillPasswordField(PASSWORD);
        loginPage.clickSignInButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.isEmailErrorDisplayed());
        softAssert.assertTrue(loginPage.getEmailErrorMessageText().contains(INVALID_EMAIL_ERROR_MESSAGE_TEXT));
        softAssert.assertAll();
    }

    @Test
    public void invalidSignInTest() {
        loginPage.fillEmailField(EMAIL);
        loginPage.fillPasswordField(INVALID_PASSWORD);
        loginPage.clickSignInButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.getSignInMessageText().contains(INVALID_SIGN_IN_ERROR_MESSAGE_TEXT));
        softAssert.assertAll();
    }

    @Test(dataProvider = "invalidSignInData", dataProviderClass = DataProviderClass.class)
        public void invalidSignInDDTest(String invalidPassword) {
        loginPage.fillEmailField(EMAIL);
        loginPage.fillPasswordField(invalidPassword);
        loginPage.clickSignInButton();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPage.getSignInMessageText().contains(INVALID_SIGN_IN_ERROR_MESSAGE_TEXT));
        softAssert.assertAll();
    }
}

