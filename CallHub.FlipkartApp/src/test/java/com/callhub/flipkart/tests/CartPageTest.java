package com.callhub.flipkart.tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TakesScreenshot;
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
import com.callhub.flipkart.util.TestUtil;


public class CartPageTest extends Driver{
	LoginPage loginPage;
	Homepage homepage;
	SearchPage searchpage;
	Productpage productpage;
	CartPage cart;
	public static Logger log=LogManager.getLogger(Driver.class.getName());

	public CartPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialize();
		log.info("Driver loaded!");
		loginPage=new LoginPage();
		homepage=loginPage.LoginToHome(prop.getProperty("email"), prop.getProperty("pass"));
		searchpage=homepage.Search(prop.getProperty("toSearch"));
		productpage=searchpage.choos1stProductAndClick();
		cart=productpage.addProductToCart();
	}
	
	@Test(priority=1)
	public void ScreenshotPage() throws IOException {
		cart.takeCartScreenshot();
	
	}
	
	@Test(priority=2)
	public void removeFromCart() {
		if(cart.verifyCart())
			cart.clickRemove();
		
		String msg=cart.CartMsg();
		Assert.assertEquals(msg, prop.getProperty("emptyCartMsg"));
	}
	
	@Test(priority=3)
	public void logoutfromApp() {
		cart.Logout();
		Assert.assertTrue(cart.verifyLogout());
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}
	

}
