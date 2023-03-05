package tests;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Objects;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.tmb.driver.Driver;
import com.tmb.driver.DriverManager;

public class HomePageTest extends BaseTest {

	@Test
	public void test3() {
		DriverManager.getDriver().findElement(By.name("q")).sendKeys("Testing Mini bytes - Youtube",Keys.ENTER);		
		String title=DriverManager.getDriver().getTitle();
		System.out.println(title);
		Assertions.assertThat(title)
		.isNotNull()
		.isNotBlank()
		.containsIgnoringCase("google search")
		.matches("\\w.*"+"google search")
		.hasSizeBetween(15, 100);
		
		/*
		 * Assert.assertTrue(Objects.nonNull(title));
		 * Assert.assertTrue(title.toLowerCase().contains("google search"));
		 * Assert.assertTrue(title.toLowerCase().matches("\\w.*"+"google search"));
		 * Assert.assertTrue(title.length()>15); Assert.assertTrue(title.length()<100);
		 */
		List<WebElement> elements=DriverManager.getDriver().findElements(By.xpath("//h3/span"));
		//assertEquals(elements.size(), 10);
		boolean isElementPresent=false;
	for(WebElement element:elements) {
		if(element.getText().equalsIgnoreCase("Testing Mini bytes")) {
			isElementPresent=true;
			break;
		}
	}
	Assert.assertTrue(isElementPresent,"testing mini byte not found");
		
	}
}
