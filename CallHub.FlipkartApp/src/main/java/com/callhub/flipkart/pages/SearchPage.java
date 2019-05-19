package com.callhub.flipkart.pages;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.callhub.flipkart.base.Driver;
import com.callhub.flipkart.util.PageScroll;
import com.callhub.flipkart.util.TestUtil;

public class SearchPage extends Driver {
	
	@FindBy(xpath="//*[@class='bhgxx2 col-12-12']/child::div[@class='_3O0U0u']/child::div/child::div/child::a/child::div[@class='_1-2Iqu row']/child::div[1]/child::div[1]")
	List<WebElement> ProductList;
	
	@FindBy(xpath="//*[@class='bhgxx2 col-12-12'][1]/child::div[@class='_3O0U0u']/child::div/child::div/child::a/child::div[@class='_1-2Iqu row']/child::div[1]/child::div[1]")
	WebElement firstProduct;
	
	@FindBy(xpath="//a[@class='_2Xp0TH'][contains(text(),'2')]")
	WebElement tonextpage;
	
	@FindBy(xpath="//span[@class='_3YmFT8']")
	WebElement topelement;
	
	public SearchPage(){
		PageFactory.initElements(driver, this);
				
	}
	
	public List<WebElement> returnProductCount() throws InterruptedException {
		
		
		PageScroll.toBottomOfPage();
		PageScroll.toUP();
		List<WebElement> list=ProductList;
		return list;
	}
	
	public WebElement choos1stProduct() {
		
		return firstProduct;
	}
	
public Productpage choos1stProductAndClick() {
		
		firstProduct.click();
		String MainWindow=driver.getWindowHandle();	
		Set<String> s=driver.getWindowHandles();
		 Iterator<String> i1=s.iterator();		
 		 while(i1.hasNext())			
	        {	String ChildWindow=i1.next();		
	            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
	            	{    		
	                    // Switching to Child window
	                    driver.switchTo().window(ChildWindow);
	            	}
	        }
		return new Productpage();
	}
	
	public void nextpage() {
		 tonextpage.click();
	}
		
		
		
		
}


