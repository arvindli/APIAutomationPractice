package com.api.tests;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.util.Helper;
import com.api.util.ReadTestData;

public class PostMethodWithFile {
	
	@Test(description="Validate response code for POST method")
	public void ValidateStatusCodePostMethod() throws IOException, ParseException {
		
		//Step#1-->Create File class object which stores and read filepath
		File filerb=new File(System.getProperty("user.dir")+"/Resources/TestData/PostRequestData.json");
		
		//Step#2-->Create object of class file inputstream and pass File object created in above steps 
		FileInputStream file=new FileInputStream(filerb);
		
		//Step#3--> Create Response class object 
		Response resp=given().header("Content-Type", "Application/json")
						.body(IOUtils.toString(file,"UTF-8"))
						.when().post("https://reqres.in/api/users");
		
		int status=resp.getStatusCode();
		Assert.assertEquals(status, 201);
		System.out.println("*********"+resp.body().asString()+"*********");
	
	}

}
