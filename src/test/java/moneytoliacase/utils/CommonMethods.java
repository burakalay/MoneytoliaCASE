package moneytoliacase.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import moneytoliacase.testbase.BaseClass;
import moneytoliacase.testbase.PageInitializer;


public class CommonMethods extends PageInitializer{

	
	
	
	
	
	
	
	/**
	 * This method takes a screenshot using the provided fileName
	 * 
	 * @param fileName
	 */
	
	
	/**
	 * This method takes a screenshot using the provided fileName
	 * 
	 * @param fileName
	 */
	public static byte[] takeScreenshot(String fileName) {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File sourceFile = ts.getScreenshotAs(OutputType.FILE);

		String destination = Constant.SCREENSHOT_FILEPATH + fileName + getTimeStamp() + ".png";

		try {
			FileUtils.copyFile(sourceFile, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);
		return picBytes;
	}

	/**
	 * This method returns the timestamp in a String format
	 * 
	 * @return
	 */
	public static String getTimeStamp() {
		Date date = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

		return sdf.format(date);
	}

}
	
	
	
	

