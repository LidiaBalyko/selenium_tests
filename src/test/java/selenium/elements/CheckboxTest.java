package selenium.elements;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.page.CheckboxPage;

import static selenium.page.CheckboxPage.Checkbox.FIRST;
import static selenium.page.CheckboxPage.Checkbox.SECOND;

public class CheckboxTest extends BaseTest {

    private CheckboxPage checkboxPage;

    @BeforeMethod
    public void goToCheckboxPage() {
        checkboxPage = homePage.navigateToCheckboxPage();
    }

    @Test
    public void checkboxDefaultConditionTest() {
        checkboxPage = homePage.navigateToCheckboxPage();
        Assert.assertFalse(checkboxPage.getFirstCheckbox().isSelected());
        Assert.assertTrue(checkboxPage.getSecondCheckbox().isSelected());
    }

    @Test
    public void selectedCheckboxTest() {
        checkboxPage = homePage.navigateToCheckboxPage();
        checkboxPage.selectCheckBox(FIRST);
        checkboxPage.selectCheckBox(SECOND);
        Assert.assertTrue(checkboxPage.getFirstCheckbox().isSelected());
        Assert.assertTrue(checkboxPage.getSecondCheckbox().isSelected());
    }
}
