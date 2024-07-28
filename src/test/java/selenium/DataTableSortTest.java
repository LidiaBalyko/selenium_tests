package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTableSortTest {
    private WebDriver driver;
    private static final String URL ="https://the-internet.herokuapp.com/tables";


    private static final By LAST_NAME_HEADER= By.xpath(("//table[@id='table1']//span[text() ='Last Name']"));
    private static final By FIRST_NAME_HEADER = By.xpath(("//table[@id='table1']//span[text() ='First Name']"));
    private static final By FIRST_NAMES = By.cssSelector("#table1 td:nth-of-type(2)");
    private static final By LAST_NAMES = By.cssSelector("#table1 td:nth-of-type(1)");

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
    public void sortLastNameTest() {
        List<String> expectedLastNames = new ArrayList<>(driver.findElements(LAST_NAMES).stream().
                map(WebElement::getText).toList());
        Collections.sort(expectedLastNames);

        WebElement lastNameHeader = driver.findElement(LAST_NAME_HEADER);
        lastNameHeader.click();

        List<String> actualLastNames = driver.findElements(LAST_NAMES).stream().map(WebElement::getText).toList();
        Assert.assertEquals(actualLastNames, expectedLastNames);
    }

    @Test
    public void sortFirstNameTest() {
        List<String> expectedFirstNames = new ArrayList<>(driver.findElements(FIRST_NAMES).stream().
                map(WebElement::getText).toList());
        Collections.sort(expectedFirstNames);

        WebElement firstNameHeader = driver.findElement(FIRST_NAME_HEADER);
        firstNameHeader.click();

        List<String> actualFirstNames = driver.findElements(FIRST_NAMES).stream().map(WebElement::getText).toList();
        Assert.assertEquals(actualFirstNames, expectedFirstNames);
    }
}
