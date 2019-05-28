package com.callhub.flipkart.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.callhub.flipkart.base.Driver;
import com.callhub.flipkart.pages.CartPage;
import com.callhub.flipkart.pages.Homepage;
import com.callhub.flipkart.pages.LoginPage;
import com.callhub.flipkart.pages.Productpage;
import com.callhub.flipkart.pages.SearchPage;

public class ProductpageTest extends Driver {
	
	Homepage homepage;
	SearchPage searchpage;
	LoginPage loginPage;
	Productpage productpage;
	CartPage cart;
	public static Logger log=LogManager.getLogger(ProductpageTest.class.getName());

	public ProductpageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws Exception {
		log.info("======Starting ProductPage Test========");
		log.info("Initializing Drivers");
		initialize();
		log.info("Driver loaded Traversing to LoginPage!");
		loginPage=new LoginPage();
		homepage=loginPage.LoginToHome(prop.getProperty("email"), prop.getProperty("pass"));
		try{
			//homepage=loginPage.LoginToHome(prop.getProperty("email"), prop.getProperty("pass"));
			if(homepage!=null) {
				log.info("Successfully Logged in! Loading to homepage.");
			}
		}catch(Exception e) {
			log.error("Login failed!");
		}
		searchpage=homepage.Search(prop.getProperty("toSearch"));
		if(searchpage!=null) {
			log.info("Successfully Searched the product!");

		}else {
			throw new Exception("Coudn't search product!");
		}
		productpage=searchpage.choos1stProductAndClick();
		if(productpage!=null) {
			log.info("Traversed to product page");
		}
		else {
			throw new Exception("Traversal to productpage failed!");
		}
	}

	@Test
	public void verifyCartAdditionfromProductPage() throws InterruptedException {
		
		cart=productpage.addProductToCart();
		
	}
	
	
	@AfterMethod
	public void teardown() {
		log.info("Closing browsers...");
		driver.quit();
		log.info("both browsers closed!");
		
	}
}
