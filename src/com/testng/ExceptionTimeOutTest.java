package com.testng;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest {
	
	
	@Test(timeOut=2000) //test case should be executed within 2 secs.
	public void infiniteLoopTest()
	{
		int i = 1;
		while(i==1)
		{
			System.out.println(i);
		}
	}
	@Test(expectedExceptions=NumberFormatException.class) //expectedExceptions - test case won't be failed if the expectedExceptions criteria meets
	public void test1()
	{
		String x = "100A";
		int a = Integer.parseInt(x);
	}
	
}
