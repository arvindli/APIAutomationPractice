package com.api.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadTestData {

//This method fetch TestData.json file, convert into String variable, again convert that string variable into java object 
//and finally convert java object into JSONObject and return whener this method gets called 	
	public static JSONObject GetJsonData() throws IOException, ParseException {
		
		//Step#1 --> Create File class object to read and hold "TestData.json" file
		File file= new File("Resources/TestData/TestData.json");
		
		//Step#2 --> Convert file object into string with help of FileUtils class
		String str=FileUtils.readFileToString(file, "UTF-8");
		
		//Step#3 --> Convert String variable"str" into Java obj
		Object obj= new JSONParser().parse(str);
		
		//Step#4 --> Convert java object into JSONObject
		JSONObject jsonobj=(JSONObject) obj;
		
		return jsonobj;
		
		
	}
	
	public static String GetTestData(String keypair) throws IOException, ParseException {
		
		String keyvalues;
		return keyvalues=(String)GetJsonData().get(keypair);
		
		
	}
	
}
