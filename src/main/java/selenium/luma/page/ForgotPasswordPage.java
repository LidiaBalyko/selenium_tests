package selenium.luma.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BasePage {

    @FindBy(css = "button.submit")
    private WebElement resetPasswordButton;

    public ForgotPasswordPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isPageDisplayed() {
        return resetPasswordButton.isDisplayed();
    }
}
