package com.Apollo.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Apollo.Base.Base;

public class Utils {

	
	public static String getScreenshot(WebDriver driver,String testName) {
		
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String timeStamp = new SimpleDateFormat("dd.MM.yy-HH.mm.ss").format(new Date());
		//File destination=new File("C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\BendigoBank\\Screenshots\\"+testName+" "+timeStamp+".png");
		String path="C:\\Users\\vijayalaxmi.rajaa\\eclipse-workspace\\ApolloCareers\\Screenshots\\"+testName+" "+timeStamp+".png";
		try {
			FileUtils.copyFile(source, new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return path;
	}

}
