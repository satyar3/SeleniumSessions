package com.testng;

import org.testng.annotations.Test;

public class InvocationCountTest {
	
	//If we want to execute the same test case for 10 times
	
	@Test(invocationCount=10)
	public void sum()
	{
		int a = 10;
		int b = 20;
		int c = a+b;
		System.out.println(c);
	}

}
