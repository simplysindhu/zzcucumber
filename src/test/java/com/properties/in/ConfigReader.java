package com.properties.in;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {
	public static Properties p;

	public ConfigReader() throws Exception {
		File f = new File(
				"S:\\eclipse-java-2019-06-R-win32-x86_64\\eclipse\\practicing space\\ZZCucumber\\src\\test\\java\\com\\properties\\in\\Data.properties");
		FileInputStream fis = new FileInputStream(f);
		p = new Properties();
		p.load(fis);

	}

	public String getBrowser() {
		String property = p.getProperty("browser");
		return property;
	}

	

}
