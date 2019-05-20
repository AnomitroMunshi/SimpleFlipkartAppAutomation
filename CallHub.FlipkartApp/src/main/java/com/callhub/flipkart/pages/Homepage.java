package com.callhub.flipkart.pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.callhub.flipkart.base.Driver;
import com.callhub.flipkart.util.TestUtil;


public class Homepage extends Driver{

	public static Logger log=LogManager.getLogger(Homepage.class.getName());
	
	@FindBy(xpath="//div[@class='_1jA3uo'][1]/child::div[1]/child::div[1]/child::span[1]/child::div[@class='_2aUbKa'][1]")
	WebElement signerName;
	
	@FindBy(xpath="//input[@placeholder='Search for products, brands and more']")
	WebElement searchBox;
	
	@FindBy(xpath="//button[@class='vh79eN']")
	WebElement searchButton;
	
	public Homepage(){
		PageFactory.initElements(driver, this);
				
	}
	
	
	public String getTitle() {
		log.info("Title found! Returning to HomePageTest");
		return driver.getTitle();
	}
		
	public boolean validateCorrectProfile(String s) {
		String name=driver.findElement(By.xpath("//div[contains (text(),'"+s+"')]")).getText();
			
			log.info("UserName found->"+name);
			log.info("Username expected->"+s);
			if(s.equals(name)) {
				log.info("Username matched!");
				return true;
			}
			else {
				log.info("Username mismatch.");
				return false;
			}
	}
	
	public SearchPage Search(String product) throws InterruptedException  {
		
		log.info("Product to search->"+product+". Typing "+product+" in search box.");
		searchBox.sendKeys(product);
		log.info("ImplicitWaiting");
		log.info("Pressing Enter Key");
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		return new SearchPage();
		
	}

}
