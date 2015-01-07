package com.gov.nc.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * This class encapsulates  some methods to get the value of properties file.
 * @author Vincent
 * @version 1.0
 */
public class LoadProperties {

    /**
     * this map is used to store all the property name and value.
     */
    private static Properties map = new Properties();

    public LoadProperties(String path) {
        loadMaperties(path);
    }

    /**
     * load property file by given path
     *
     * @param path  file path
     */
    public static void loadMaperties(String path) {
        map.clear();
        InputStreamReader in = null;
        try {
            in = new InputStreamReader(LoadProperties.class.getResourceAsStream(path), "utf-8");
            map.load(in);
            if (in != null) {
                in.close();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * get property value by key.
     *
     * @param key  key value
     * @return the value of key
     */
    public String getValue(String key) {
        return (String) map.get(key);
    }
}