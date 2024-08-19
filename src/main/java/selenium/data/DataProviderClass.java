package selenium.data;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

    @DataProvider(name = "invalidSignInData")
    public static Object[][] getInvalidSignInData() {
        return new Object[][]{
                {"@@@@@@@@@@"},
                {"!!!!!!!!!!"},
                {"###########"},
                {"$$$$$$$$$$$"},
                {"@,#,,,, #,%%%"}
        };
    }
}
