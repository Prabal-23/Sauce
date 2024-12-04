package Util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UtilClass {
    private static String currentDirectory = System.getProperty("user.dir");

    private static  String filename = currentDirectory + "\\src/main/resources/";

    public static Properties getPropertiesFile(String file) {
        Properties prop = new Properties();
        FileInputStream stream;

        try {
            stream =new FileInputStream(filename+file);
            prop.load(stream);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return prop;
    }


}
