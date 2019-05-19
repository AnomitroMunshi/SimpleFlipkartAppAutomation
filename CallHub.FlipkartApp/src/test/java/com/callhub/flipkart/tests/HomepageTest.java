package com.callhub.flipkart.tests;

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

	public HomepageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialize();
		login=new LoginPage();
		homepage = login.LoginToHome(prop.getProperty("email"), prop.getProperty("pass"));
	}

	@Test(priority=1)
	public void verifyHomePageTitileTest() {

		String title = homepage.getTitle();
		Assert.assertEquals(title,prop.getProperty("homePageTitle"));
	}

	

	@Test(priority=2)
	public void verifyCorrectSignIn() {
		boolean result = homepage.validateCorrectProfile(prop.getProperty("Checkname"));
		Assert.assertTrue(result);
	}

	@Test(priority=3)
	public void searchProduct() throws InterruptedException {
		searchpage=homepage.Search(prop.getProperty("toSearch"));

	}

	@AfterMethod
	public void teardown() {
		 driver.close();
	}
}
