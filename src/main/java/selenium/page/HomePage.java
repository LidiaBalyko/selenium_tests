package selenium.page;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private static final By CHECKBOX_LINK = By.cssSelector("[href *= 'checkboxes']");
    private static final By DATA_TABLE_LINK = By.cssSelector("[href *= 'tables']");
    private static final By DROPDOWN_LINK = By.cssSelector("[href *= 'dropdown']");
    private static final By DYNAMIC_LOADING_LINK = By.cssSelector("[href *= 'dynamic_loading']");

    public CheckboxPage navigateToCheckboxPage() {
        driver.findElement(CHECKBOX_LINK).click();
        return new CheckboxPage();
    }

    public DataTablePage navigateToDataTablePage() {
        driver.findElement(DATA_TABLE_LINK).click();
        return new DataTablePage();
    }

    public DynamicLoadingPage navigateToDynamicLoadingPage() {
        driver.findElement(DYNAMIC_LOADING_LINK).click();
        return new DynamicLoadingPage();
    }
}
