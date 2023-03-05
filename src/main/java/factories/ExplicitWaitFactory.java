package factories;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tmb.driver.DriverManager;

import Constants.FrameworkConstants;
import enums.WaitStrategy;

public class ExplicitWaitFactory {
public static WebElement performExplicitWait(WaitStrategy waitstrategy, By by) {
	
	if(waitstrategy==WaitStrategy.CLICKABLE) {
		return new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.elementToBeClickable(by));
		
	}
	else if(waitstrategy==WaitStrategy.PRESENCE) {
		return new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.presenceOfElementLocated(by));
		
	}
	else if(waitstrategy==WaitStrategy.VISIBLE) {
		return new WebDriverWait(DriverManager.getDriver(),Duration.ofSeconds(FrameworkConstants.getExplicitwait())).until(ExpectedConditions.visibilityOfElementLocated(by));
		
		
	}
	else if(waitstrategy==WaitStrategy.NONE) {
		DriverManager.getDriver().findElement(by);
		
	}
	return null;
}
	
}
