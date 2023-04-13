package com.api.util;

import java.lang.reflect.Constructor;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;

import io.restassured.http.Method;

public class RetryListner implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation testannotation, Class testClass, Constructor testConstructor,
			java.lang.reflect.Method testMethod) {
		 IRetryAnalyzer retry = testannotation.getRetryAnalyzer();

	        if (retry == null)    {
	            testannotation.setRetryAnalyzer(FailRetry.class);//pass the class name created in Step-1
	        }
		
	}

   
}