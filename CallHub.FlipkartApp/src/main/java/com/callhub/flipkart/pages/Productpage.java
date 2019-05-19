package com.callhub.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.callhub.flipkart.base.Driver;

public class Productpage extends Driver{
	
	@FindBy(xpath="//button[@class='_2AkmmA _2Npkh4 _2MWPVK']")
	WebElement addToCart;
	
	public Productpage() {
		PageFactory.initElements(driver, this);
	}

	public CartPage addProductToCart() throws InterruptedException {
		addToCart.click();
		Thread.sleep(2000);
		return new CartPage();
		
	}
	
}
