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
	public static Logger log=LogManager.getLogger(CartPageTest.class.getName());

	public CartPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		log.info("======Starting CartPage Test========");
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
			log.info("Successfully Searched the product!");

		}else {
			throw new Exception("Coudn't search product!");
		}

		productpage=searchpage.choos1stProductAndClick();
		if(productpage!=null) {
			log.info("Traversed to product page");
		}
		else {
			throw new Exception("traversal to productpage failed!");
		}
		cart=productpage.addProductToCart();
		if(cart!=null) {
			log.info("Traversed to cart page");
		}
		else {
			throw new Exception("traversal to cart failed!");
		}
	}

	@Test(priority=1)
	public void ScreenshotCartPage() throws Exception {
		if(cart.verifyCart()) {
			log.info("Taking Screenshot!");
			cart.takeCartScreenshot();
		}else {
			log.error("Not in cart Page! Not taking screenshot!");
			Assert.fail("Not in cart Page! Not taking screenshot!");
			throw new Exception("Not in cart Page! Not taking screenshot!");
		}

	}

	@Test(priority=2)
	public void removeFromCart() throws Exception {
		if(cart.verifyCart()) {
			log.info("In cart Page:verified!");
			log.info("Cart size="+cart.returnCartSize());
			if(cart.returnCartSize()==1) {
				
				log.info("No.of products in cart=1");
				cart.clickRemove();
				log.info("Removed 1 product!");
				log.info("Verifying cart message!");
				String msg=cart.CartMsg();
				log.info("Cart message="+msg);
				Assert.assertEquals(msg, prop.getProperty("emptyCartMsg"));
				log.info("Carts message matched!");
			}
			else if(cart.returnCartSize()>1) {
				log.info("No.of products in cart="+cart.returnCartSize());
				cart.clickRemove(1);
				log.info("Removed 1st product!");
			}
			else {
				log.error("Cart is empty");
				throw new Exception("Cart is empty");
			}

		}
		else {
			log.error("Not in cart page!");
			Assert.fail("Not in cart page!");
			throw new Exception("Not in cart page!");

		}

	}




	@Test(priority=3)
	public void logoutfromAppinCart() {
		log.info("Searching logout button!");
		cart.Logout();
		Assert.assertTrue(cart.verifyLogout());
		log.info("Logout Verified!");
	}


	@AfterMethod
	public void teardown() {
		log.info("Closing browser...");
		driver.quit();
		log.info("Browser closed!");

	}


}
