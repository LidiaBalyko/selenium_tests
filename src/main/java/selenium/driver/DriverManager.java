package selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    private DriverManager () {}

        public static WebDriver getDriver() {
        if (driverThreadLocal.get() == null) {
            WebDriver webDriver = new ChromeDriver();
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            driverThreadLocal.set(webDriver);
        }
        return driverThreadLocal.get();
    }

    public static void tearDown() {
       driverThreadLocal.get().quit();
       driverThreadLocal.set(null);
    }
}

