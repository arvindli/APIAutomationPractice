package com.api.tests;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import io.restassured.response.Response;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.util.ReadTestData;

public class UseTestDataReadJson {
	
	@Test(description="Pull url from TestData.json file and pass as variable in request")
	public void ValidateStatusCodeFromJSON() throws Exception, ParseException {
		Response resp=given()
						.when().get(ReadTestData.GetTestData("uriGetUsers"));
		
		int actualStatusCode=resp.getStatusCode();
		Assert.assertEquals(actualStatusCode,200);
		System.out.println(resp.body().asString());
		
	}

	
	@Test(description="Pull email id from TestData.json file and pass in request using method")
	public void ValidateStatusCodeFromJson() throws IOException, ParseException {
		
		Response resp=given()
						.when().get(ReadTestData.GetTestData("uriGetUsers"));
		
		String actualEmail=resp.path("data[0].email");
		Assert.assertEquals(actualEmail, ReadTestData.GetTestData("Email"));
	}
}
