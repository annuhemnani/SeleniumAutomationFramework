package com.tmp.utills;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertyFile {
	private static Properties prop=new Properties();
	static {
		FileInputStream fp;
		try {
			fp = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/configs/config.properties");
			prop.load(fp);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String get(String key) throws IOException {
		
		
		return prop.getProperty(key).trim();
	
	}
}
