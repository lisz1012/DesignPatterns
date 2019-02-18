package observer;

import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static final Properties PROPS = new Properties();
    static {
        try {
            PROPS.load(Main.class.getClassLoader().getResourceAsStream("observer/observer.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key) {
        return PROPS.getProperty(key);
    }
}
