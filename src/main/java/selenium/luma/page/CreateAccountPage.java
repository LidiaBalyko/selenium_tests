package selenium.luma.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends BasePage {

    @FindBy(linkText = "Create an Account")
    private WebElement createAccountLink;


   public CreateAccountPage() {
        super();
        PageFactory.initElements(driver, this);
    }
    public void clickCreateAccount() {
        createAccountLink.click();
    }
}
