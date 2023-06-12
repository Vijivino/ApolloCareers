package com.Apollo.Pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ApplicationPage {

	WebDriver driver;

	@FindBy (id="fname")
	WebElement fName;
	@FindBy (id="email_id")
	WebElement email;
	@FindBy (id="mobile")
	WebElement mobileNo;
	@FindBy (id="gender")
	WebElement genderDropdown;
	@FindBy (id="dob")
	WebElement DOB;
	@FindBy (id="preffered_location")
	WebElement locDropDwn;
	@FindBy (id="highest_qualification")
	WebElement qualifDropdwn;
	@FindBy (id="apply_job")
	WebElement nextBtn;
	@FindBy(xpath="//small[@class='error']")
	WebElement error;






	public ApplicationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterMandatoryFields(String fullname,String emailid,String mobNo,String gender,String qualification) {

		fName.sendKeys(fullname);
		email.sendKeys(emailid);
		mobileNo.sendKeys(mobNo);

		Select sel2=new Select(genderDropdown);
		sel2.selectByVisibleText(gender);

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value='03-19-1994'", DOB);

		Select sel3=new Select(locDropDwn);
		sel3.selectByIndex(5);

		Select sel1=new Select(qualifDropdwn);
		sel1.selectByVisibleText(qualification);
	
	}
	
	public void TakeScreensnap() {
		
		File source1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\ApolloCareers\\Screenshots\\ValidSnap.png";
		try {
			FileUtils.copyFile(source1, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String checkLengthMobile() {
		String length = mobileNo.getAttribute("maxlength");
		return length;
	}

	public void clickNext() {
		nextBtn.click();
		
		File source1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\ApolloCareers\\Screenshots\\Snap2.png";
		try {
			FileUtils.copyFile(source1, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean verifyMsg() {

		boolean displayed = error.isDisplayed();
		return displayed;

	}



}
