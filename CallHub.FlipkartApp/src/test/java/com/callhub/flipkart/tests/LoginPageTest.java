package com.callhub.flipkart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.callhub.flipkart.base.Driver;
import com.callhub.flipkart.pages.Homepage;
import com.callhub.flipkart.pages.LoginPage;

@Listeners(com.callhub.flipkart.listeners.Listener.class)
public class LoginPageTest extends Driver {
	LoginPage loginPage;
	Homepage homepage;
	public static Logger log=LogManager.getLogger(LoginPageTest.class.getName());
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		log.info("=======Starting Login Page Test========");
		log.info("Initializing Drivers");
		initialize();
		log.info("Driver loaded ... Traversing to Login Page");
		loginPage = new LoginPage();	
	}
	
	@Test
	public void LoginPageVerifyLogin() {
		log.info("Sending username and password to login page!");
		try{
			homepage=loginPage.LoginToHome(prop.getProperty("email"), prop.getProperty("pass"));
			if(homepage!=null) {
				log.info("Successfully Logged in!");
				}
			}catch(Exception e) {
				log.error("Login failed!");
				Assert.fail("Homepage=null");
		}
			
	}

	@AfterMethod
	public void tearDown(){
		log.info("Closing browser");
		driver.close();
		log.info("Browser closed");
	}
}
