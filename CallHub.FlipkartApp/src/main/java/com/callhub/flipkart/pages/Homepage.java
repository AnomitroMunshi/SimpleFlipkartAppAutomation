package com.callhub.flipkart.pages;

import java.util.concurrent.TimeUnit;

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
		return driver.getTitle();
	}
		
	public boolean validateCorrectProfile(String s) {
		String name=driver.findElement(By.xpath("//div[contains (text(),'"+s+"')]")).getText();
			System.out.println("name->"+name);
			if(s.equals(name))
				return true;
			else
				return false;
	}
	
	public SearchPage Search(String product) throws InterruptedException  {
		
		//TestUtil.toBeclickable(searchBox);
		searchBox.sendKeys(product);
		//driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		searchBox.sendKeys(Keys.ENTER);
		
		return new SearchPage();
		
	}

}
