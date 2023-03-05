package Constants;

public class FrameworkConstants {

	
	private static final  int EXPLICITWAIT =10;
	public static String getExtentreportpath() {
		return ExtentReportPath;
	}

	private static final String ExtentReportPath=System.getProperty("user.dir")+"/extent-test-output/index.html";
	
	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

}
