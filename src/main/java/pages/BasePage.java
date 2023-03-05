package pages;

import org.openqa.selenium.By;

import com.tmb.driver.DriverManager;

import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import reports.ExtentLogger;

public class BasePage {

	protected void click(By by, WaitStrategy waitstrategy, String elementname)
	{
		ExplicitWaitFactory.performExplicitWait(waitstrategy, by).click();
		ExtentLogger.pass(elementname + "  is clicked");
		
	}
	protected void sendkeys(By by,String value,WaitStrategy waitstrategy,String elementname )
	{
		ExplicitWaitFactory.performExplicitWait(waitstrategy, by).sendKeys(value);
		ExtentLogger.pass(value + "is successfully entered in elementname " +elementname, true);

	}
	protected void getPageTitle()
	{
		DriverManager.getDriver().getTitle();
	}
}
