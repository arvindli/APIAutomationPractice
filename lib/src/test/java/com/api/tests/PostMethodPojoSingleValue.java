package com.api.tests;
import com.api.util.*;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import io.restassured.response.Response;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.pojo.Cars;
import com.api.pojo.PojoClass;
import com.api.util.Helper;
import com.api.util.ReadTestData;

public class PostMethodPojoSingleValue {
	
	@Test(description="Pojo class with POST method")
	public void ValidateStatusCodePojoClass() {
		
		//Scenario#1-->Create object of class Cars pojo which is created for HashMap values ffor Cars in .json data file
		Cars carzMaruti=new Cars();
		carzMaruti.setBrand("Maruti");
		carzMaruti.setModel("Ciaz");
		
		Cars carzTata=new Cars();
		carzTata.setBrand("Tata");
		carzTata.setModel("Nexon");
		
		Cars carzHuyndai=new Cars();
		carzHuyndai.setBrand("Huyndai");
		carzHuyndai.setModel("Creta");
		
		//Step#2-->Create List inteface object and pass all above variables to newly created list interface
		List<Cars> lst1=new ArrayList<Cars>();
		lst1.add(carzHuyndai);
		lst1.add(carzTata);
		lst1.add(carzMaruti);
		
		
		
		//Scenario#2-->where need to create List of object and pass multiple values through Pojo class
		List<String> lst=new ArrayList<String>();
		lst.add("Tester");
		lst.add("Developer");
		lst.add("Support");
		
		//Final step where creating object of class and passing it as request body parameter 
		PojoClass pojorv=new PojoClass();
		pojorv.setName("morpheus");
		pojorv.setJob("leader");
		pojorv.setJobs(lst);
		pojorv.setCarss(lst1);
		
		Response resp=given().header("Content-Type","application/json")
						.body(pojorv)
						.when().post("https://reqres.in/api/users");
		
		int stat=resp.getStatusCode();
		Assert.assertEquals(stat, 201);
		System.out.println("**********"+resp.body().asString()+"**************");
	}

	@Test(description="Validate PUT method for POJO class")
	public void ValidatePUTmethod() {
		
		PojoClass pj=new PojoClass();
		pj.setName("morpheus");
		pj.setJob("zion resident");
		
		Response resp=given().header("Content-Type","application/json")
					.body(pj)
					.when().put("https://reqres.in/api/users/2");
		
		int statusCode=resp.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@Test(description="Validate PUT method for POJO class")
	public void ValidatePATCHmethod() {
		
		PojoClass pj=new PojoClass();
		pj.setName("morpheus");
		pj.setJob("zion resident");
		
		Response resp=given().header("Content-Type","application/json")
					.body(pj)
					.when().patch("https://reqres.in/api/users/2");
		
		int statusCode=resp.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
}
