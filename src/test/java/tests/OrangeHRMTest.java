package tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import pages.OrangeHRMLoginPage;
import reports.ExtentManager;
import reports.ExtentReport;

public final class OrangeHRMTest extends BaseTest{
	private OrangeHRMTest() {
		
	}
	@Test
	public void loginLogoutTest() throws Exception {
			
		

new OrangeHRMLoginPage().enterUserName("Admin").enterpassword("admin123").clicklogin();

	}

}
