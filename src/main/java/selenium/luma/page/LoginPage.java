package selenium.luma.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(css = "#email")
    private WebElement emailField;

    @FindBy(css = "input[name='login[password]']")
    private WebElement passwordField;

    @FindBy(css = "button.login")
    private WebElement signInButton;

    @FindBy(css = "#email-error")
    private WebElement emailErrorMessage;

    @FindBy(css = "#pass-error")
    private WebElement passwordErrorMessage;

    @FindBy(css = "[data-ui-id='message-error']")
    private WebElement signInMessage;

    @FindBy(linkText = "Create an Account")
    private WebElement createAccountLink;

    @FindBy(css = "h1.page-title span")
    private WebElement pageTitle;

    @FindBy(linkText = "Forgot Your Password?")
    private WebElement forgotPasswordLink;


    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void fillEmailField(String email) {
        emailField.sendKeys(email);
    }

    public void fillPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public HomePage clickSignInButton() {
        signInButton.click();
        return new HomePage();
    }

    public boolean isEmailErrorDisplayed() {
        return emailErrorMessage.isDisplayed();
    }

    public boolean isPasswordErrorDisplayed() {
        return passwordErrorMessage.isDisplayed();
    }

    public String getEmailErrorMessageText() {
        return emailErrorMessage.getText();
    }

    public String getPasswordErrorMessageText() {
        return passwordErrorMessage.getText();
    }

    public String getSignInMessageText() {
        return signInMessage.getText();
    }
    public CreateAccountPage clickCreateAccount() {
        createAccountLink.click();
        return new CreateAccountPage();
    }

    public ForgotPasswordPage clickForgotPassword() {
        forgotPasswordLink.click();
        return new ForgotPasswordPage();
    }

}
