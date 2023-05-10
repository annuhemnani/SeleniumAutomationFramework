package listeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import reports.ExtentLogger;
import reports.ExtentReport;

public class ListenerClass implements ITestListener, ISuiteListener{

	public void onStart(ISuite suite) {
		System.out.println("suite name"+suite);
		ExtentReport.initreport();

		// TODO Auto-generated method stub
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		try {
			ExtentReport.flushReport();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("this is to be run first");
		ExtentReport.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentLogger.pass(result.getMethod().getMethodName()+" is passed");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentLogger.fail(result.getMethod().getMethodName()+" is failed",true);
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentLogger.skip(result.getMethod().getMethodName()+" is skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
	}

}
