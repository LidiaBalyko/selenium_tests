package selenium.luma;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.luma.page.CreateAccountPage;
import selenium.luma.page.HomePage;
import selenium.luma.page.LoginPage;

public class CreateAccountTest extends BaseTest {
    private LoginPage loginPage;
    private HomePage homePage;

    @BeforeMethod
    public void goToSignInPage() {
        homePage = new HomePage();
        loginPage = homePage.clickSighInLink();
    }

    @Test
    public void testCreateAccountButton() {
        CreateAccountPage createAccountPage = loginPage.clickCreateAccount();
        Assert.assertTrue(createAccountPage.isPageDisplayed());
    }
}
