package com.callhub.flipkart.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.callhub.flipkart.base.Driver;
import com.callhub.flipkart.util.TestUtil;

public class CartPage extends Driver {
	
	@FindBy(xpath="//span[contains(text(),'Remove')]")
	WebElement removeButton;
	
	@FindBy(xpath="//span[@class='_61Ylla']")
	WebElement emptyCartMsg;

	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickRemove() {
		removeButton.click();
	}
	
	public void takeCartScreenshot() throws IOException {
		TestUtil.CaptureScreenshot();
	}
	
	public boolean verifyCart(){
		String title=driver.getTitle();
		if(title.equals(prop.getProperty("cartPageTitle"))) {
			System.out.println(title);
			return true;
		}
		else
			return false;
	}
	
	public String CartMsg() {
		String msg="";
		if(emptyCartMsg.isDisplayed()) {
			msg=emptyCartMsg.getText();			
		}
		
		return msg;
	}
	
}
