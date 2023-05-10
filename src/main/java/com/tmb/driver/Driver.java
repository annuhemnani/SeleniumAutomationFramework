package com.tmb.driver;

import java.time.Duration;
import java.util.Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public static void initDriver() {
		if(Objects.isNull(DriverManager.getDriver()))
		{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		DriverManager.setDriver(new ChromeDriver(options));
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		}
		
	}
	public static void quitDriver() {
		if(Objects.nonNull(DriverManager.getDriver())) {
			DriverManager.getDriver().quit();
			DriverManager.unload();

		}
	}
	
}
