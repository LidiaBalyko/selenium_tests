package selenium.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicLoadingPage extends BasePage{

    @FindBy(css = "[href ='/dynamic_loading/1']")
    private WebElement example1Link;

    @FindBy(css = "[href ='/dynamic_loading/2']")
    private WebElement example2Link;

    @FindBy(css = "div#start button")
    private WebElement startButton;

    @FindBy(css = "div#finish")
    private WebElement finishMessage;

    public DynamicLoadingPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void clickExample1Link() {
        example1Link.click();
    }

    public void clickExample2Link() {
        example2Link.click();
    }

    public void clickStartButton() {
        startButton.click();
    }

    public boolean isFinishMessageDisplayed() {
        return finishMessage.isDisplayed();
    }

    public String getFinishMessageText () {
        wait.until(ExpectedConditions.visibilityOf(finishMessage));
        return finishMessage.getText();
    }
}
