package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.page.DataTablePage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataTableSortTest extends BaseTest {

    private DataTablePage dataTablePage;

    @BeforeMethod
    public void openBrowser() {
        dataTablePage = homePage.navigateToDataTablePage();
    }

    @Test
    public void sortLastNameTest() {
        List<String> expectedLastNames = dataTablePage.getLastNameValues();
        Collections.sort(expectedLastNames);
        dataTablePage.clickLastNameHeader();
        List<String> actualLastNames = dataTablePage.getLastNameValues();
        Assert.assertEquals(actualLastNames, expectedLastNames);
    }

    @Test
    public void sortFirstNameTest() {
        List<String> expectedFirstNames = dataTablePage. getFirstNameValues();
        Collections.sort(expectedFirstNames);
        dataTablePage.clickFirstNameHeader();
        List<String> actualFirstNames = dataTablePage.getFirstNameValues();
        Assert.assertEquals(actualFirstNames, expectedFirstNames);
    }
}
