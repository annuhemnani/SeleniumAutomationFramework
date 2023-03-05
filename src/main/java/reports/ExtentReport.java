package reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import Constants.FrameworkConstants;

public final class ExtentReport {
	private static ExtentReports extent;
	public static void  initreport() {
		if(Objects.isNull(extent)) {
		extent=new ExtentReports();
		ExtentSparkReporter spark=new ExtentSparkReporter(FrameworkConstants.getExtentreportpath());
		extent.attachReporter(spark);
		spark.config().setTheme(Theme.STANDARD);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Youtube Learning");
		}	
	}
	
	public static void flushReport() throws IOException {
		if(Objects.nonNull(extent)) {
			extent.flush();
		}
		
		Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentreportpath()).toURI() );
		
	}
	
	public static void createTest(String testname) {
		ExtentTest test=extent.createTest(testname);
		ExtentManager.setExt(test);
	}

}
