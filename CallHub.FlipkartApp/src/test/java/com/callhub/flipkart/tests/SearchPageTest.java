package com.callhub.flipkart.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	
	public SearchPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialize();
		loginPage=new LoginPage();
		homepage=loginPage.LoginToHome(prop.getProperty("email"), prop.getProperty("pass"));
		searchpage=homepage.Search(prop.getProperty("toSearch"));
	}
	
	@Test(priority=1)
	public void countProductsOnPage() throws InterruptedException {
		List<WebElement> l=searchpage.returnProductCount();
		list1.addAll(l);
		searchpage.nextpage();
		list1.add(searchpage.choos1stProduct());
		System.out.println(list1.size());
		Assert.assertEquals(Integer.toString(list1.size()),prop.getProperty("productCount"));
		
	}
	
	@Test(priority=2)
	public void clickonProduct() {
		productpage=searchpage.choos1stProductAndClick();
	}
	
	@AfterMethod
	public void teardown() {
		driver.close();
		
	}
}
