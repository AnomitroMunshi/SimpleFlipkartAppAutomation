package com.callhub.flipkart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.callhub.flipkart.base.Driver;
import com.callhub.flipkart.pages.Homepage;
import com.callhub.flipkart.pages.LoginPage;
import com.callhub.flipkart.pages.SearchPage;

public class HomepageTest extends Driver {
	LoginPage login;
	Homepage homepage;
	SearchPage searchpage;
	public static Logger log=LogManager.getLogger(HomepageTest.class.getName());

	public HomepageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		log.info("======Starting HomePage Test!=========");
		log.info("Initializing Drivers");
		initialize();
		log.info("Driver loaded! Traversing to LoginPage!");
		login=new LoginPage();
		log.info("login page initialized");
		try{
			homepage=login.LoginToHome(prop.getProperty("email"), prop.getProperty("pass"));
			if(homepage!=null) {
				log.info("Successfully Logged in! Loading to homepage.");
				}
			}catch(Exception e) {
				log.error("Login failed!");
			}
		
	}

	@Test(priority=1)
	public void verifyHomePageTitileTest() {
		log.info("verifying HomePageTitle");
		String title = homepage.getTitle();
		log.info("Found homePageTitle->"+title);
		Assert.assertEquals(title,prop.getProperty("homePageTitle"));
		log.info("Title Verified!");
	}

	

	@Test(priority=2)
	public void verifyHomepageCorrectSignIn() {
		log.info("Verifying username");
		boolean result = homepage.validateCorrectProfile(prop.getProperty("Checkname"));
		Assert.assertTrue(result);
		log.info("Username Verified!");
	}

	@Test(priority=3)
	public void searchProductFromHomepage() throws InterruptedException {
		log.info("typing product name in search bar.....");
		searchpage=homepage.Search(prop.getProperty("toSearch"));
		try {
			if(searchpage!=null) {
				log.info("Traversed to search Page!");
				String newTitle=homepage.getTitle();
				log.info("New Title of the page->"+newTitle);
				Assert.assertEquals(newTitle, prop.getProperty("SearchPageTitle"));
				log.info("Title Matched!");
				log.info("Successfully Searched the product!");
			}
		}catch(Exception e) {
			log.error("Search failed!");
			Assert.fail("Search failed!");
			
		}

	}

	@AfterMethod
	public void teardown() {
		log.info("Closing browser...");
		 driver.close();
		 log.info("Browser closed!");
	}
}
