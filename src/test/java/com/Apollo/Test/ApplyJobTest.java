package com.Apollo.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.Apollo.Base.Base;
import com.Apollo.Listeners.MyListeners;
import com.Apollo.Pages.ApplicationPage;
import com.Apollo.Pages.ConfirmPage;
import com.Apollo.Pages.ExperienceDetailsPage;
import com.Apollo.Pages.HomePage;
import com.Apollo.Pages.JobDetailsPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class ApplyJobTest extends Base{

	WebDriver driver;
	HomePage home;
	JobDetailsPage details;
	ApplicationPage apply;
	ExperienceDetailsPage exp;
	ConfirmPage confirm;


	@Test//(retryAnalyzer =com.Apollo.Utilities.RetryEngine.class)
	public void ApplyJobValid() throws InterruptedException, IOException {

		driver=launch();

		home=new HomePage(driver);
		home.closeAd();
		home.selectLocation();
		home.clickSearch();
		details=new JobDetailsPage(driver);
		details.copyJobSpecData();
		details.clickApplyNow();
		apply=new ApplicationPage(driver);
		apply.enterMandatoryFields(prop.getProperty("fullname"), prop.getProperty("emailid"), prop.getProperty("mobno"), prop.getProperty("gender"), prop.getProperty("qualification"));
		Assert.assertEquals("10", apply.checkLengthMobile());
		apply.TakeScreensnap();
		MyListeners.test.log(Status.PASS, "Mandatory fields are entered succesfully");
		MyListeners.test.log(Status.INFO, MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\ApolloCareers\\Screenshots\\ValidSnap.png").build());
		apply.clickNext();
		exp=new ExperienceDetailsPage(driver);
		exp.enterExpDetails(prop.getProperty("aadharno"), prop.getProperty("totalExp"), prop.getProperty("retailExp"));
		exp.clickSubmit();
		Assert.assertEquals(false, exp.verifyMsg());
		MyListeners.test.log(Status.PASS, "Validation message is verified using assertion");
		MyListeners.test.log(Status.INFO,MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\ApolloCareers\\Screenshots\\Snap1.png").build());

	}

	@Test(priority=1,retryAnalyzer = com.Apollo.Utilities.RetryEngine.class)
	public void ApplyJobInvalid() throws InterruptedException, IOException {

		driver=launch();

		home=new HomePage(driver);
		home.closeAd();
		home.selectLocation();
		home.clickSearch();
		details=new JobDetailsPage(driver);
		details.copyJobSpecData();
		details.clickApplyNow();
		apply=new ApplicationPage(driver);
		apply.enterMandatoryFields(prop.getProperty("fullname"), prop.getProperty("emailid"), prop.getProperty("mobNo"), prop.getProperty("gender"), prop.getProperty("qualification"));
		Assert.assertEquals("10", apply.checkLengthMobile());
		apply.clickNext();
		Assert.assertTrue(apply.verifyMsg());
		MyListeners.test.log(Status.PASS,"Assertion for Error message is verified");
		MyListeners.test.log(Status.INFO,MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\ApolloCareers\\Screenshots\\Snap2.png").build());

	}
	
	@AfterMethod
	public void getcreenshot(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("dd.MM.yy-HH.mm.ss").format(new Date());
		//File destination=new File("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\BendigoBank\\Screenshots\\"+testName+" "+timeStamp+".png");
		String path="C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\ApolloCareers\\Screenshots\\"+result.getName()+".png";
		try {
			FileUtils.copyFile(source, new File(path));
			
		} catch (IOException e) {
			e.printStackTrace();
		} 
		driver.quit();
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("dd.MM.yy-HH.mm.ss").format(new Date());
			//File destination=new File("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\BendigoBank\\Screenshots\\"+testName+" "+timeStamp+".png");
			String path="C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\ApolloCareers\\Screenshots\\"+result.getName()+".png";
			try {
				FileUtils.copyFile(source, new File(path));
			} catch (IOException e) {
				e.printStackTrace();
			} 
			driver.quit();
		}
	}


}
