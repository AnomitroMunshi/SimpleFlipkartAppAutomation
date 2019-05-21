package com.callhub.flipkart.pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;

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
	
	@FindBy(xpath="//*[@class='ZAtlA-']")
	WebElement errorLabel;
	
	public LoginPage() {
		log.info("initializing driver");
		PageFactory.initElements(driver, this);
	}
	
	public Homepage LoginToHome(String username,String pass) throws Exception {
		
		log.info("clicking on email");
		email.click();
		log.info("clicked");
		log.info("Typing username");
		email.sendKeys(username);
		try {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			
			conti.click();
			log.info("Continue button Found! Clicking Continue!");
			loginwithpass.click();
			log.info("Clicking Login with Password");
			password.click();
			password.sendKeys(pass);
			log.info("Password typed");
		}
		catch(NoSuchElementException e) {
			log.info("Exception thrown: Continue button not present. Proceeding with normal login. ");
			password.click();
			password.sendKeys(pass);
			log.info("Password entered.");
		}
		loginButton.click();
		log.info("Login button clicked.");
		
		try {
		if(!errorLabel.isDisplayed()) {	
			log.info("Username and Password verified!..Loading HomePage...");
			return new Homepage();
		}
		else {
			log.error("Your username or password is incorrect");
			throw new Exception("Your username or password is incorrect");
		}
		}catch(NoSuchElementException e) {
			log.info("Username and Password verified!..Loading to HomePage.");
			return new Homepage();
		}
	}

}
