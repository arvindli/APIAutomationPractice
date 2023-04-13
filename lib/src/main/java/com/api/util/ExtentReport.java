package com.api.util;

import java.io.File;
import java.io.IOException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ExtentReport {
	
	public static ExtentReports extentReport=null;
	public  static ExtentTest extentLog;
	
	public static void initialize(String path) throws IOException {
		
		if(extentReport==null) {
			
			extentReport=new ExtentReports(path,true);
			extentReport.addSystemInfo("Host Name", System.getProperty("user.name"));
			extentReport.addSystemInfo("Environment", Helper.PropertyReader("executionEnv"));
			extentReport.addSystemInfo("Build Version","2.0");
			extentReport.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
		}
		
	}

}
