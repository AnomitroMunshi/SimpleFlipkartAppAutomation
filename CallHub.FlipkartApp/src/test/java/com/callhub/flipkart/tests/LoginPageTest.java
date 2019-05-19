package com.callhub.flipkart.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.callhub.flipkart.base.Driver;
import com.callhub.flipkart.pages.Homepage;
import com.callhub.flipkart.pages.LoginPage;


public class LoginPageTest extends Driver {
	LoginPage loginPage;
	Homepage homepage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialize();
		loginPage = new LoginPage();	
	}
	
	@Test(priority = 1)
	public void verifyLogin() {

		homepage=loginPage.LoginToHome(prop.getProperty("email"), prop.getProperty("pass"));
	}

	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}
