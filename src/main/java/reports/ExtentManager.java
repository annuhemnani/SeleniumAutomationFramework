package reports;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

	private static ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();

	public static ExtentTest getExt() {
		return extenttest.get();
	}

	public static void setExt(ExtentTest test) {
		extenttest.set(test);
	}
	public static void unload() {
		extenttest.remove();
	}
}
