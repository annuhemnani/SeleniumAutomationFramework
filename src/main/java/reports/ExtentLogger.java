package reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.tmb.driver.DriverManager;

public class ExtentLogger {

	public static void pass(String message){
		
		ExtentManager.getExt().pass(message);
	}

	public static void fail(String message){
		
		ExtentManager.getExt().fail(message);

	}
	public static void skip(String message){
		
		
		ExtentManager.getExt().skip(message);

	}
	public static void skip(String msg, boolean screenshot) {
		
	
	ExtentManager.getExt().skip(msg, MediaEntityBuilder.createScreenCaptureFromPath(getBase64Image()).build());
	
	}
	public static void fail(String msg, boolean screenshot) {
		   
	ExtentManager.getExt().fail(msg, MediaEntityBuilder.createScreenCaptureFromPath(getBase64Image()).build());
	
	} 
	  
	public static void pass(String msg, boolean screenshot) {
		
		ExtentManager.getExt().pass(MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());

	//ExtentManager.getExt().pass(msg, MediaEntityBuilder.createScreenCaptureFromPath(getBase64Image()).build());
	
	}
	public static String getBase64Image() {
		
	return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	
	}
}
