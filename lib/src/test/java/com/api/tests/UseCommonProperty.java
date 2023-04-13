package com.api.tests;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import io.restassured.response.Response;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.util.Helper;
import com.api.util.ReadTestData;

import io.restassured.response.Response;

public class UseCommonProperty {
	
	
	@Test(description="Use of Helper.PropertyReader method to access keyvalue from common.properties")
	public void ValidatePropertyReaderFile() throws IOException {
		
		System.out.println("*****"+Helper.PropertyReader("qaBaseUrl")+"*********");
		Response resp=given()
						.when().get(Helper.PropertyReader("qaBaseUrl"));
		
		int actualStatusCode=resp.getStatusCode();
		Assert.assertEquals(actualStatusCode, 200);
		System.out.println(resp.body().asString());
	}
	
	@Test(description="Fetch base url from property file and endpoint from json file")
	public void ValidateCommonPropertyandJsonfile() throws IOException, ParseException {
		
		String baseurl=Helper.PropertyReader("qaBaseUrl");
		String point=ReadTestData.GetTestData("endpoint");
		
		String uri=baseurl+point;
		
		System.out.println("*************"+uri+"***************");
		
//		Response resp=given()
//						.when().get(Helper.PropertyReader("qaBaseUrl")+ReadTestData.GetTestData("endpoint"));
		
		Response resp=given()
				.when().get(uri);
		
		int statuscode=resp.getStatusCode();
		Assert.assertEquals(statuscode, 200);
	}
	
}
		

