package com.callhub.flipkart.pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.callhub.flipkart.base.Driver;


public class Productpage extends Driver{
	public static Logger log=LogManager.getLogger(Productpage.class.getName());
	@FindBy(xpath="//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	WebElement addToCart;
	
	public Productpage() {
		PageFactory.initElements(driver, this);
	}

	public CartPage addProductToCart() throws InterruptedException {
		log.info("Adding product to cart!");
		addToCart.click();
		log.info("Waiting for adding to cart");
		Thread.sleep(3000);
		log.info("Traversing to cart page....");
		
		return new CartPage();
		
	}
	
}
