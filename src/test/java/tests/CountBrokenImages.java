package tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CountBrokenImages {
	WebDriver driver = null;
	String URL = "https://the-internet.herokuapp.com/broken_images";
	public static String status = "passed";

	@BeforeClass
	public void testSetUp() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		System.out.println("Started session");
	}

	@Test(description = "Approach 1: Find broken images on a web page using Selenium WebDriver", enabled = true)
	public void findbrokenImage() throws ClientProtocolException, IOException {
		int iBrokenImageCount = 0;

		driver.get(URL);
		List<WebElement> image_list = driver.findElements(By.cssSelector("img"));
		System.out.println("The page under test has " + image_list.size() + " images");
		for (WebElement img : image_list) {
			if (img != null) {
				HttpClient client = HttpClientBuilder.create().build();
				HttpGet request = new HttpGet(img.getAttribute("src"));
				HttpResponse response = client.execute(request);
				if (response.getStatusLine().getStatusCode() != 200) {
					System.out.println(img.getAttribute("outerHTML") + " is broken.");
					iBrokenImageCount++;
				}
			}
		}
		System.out.println("The page " + URL + " has " + iBrokenImageCount + " broken images");

	}

	@Test
	public void findbrokenImage_method2() {
		int iBrokenImageCount = 0;
		driver.get(URL);
		List<WebElement> image_list = driver.findElements(By.cssSelector("img"));
		System.out.println("The page under test has " + image_list.size() + " images");
		for (WebElement img : image_list) {
			if (img != null) {
				if (img.getAttribute("naturalWidth").equals("0")) {
					System.out.println(img.getAttribute("outerHTML") + " is broken.");
					iBrokenImageCount++;
				}
			}
		}
		System.out.println("The page " + URL + " has " + iBrokenImageCount + " broken images");

	}
	 @AfterClass
	    public void tearDown()
	    {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
}
