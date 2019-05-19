package com.callhub.flipkart.util;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.callhub.flipkart.base.Driver;



public class PageScroll {

	//Scrolls till the bottom of page
	public static void toBottomOfPage()
	{
		try {
		    long Height =Long.parseLong(((JavascriptExecutor) Driver.driver).executeScript("return document.body.scrollHeight").toString());

		    while (true) {
		        ((JavascriptExecutor) Driver.driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
		        Thread.sleep(500);

		        long newHeight = Long.parseLong(((JavascriptExecutor) Driver.driver).executeScript("return document.body.scrollHeight").toString());
		        if (newHeight == Height) {
		            break;
		        }
		        Height = newHeight;
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}
	//Scrolls to top of page
	public static void toUP()
	{
		    
		     ((JavascriptExecutor) Driver.driver).executeScript("window.scrollTo(document.body.scrollHeight,0);");
	
	}
	//Scrolls till element view
	public static void toElement(WebElement element)
	{
		((JavascriptExecutor) Driver.driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
}
