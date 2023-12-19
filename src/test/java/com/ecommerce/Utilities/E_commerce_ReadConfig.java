package com.ecommerce.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class E_commerce_ReadConfig  {

	public File file;
	public FileInputStream fs;
	public Properties properties;
	
	public  E_commerce_ReadConfig() {
		file=new File("./Configuration/config.properties");
		try {
			fs=new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		properties=new Properties();
		try {
			properties.load(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getApplicationUrl() {
		String url=properties.getProperty("Url");
		return url;
	}
	public String getBrowserLocation() {
		String browserLocation=properties.getProperty("ChromeLocation");
		return browserLocation;
		
	}
}
