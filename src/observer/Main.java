package observer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        Child c = new Child();
        try {
            String observers[] = PropertyManager.getProperty("observers").split(",");
            for (String observer : observers) {
                c.addWakenUpListener((WakenUpListener) Class.forName(observer).newInstance());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        new Thread(c).start();
    }
}


