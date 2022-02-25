package framework;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropertiesManager {
    public static String configPropertyPath = "src/test/resources/config.properties";

    public String getProperty(String propertyPath, String propertyName){
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(propertyPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties property = new Properties();
        try {
            property.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property.getProperty(propertyName);
    }
}
