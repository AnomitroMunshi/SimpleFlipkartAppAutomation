package com.callhub.flipkart.pages;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.callhub.flipkart.base.Driver;

import com.callhub.flipkart.util.TestUtil;

public class CartPage extends Driver {
	
	public static Logger log=LogManager.getLogger(CartPage.class.getName());
	
	@FindBy(xpath="//*[@class='_3ycxrs'][1]/child::div[@class='_3cto0P']/child::div[2]/child::div[2]/span[contains(text(),'Remove')]")
	WebElement removeButton;
	
	@FindBy(xpath="//span[@class='_61Ylla']")
	WebElement emptyCartMsg;
	
	@FindBy(xpath="//div[@class='dHGf8H']")
	WebElement target;

	@FindBy(xpath="//*[contains(text(),'Logout')]")
	WebElement logoutOption;
	
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement loginButton;
	
	@FindBy(xpath="//*[@class='_3ycxrs']/child::div[@class='_3cto0P']/child::div[2]/child::div[2]/span[contains(text(),'Remove')]")
	List<WebElement> cartlist;
	
	
	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickRemove() {
		log.info("Remove button clicked");
		removeButton.click();
	}
	
	public void clickRemove(int num) {
		log.info("To remove 1st product. Removing.....");
		
		cartlist.get(num-1).click();
		log.info("Remove button clicked.");
	}
	
	public void takeCartScreenshot() throws IOException {
		log.info("Traversing to testUtil class..");
		
		TestUtil.CaptureScreenshot();
	}
	
	public boolean verifyCart(){
		String title=driver.getTitle();
		log.info("Title of the page="+title);
		if(title.equals(prop.getProperty("cartPageTitle"))) {
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
		log.info("logout clicked");
		
	}
	
	public boolean verifyLogout() {
		log.info("Verifying Login Button");
		if(loginButton.isDisplayed())
			return true;		
		return false;
	}
	
	public int returnCartSize() {
		log.info("There are "+cartlist.size()+" products in the cart");
		return cartlist.size();
	}
	
	
}
