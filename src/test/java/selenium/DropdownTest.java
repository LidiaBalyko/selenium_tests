package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DropdownTest {
    private WebDriver driver;
    private static final String URL ="https://the-internet.herokuapp.com/dropdown";


    private static final String EXPECTED_TEXT_OPTION_1 = "Option 1";
    private static final String EXPECTED_TEXT_OPTION_2 = "Option 2";
    private static final String OPTION_1_VALUE = "1";
    private static final String OPTION_2_VALUE = "2";

    private static final By DROPDOWN= By.cssSelector("#dropdown");

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get (URL);
    }
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    @Test
    public void dropdownTest() {
        WebElement dropdown = driver.findElement(DROPDOWN);
        Select select = new Select(dropdown);
    //  select.selectByValue(OPTION_1_VALUE);
    //  select.selectByVisibleText(EXPECTED_TEXT_OPTION_1);
        select.selectByIndex(1);
        String actualSelectedOptionText = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelectedOptionText, EXPECTED_TEXT_OPTION_1);

        select.selectByIndex(2);
        actualSelectedOptionText = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelectedOptionText, EXPECTED_TEXT_OPTION_2);
    }
}

