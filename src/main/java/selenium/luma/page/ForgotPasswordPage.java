package selenium.luma.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BasePage {

    @FindBy(css = "button[title='Reset My Password']")
    private WebElement resetPasswordButton;

    public ForgotPasswordPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isResetPasswordButtonDisplayed() {
        return resetPasswordButton.isDisplayed();
    }
}
