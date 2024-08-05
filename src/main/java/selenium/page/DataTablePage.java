package selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DataTablePage extends BasePage {

    private static final By LAST_NAME_HEADER= By.xpath(("//table[@id='table1']//span[text() ='Last Name']"));
    private static final By FIRST_NAME_HEADER = By.xpath(("//table[@id='table1']//span[text() ='First Name']"));
    private static final By FIRST_NAMES = By.cssSelector("#table1 td:nth-of-type(2)");
    private static final By LAST_NAMES = By.cssSelector("#table1 td:nth-of-type(1)");

    public void clickFirstNameHeader() {
        driver.findElement(FIRST_NAME_HEADER).click();
    }

    public void clickLastNameHeader() {
        driver.findElement(LAST_NAME_HEADER).click();
    }

    public List<String> getLastNameValues() {
        return getValues(LAST_NAMES);
    }

    public List<String> getFirstNameValues() {
        return getValues(FIRST_NAMES);
    }

    private List<String> getValues (By locator) {
        return new ArrayList<>(driver.findElements(locator).stream().map(WebElement:: getText).toList());
    }
}
