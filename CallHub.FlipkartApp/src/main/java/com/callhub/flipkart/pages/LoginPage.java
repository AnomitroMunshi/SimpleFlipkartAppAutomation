package com.callhub.flipkart.pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.callhub.flipkart.base.Driver;

public class LoginPage extends Driver {
	public static Logger log=LogManager.getLogger(LoginPage.class.getName());
	
	@FindBy(xpath="//span[contains(text(),'CONTINUE')]")
	WebElement conti;
	
	@FindBy(xpath="//button[contains(text(),'Login with Password')]")
	WebElement loginwithpass;
	
	@FindBy(xpath="//input[@class='_2zrpKA']")
	WebElement email;
	
	@FindBy(xpath="//input[@class='_2zrpKA _3v41xv']")
	WebElement password;
	
	@FindBy(xpath="//button[@class='_2AkmmA _1LctnI _7UHT_c']")
	WebElement loginButton;
	
	public LoginPage() {
		log.info("initializing driver");
		PageFactory.initElements(driver, this);
	}
	
	public Homepage LoginToHome(String username,String pass) {
		log.info("Inside Login");
		log.info("clicking on email");
		email.click();
		log.info("clicked");
		log.info("Typing in username");
		email.sendKeys(username);
		try {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			conti.click();
			loginwithpass.click();
			password.click();
			password.sendKeys(pass);
		}
		catch(NoSuchElementException e) {
			System.out.println("Insode else");
			password.click();
			password.sendKeys(pass);
		}
		loginButton.click();
		return new Homepage();
		
	}

}
