package com.Apollo.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy (xpath="//span[text()='×']")
	WebElement videocloseBtn;
	@FindBy(id="state_id")
	WebElement state;
	@FindBy (id="city_id")
	WebElement city;
	@FindBy(id="area_id")
	WebElement area;
	@FindBy (id="selectProfile")
	WebElement profile;
	@FindBy(xpath="//button[text()='Search Job']")
	WebElement searchBtn;
	@FindBy(xpath="//span[text()='View Details']")
	WebElement viewDetailsBtn;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void closeAd() {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(videocloseBtn));
		videocloseBtn.click();
	}
	
	public void selectLocation() throws InterruptedException {
		
		Select sel=new Select(state);
	    sel.selectByVisibleText("TAMILNADU");
	    Thread.sleep(1000);
		
	    Select sel1=new Select(city);
		 sel1.selectByVisibleText("CHENNAI");
		
		 Select sel2=new Select(area);
		 sel2.selectByVisibleText("ADYAR");
		
		 Select sel3=new Select(profile);
		sel3.selectByIndex(2);
		
	}
	
	public void clickSearch() {
		
		searchBtn.click();
		viewDetailsBtn.click();
	}
	

}
