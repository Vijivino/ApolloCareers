package com.Apollo.Listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Apollo.Base.Base;
import com.Apollo.Utilities.ExtentReporter;
import com.Apollo.Utilities.Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class MyListeners extends Base implements ITestListener{

	ExtentReports report;
	public static ExtentTest test;
	String testName;

	public void onStart(ITestContext context) {
		//creating report by calling the static method in utils package
		try {
			report = ExtentReporter.generateReport();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Execution of tests under the project ApolloCareers started");
	}

	public void onTestStart(ITestResult result) {  //result is the test
		testName = result.getName();
		test = report.createTest(testName);
		test.log(Status.INFO, testName+" Test started executing");
	}

	public void onTestSuccess(ITestResult result) {
	
		test.log(Status.PASS,MarkupHelper.createLabel(testName+" Test executed successfully!", ExtentColor.GREEN));	
		test.addScreenCaptureFromPath("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\ApolloCareers\\Screenshots\\"+result.getName()+".png");
	}

	public void onTestFailure(ITestResult result) {

		test.log(Status.FAIL, MarkupHelper.createLabel(testName+" Test got failed because of assertion failure.", ExtentColor.RED));
		
		test.log(Status.INFO, result.getThrowable());
		

		test.addScreenCaptureFromPath("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\ApolloCareers\\Screenshots\\"+result.getName()+".png");

	}

	public void onTestSkipped(ITestResult result) {

		test.log(Status.SKIP, MarkupHelper.createLabel(testName+" Test got skipped because of exceptions or errors.", ExtentColor.ORANGE));
		test.log(Status.INFO, result.getThrowable());

	}

	public void onFinish(ITestContext context) {

		report.flush();
		System.out.println("Completed the execution of all the tests in ApolloCareers project");
		
/*		//Launch the report automatically without refresh and open
		String ExtentReportPath=System.getProperty("user.dir")+"\\ExtentReports\\ExtentReport.html";
		File extentFilePath=new File(ExtentReportPath);		
		try {
			Desktop.getDesktop().browse(extentFilePath.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
*/	
	
	}

}
