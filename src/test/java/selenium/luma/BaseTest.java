package selenium.luma;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium.config.TestConfig;
import selenium.driver.DriverManager;
import selenium.luma.page.HomePage;

public class BaseTest {
    private static final String BASE_URL = TestConfig.get("url.Luma.home");

    protected HomePage homePage;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        DriverManager.getDriver().get(BASE_URL);
        homePage = new HomePage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        DriverManager.tearDown();
    }
}
