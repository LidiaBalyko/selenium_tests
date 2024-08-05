package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckboxPage  extends BasePage {
    private static final By CHECKBOX_1 = By.cssSelector("[type='checkbox']:nth-of-type(1)");
    private static final By CHECKBOX_2 = By.cssSelector("[type='checkbox']:nth-of-type(2)");

    public WebElement getFirstCheckbox() {
        return driver.findElement(CHECKBOX_1);
    }

    public WebElement getSecondCheckbox() {
        return driver.findElement(CHECKBOX_2);
    }

    public void selectCheckBox(Checkbox checkbox) {
        switch (checkbox) {
            case FIRST -> select(getFirstCheckbox());
            case SECOND -> select(getSecondCheckbox());
        }
    }

    private void select(WebElement checkboxElement) {
        if (!checkboxElement.isSelected()) {
            checkboxElement.click();
        }
    }

    public enum Checkbox {
        FIRST,SECOND
    }
}
