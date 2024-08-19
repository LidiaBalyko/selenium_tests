package selenium;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import selenium.driver.DriverManager;

public class TestListner implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot();
    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    private byte[] takeScreenshot() {
        return ( (TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

