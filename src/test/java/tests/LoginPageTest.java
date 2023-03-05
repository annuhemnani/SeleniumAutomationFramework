package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.tmb.driver.Driver;
import com.tmb.driver.DriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest extends BaseTest {

	
	@Test
	public void test1() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("testing mini bytes",Keys.ENTER);
		
	}
	@Test
	public void test2() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Manual Testing",Keys.ENTER);		
	}
}
