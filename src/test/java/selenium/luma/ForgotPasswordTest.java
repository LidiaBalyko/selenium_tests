package selenium.luma;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.luma.page.ForgotPasswordPage;
import selenium.luma.page.LoginPage;

public class ForgotPasswordTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void goToSignInPage() {
        loginPage = homePage.clickSighInLink();
    }

    @Test
    public void testForgotPasswordLink() {
        ForgotPasswordPage forgotPasswordPage = loginPage.clickForgotPassword();
        Assert.assertTrue(forgotPasswordPage.isPageDisplayed());
    }
}
