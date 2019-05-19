package com.callhub.flipkart.tests;

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

	public ProductpageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialize();
		loginPage=new LoginPage();
		homepage=loginPage.LoginToHome(prop.getProperty("email"), prop.getProperty("pass"));
		searchpage=homepage.Search(prop.getProperty("toSearch"));
		productpage=searchpage.choos1stProductAndClick();
	}

	@Test
	public void verifyCartAddition() throws InterruptedException {
		cart=productpage.addProductToCart();
		
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
}
