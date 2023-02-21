package com.solvd.zebrunner_agent.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.qaprosoft.carina.core.foundation.crypto.CryptoTool;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

import static com.qaprosoft.carina.core.foundation.utils.messager.IMessager.CRYPTO_PATTERN;


public class PropertiesReader {

    private static final Logger LOGGER = LogManager.getLogger(PropertiesReader.class);
    private Properties properties;

    public PropertiesReader(String path) {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);
        } catch (IOException e) {
            LOGGER.error(e);
        }

    }

    public String getValue(String key) {
        return (String) properties.get(key);
    }

    public String getDecrypted(String key) {
        CryptoTool cryptoTool = new CryptoTool(Configuration.get(Configuration.Parameter.CRYPTO_KEY_PATH));
        return cryptoTool.decryptByPattern(getValue(key),CRYPTO_PATTERN);
    }

}
