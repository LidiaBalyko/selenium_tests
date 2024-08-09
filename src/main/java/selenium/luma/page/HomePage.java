package selenium.luma.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(css = ".panel .authorization-link a")
    private WebElement signInLink;

    @FindBy(css = ".page-header .welcome")
    private WebElement welcomeMessage;

    public HomePage() {
        super ();
        PageFactory.initElements(driver,this);
    }

    public LoginPage clickSighInLink() {
        signInLink.click();
        return new LoginPage();
    }

    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isDisplayed();
    }

    public boolean checkWelcomeMessageContains(String userName) {
        wait.until(ExpectedConditions.textToBePresentInElement(welcomeMessage, userName));
        return welcomeMessage.getText().contains(userName);
    }
}
