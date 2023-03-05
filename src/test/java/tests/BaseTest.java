package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.tmb.driver.Driver;
import com.tmb.driver.DriverManager;
import com.tmp.utills.ReadPropertyFile;

public class BaseTest {
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup() throws IOException {
		Driver.initDriver();
		DriverManager.getDriver().get(ReadPropertyFile.get("url"));
	}
	
	@AfterMethod
	public void teardown() {
		Driver.quitDriver();
	}
	
}
