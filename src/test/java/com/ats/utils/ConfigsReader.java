package com.ats.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This method reads properties
 * @author gulen
 *
 */
public class ConfigsReader {
	public static FileInputStream fis;
	public static Properties prop;

	public static void readProperties(String filePath) {
		try {
			fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method gets properties
	 * @param key
	 * @return
	 */
	public static String getProperties(String key) {
		return prop.getProperty(key);
	}

}
