package com.api.tests;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import io.restassured.response.Response;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.core.BaseTest;
import com.api.util.ExtentReport;



public class TestAPIScript extends BaseTest{

			
		@Test(description="Validate status code for Get Users endpoint", groups= {"SmokeSuite","RegressionSuite"})
		public void ValidateStatusCodeGetUsers() {
		ExtentReport.extentLog=ExtentReport.extentReport.startTest("Validate Get Users End Point","Validate Status Code for Get Users EndPoint");	
			Response resp=given()
							.when().get("https://reqres.in/api/users?page=2");
			
			int actualStatusCode=resp.getStatusCode();
			assertEquals(actualStatusCode, 200);
			//System.out.println("Hello");
		}
		
		@Test(description="Validate status code for Get Users endpoint with QueryParam", groups="SmokeSuite")
		public void ValidateStatusCodeGetUsersQueryParam() {
			ExtentReport.extentLog=ExtentReport.extentReport.startTest("Validate Get Users End Point Query Param","Validate Status Code for Get Users EndPoint for Query Param");	
			Response resp=given().queryParams("page",2)
							.when().get("https://reqres.in/api/users");
			
			int actualStatusCode=resp.getStatusCode();
			Assert.assertEquals(actualStatusCode, 200);
		}
			
		@Test(description="Validate response body & status code for Get User endpoint",groups="SmokeSuite")
		public void ValidateStatusCodeGetUsersResponseBody() {
			ExtentReport.extentLog=ExtentReport.extentReport.startTest("Validate Get Users End Point Response Body","Validate Status Code for Get Users EndPoint for Response Body");	
			Response resp=given().queryParam("page", 2)
							.when().get("https://reqres.in/api/users");
			int actualStatusCode=resp.getStatusCode();
			Assert.assertEquals(actualStatusCode, 201);
			//System.out.println("**********************"+resp.body().asString());
			//int actualPerPage=resp.path("per_page");
			//assertEquals(actualPerPage, 60);
			
			//Validate nested values in JSONpath
			
			String str=resp.path("data[1].email");
			System.out.println(str);
			
		}
		
		@Test(description="Validate status code for Get Users endpoint Using Headers",groups="SmokeSuite")
		public void ValidateStatusCodeGetUsersHeaders() {
			ExtentReport.extentLog=ExtentReport.extentReport.startTest("Validate Get Users End Point Headers","Validate Status Code for Get Users EndPoint for Headers");	
			Response resp=given().header("content-type", "application/json")
							.when().get("https://reqres.in/api/users");
			
			int actualStatusCode=resp.statusCode();
			Assert.assertEquals(actualStatusCode, 200);
			System.out.println("***************"+resp.body().asString()+"***************");
		}
		
		@Test(description="Validate status code for Get Users using PathParam",groups="RegressionSuite")
		public void ValidateStatusCodePathParams() {
			ExtentReport.extentLog=ExtentReport.extentReport.startTest("Validate Get Users End Point Path Param","Validate Status Code for Get Users EndPoint for Path Param");	
			String sampleValue="2017";
			Response resp=given().pathParam("sample",sampleValue)
							.when().get("http://ergast.com/api/f1/{sample}/circuits.json");
			
			int value=resp.getStatusCode();
			Assert.assertEquals(value, 200);
			System.out.println(resp.body().asString());
		}
		
	//Hell

}
