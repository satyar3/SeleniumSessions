package com.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAndSoftAssertion {

	SoftAssert softassert = new SoftAssert(); //creating objecting of SoftAssert
	
	//Hard Assertion - Is failed means, next corresponding won't be executed and immediately test case will be terminated and marked as failed
	//soft assertion - Is failed means, next corresponding will be executed and test will be counted to execte 
	@Test
	public void test1()
	{
		System.out.println("Open browser");
		Assert.assertEquals(true, true); //hard assertion
		
		System.out.println("enter username");
		System.out.println("enter password");
		System.out.println("click on sign in button");
		Assert.assertEquals(true, true); //hard assertion
		
		System.out.println("validate home page");
		softassert.assertEquals(true, true); //soft assertion
		
		System.out.println("go to deals page");
		System.out.println("create a deal");
		softassert.assertEquals(true, false,"Unable to create a deal"); //soft assertion
		
		System.out.println("go to contact page");
		System.out.println("craete a contact");
		softassert.assertEquals(true, false ,"Unable to create a contact"); //soft assertion
		
		softassert.assertAll(); //Once all the soft assertion is done, assertAll() will check how many steps are failed, then it'll mark the test case as fail
								//if assertAll() is not present, then test case won't be failed even if test steps are failed.
	}
}
