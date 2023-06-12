package com.Apollo.Pages;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobDetailsPage {
	
	WebDriver driver;
	
	@FindBy(tagName="body")
	WebElement jobContent;
	@FindBy (xpath="//a[text()='Apply Now']")
	WebElement applyBtn;
	
	public JobDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void copyJobSpecData() throws IOException {
		
		String pageContent=jobContent.getText();
		//store the data in text file
		String TestFile = "C:\\Users\\vijayalaxmi.rajaa\\OneDrive - HCL Technologies Ltd\\Documents\\JobDetails.txt";
		File FC = new File(TestFile);//Created object of java File class.
		FC.createNewFile();

		FileWriter FW = new FileWriter(TestFile);
		BufferedWriter BW = new BufferedWriter(FW);

		BW.write(pageContent);
        BW.close();	
		
	}
	
	public void clickApplyNow() {
		
		applyBtn.click();
		
	}
	

}
