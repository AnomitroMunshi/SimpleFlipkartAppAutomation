package com.callhub.flipkart.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.callhub.flipkart.base.Driver;
import com.callhub.flipkart.util.TestUtil;

public class CartPage extends Driver {
	
	@FindBy(xpath="//span[contains(text(),'Remove')]")
	WebElement removeButton;
	
	@FindBy(xpath="//span[@class='_61Ylla']")
	WebElement emptyCartMsg;
	
	@FindBy(xpath="//div[@class='dHGf8H']")
	WebElement target;

	@FindBy(xpath="//*[contains(text(),'Logout')]")
	WebElement logoutOption;
	
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement loginButton;
	
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
	
	public void Logout() {
		Actions a =new Actions(driver);
		a.moveToElement(target).build().perform();
		a.moveToElement(logoutOption).click().build().perform();
	}
	
	public boolean verifyLogout() {
		if(loginButton.isDisplayed())
			return true;		
		return false;
	}
		
	
	
}
