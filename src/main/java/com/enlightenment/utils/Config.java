package com.enlightenment.utils;

import java.io.InputStream;
import java.util.Properties;

public class Config {

    private static Properties objGlobal;

    static {
        objGlobal = new Properties();
        InputStream objIs = Config.class.getResourceAsStream("/environment.properties");
        try {
            objGlobal.load(objIs);
        } catch (Exception ex) {

        }
    }

    private Config() {

    }

    /**
     * Gets global property.
     *
     * @param globalName the name of the property to get
     * @return the value of the property as a string
     */
    public static String getGlobalProperty(String globalName) {
        return objGlobal.getProperty(globalName);
    }
}
