package com.Apollo.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	

	public static ExtentReports generateReport() throws IOException {
		
		ExtentReports exReports=new ExtentReports();
		String timeStamp = new SimpleDateFormat("dd.MM.yyy-HH.mm.ss").format(new Date());
		File reportFile=new File(System.getProperty("user.dir")+"\\ExtentReports\\ExtentReport "+timeStamp+".html");
		//File reportFile=new File(System.getProperty("user.dir")+"\\ExtentReports\\ExtentReport.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(reportFile);
		//customize reports 
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Apollo Career Test Automation Result");
		sparkReporter.config().setDocumentTitle("Apollo Test Result");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		//attaching the customized sparkReport on exReport
		exReports.attachReporter(sparkReporter);
		
		
		exReports.setSystemInfo("Application URL ",("https://careers.apollopharmacy.app/") );
		exReports.setSystemInfo("Browser Name ",("Chrome"));
		
		//add some test environment info from the machine
		  //System.getProperties().list(System.out); //it will print all the properties with name
		exReports.setSystemInfo("Operating System ", System.getProperty("os.name"));
		exReports.setSystemInfo("UserName ", System.getProperty("user.name"));
		exReports.setSystemInfo("Java Version ", System.getProperty("java.version"));
		
		return exReports;	
		
	}

}
