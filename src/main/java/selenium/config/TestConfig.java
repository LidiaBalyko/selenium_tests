package selenium.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfig {

    private static final InputStream CONFIG_PROPS = TestConfig.class.getResourceAsStream("/conf.properties");
    private static final Properties PROPERTIES;

    static {
        PROPERTIES = new Properties();
        try {
            PROPERTIES.load(CONFIG_PROPS);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
