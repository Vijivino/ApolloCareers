package com.Apollo.Pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ExperienceDetailsPage {

	WebDriver driver;


	@FindBy(id="aadhaar_num")
	WebElement aadharNo;
	@FindBy (id="resume")
	WebElement upload;
	@FindBy(id="referral_type")
	WebElement refDropdwn;
	@FindBy(id="total_experience")
	WebElement totalExp;
	@FindBy(id="retail_experience")
	WebElement retailExp;
	@FindBy(id="exampleCheck1")
	WebElement checkox;
	@FindBy(id="apply_job")
	WebElement submit;
	@FindBy(xpath="//small[@class='error']")
	WebElement error;


	public ExperienceDetailsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enterExpDetails(String aadNo,String Expyear,String retailYear) throws InterruptedException {
		aadharNo.sendKeys(aadNo);
		Select sel=new Select(refDropdwn);
		sel.selectByIndex(2);
		upload.sendKeys("C:\\Users\\vijayalaxmi.rajaa\\OneDrive - HCL Technologies Ltd\\Documents\\SDET.pdf");
		Select sel1=new Select(totalExp);
		sel1.selectByVisibleText(Expyear);
		Select sel2=new Select(retailExp);
		sel2.selectByVisibleText(retailYear);

		checkox.click();

	}

	public void clickSubmit() {
		submit.click();
		File source1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path="C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\ApolloCareers\\Screenshots\\Snap1.png";
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
