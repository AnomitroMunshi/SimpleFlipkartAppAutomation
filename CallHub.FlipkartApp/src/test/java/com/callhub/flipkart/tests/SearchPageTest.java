package com.callhub.flipkart.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.callhub.flipkart.base.Driver;
import com.callhub.flipkart.pages.Homepage;
import com.callhub.flipkart.pages.LoginPage;
import com.callhub.flipkart.pages.Productpage;
import com.callhub.flipkart.pages.SearchPage;
import com.callhub.flipkart.util.PageScroll;

public class SearchPageTest extends Driver {

	Homepage homepage;
	SearchPage searchpage;
	LoginPage loginPage;
	Productpage productpage;
	List<WebElement> list1=new ArrayList<WebElement>();
	public static Logger log=LogManager.getLogger(SearchPageTest.class.getName());
	
	public SearchPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		log.info("Initializing Drivers");
		initialize();
		log.info("Driver loaded!");
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
			log.info("Traversed to search page");
		}
		else {
			throw new Exception("Search Page Traversal failed!");
		}
	}
	
	@Test(priority=1)
	public void countProductsOnPageinSearchPage() throws InterruptedException {
		List<WebElement> l=searchpage.returnProductCount();
		list1.addAll(l);
		searchpage.nextpage();
		log.info("Choosing 1st product of 2nd page");
		list1.add(searchpage.choos1stProduct());
		log.info("total selected items: "+list1.size());
		Assert.assertEquals(Integer.toString(list1.size()),prop.getProperty("productCount"));
		log.info("Verified product count");
		
	}
	
	@Test(priority=2)
	public void clickonProductinSearchPage() {
		productpage=searchpage.choos1stProductAndClick();
	}
	
	@AfterMethod
	public void teardown() {
		log.info("Closing browser..");
		driver.quit();
		log.info("Browser closed!");
	}
}
