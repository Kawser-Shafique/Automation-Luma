package com.regression;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SmokeTestWithTestNG {
	// method name => alphabetic order => big problem
	// priority => ignore alphabetic order
	@BeforeTest 
	public void setup() {
		System.out.println("Before test : All setup code");
	}
	@Test (priority = 0)
	public void test1() {
		System.out.println("First test");
	}
	@Test (priority = 1, enabled = false)
	public void test2() {
		System.out.println("Second test");
	}
	@Test (priority = 2, enabled = false)
	public void test3() {
		System.out.println("Third test");
	}
	@AfterTest
	public void teardown() {
		System.out.println("After Test : close connection");
	}
}
