package com.Apollo.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//h2[text()='APPLICATION SENT']")
	WebElement sentMsg;
	
	public ConfirmPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifySentMsg() {
		
		boolean displayed = sentMsg.isDisplayed();
		return displayed;
		
	}

}
