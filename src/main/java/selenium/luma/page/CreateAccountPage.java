package selenium.luma.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends BasePage {

    @FindBy(css = "h1.page-title span")
    private WebElement pageTitle;

    public CreateAccountPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public boolean isPageDisplayed() {
        return pageTitle.isDisplayed() && pageTitle.getText().equals("Create New Customer Account");
    }
}
