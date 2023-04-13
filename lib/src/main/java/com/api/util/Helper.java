package com.api.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class Helper {
	
	private static final String commonFilePath=System.getProperty("user.dir")+"\\common.properties";
	public static String PropertyReader(String Keyward) throws IOException {
		String Value=null;
		
			//Step#1 --> Create object of class InputStream to store common.properties file
		try(InputStream input=new FileInputStream(commonFilePath)){
			
			//Step#2 --> Create object of class property
			Properties prop=new Properties();
			
			//Step#3 --> Load InputStream object into proprty class object
			prop.load(input);
			Value=prop.getProperty(Keyward);
			
			
			
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return Value;
	}
	
	//Code for ExtentReport
	public static void CreateFolder(String path) {
		
		File file=new File(path);
		if(!file.exists()) {
			file.mkdir();
		}
		else {
			System.out.println("File already exist");
		}
	}
	
	public static String TimeStamp() {
		String value;
		Date now=new Date();
		value=now.toString().replace(":", "-");
		return value;
		
		
	}

}
