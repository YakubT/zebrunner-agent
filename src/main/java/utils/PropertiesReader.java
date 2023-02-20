package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertiesReader {

    private static final Logger LOGGER = LogManager.getLogger(PropertiesReader.class);
    private Properties properties;

    public PropertiesReader(String path) {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);
        }
        catch (IOException e) {
            LOGGER.error(e);
        }

    }

    public String getValue(String key) {
       return (String) properties.get(key);
    }
}
