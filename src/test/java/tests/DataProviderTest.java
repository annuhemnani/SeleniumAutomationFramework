package tests;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTest {
	
	@Test(dataProvider="getData1")
	public void dataprovidertest(Object[] a) {
for(Object s:a)
{
	System.out.println(s);
}
	}

	/*
	 * @Test() public void testperform() throws IOException {
	 * 
	 * // System.out.println(map.get("username"));
	 * WebDriverManager.chromedriver().setup();
	 * 
	 * DesiredCapabilities cap = new DesiredCapabilities();
	 * cap.setBrowserName("chrome"); WebDriver driver = new RemoteWebDriver(new
	 * URL("http://localhost:4444/wd/hub"), cap); driver.get("http://google.com");
	 * String title = driver.getTitle(); System.out.println(title); driver.quit();
	 * 
	 * }
	 */

	@DataProvider
	public String[] getData() {
		String[] a = { "amuthan", "testing", "mini bytes" };
		return a;
	}

	@DataProvider
	public Object[] getData1() throws IOException {

		String excelPath = System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdemo.xlsx";
		System.out.println(excelPath);
		FileInputStream fis = new FileInputStream(excelPath);

		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("testing");
		int lastrowcount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println(columnCount);
		System.out.println(lastrowcount);
		DataFormatter formatter = new DataFormatter();

		Object[] dataObject = new Object[lastrowcount];
		for (int i = 0; i < lastrowcount; i++) {
			HashMap<String, String> data = new HashMap<>();
			for (int j = 0; j < columnCount; j++) {
				String key = formatter.formatCellValue(sheet.getRow(0).getCell(j));
				String value = formatter.formatCellValue(sheet.getRow(i + 1).getCell(j));
				data.put(key, value);

			}
			dataObject[i] = data;
		}

		return dataObject;
	}

	@DataProvider

	public Object[][] excelDataProvider() throws IOException {
		String excelPath = System.getProperty("user.dir") + "/src/test/resources/testdata/Testdata.xlsx";
		FileInputStream fis = new FileInputStream(excelPath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheet("Test1");
		return null;

	}

}
