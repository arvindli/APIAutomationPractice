package com.api.core;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.api.util.ExtentReport;
import com.api.util.Helper;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTest{

	@Parameters({"ReportName","FlowType"})
	@BeforeSuite(alwaysRun=true)
	public void config(@Optional("Optional name Automation") String reportname, @Optional("API Report") String reportdate) throws IOException {
		
		String subFolderPath=System.getProperty("user.dir")+"/HTMLReport/"+Helper.TimeStamp();
		Helper.CreateFolder(subFolderPath);
		ExtentReport.initialize(subFolderPath+"/"+"API_G15Automation.html");
	}
	
	@AfterMethod(alwaysRun=true)
	public void getResult(ITestResult result) {
		
		if(result.getStatus()==ITestResult.SUCCESS) {
			ExtentReport.extentLog.log(LogStatus.PASS,"API Test Case: "+result.getName()+" is Passed");
		}else if(result.getStatus()==ITestResult.FAILURE) {
			ExtentReport.extentLog.log(LogStatus.FAIL,"API Test Case: "+result.getName()+" is Failed");
			ExtentReport.extentLog.log(LogStatus.FAIL, "API Test Case: "+ result.getName()+" is Failed due to "+result.getThrowable());
		}else if(result.getStatus()==ITestResult.SKIP) {
			ExtentReport.extentLog.log(LogStatus.SKIP, "API Test Case: "+result.getName()+" is Skipped");
		}
		ExtentReport.extentReport.endTest(ExtentReport.extentLog);
		
	}
	
	@AfterSuite(alwaysRun=true)
	public void endReport() {
		ExtentReport.extentReport.close();
	}
}
