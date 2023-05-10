package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;
import reports.ExtentManager;

public final class OrangeHRMLoginPage extends BasePage {
	
	private final By textusername=By.xpath("//input[@name='username']");
	private final By textpassword=By.xpath("//input[@name='password']");
	private final By button_login=By.xpath("//button[@type='submit']");
	
	public OrangeHRMLoginPage enterUserName(String username) {
		sendkeys(textusername, username,WaitStrategy.PRESENCE, "username");
		return this;
		
	}
	public OrangeHRMLoginPage enterpassword(String password) {
		sendkeys(textpassword, password,WaitStrategy.PRESENCE, "password");
		ExtentManager.getExt().pass("password entered");
		return this;
		
	}
	public void clicklogin() {
		click(button_login,WaitStrategy.CLICKABLE, "login");
		
	}

}
