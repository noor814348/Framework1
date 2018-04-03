package generic;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class Lib implements IAutoConstant {
	public static Workbook wb;
	public static String getCellValue(String sheet, int row,int colum){
		String CellValue="";
		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			CellValue = wb.getSheet(sheet).getRow(row).getCell(colum).toString();
		} catch (Exception e) {

		}
		return CellValue;
	}
	public static int getRowCount(String sheet){
		int rowcount=0;
		try {
			wb = WorkbookFactory.create(new FileInputStream(EXCEL_PATH));
			rowcount = wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {

		}
		return rowcount;
	}
	public static String getPropertyValue(String Key){
		String propertyValue="";
		Properties prop=new Properties();
		try {
			prop.load(new FileInputStream(CONFIG_PATH));
			propertyValue=	prop.getProperty(Key);
		} catch (Exception e) {

		}
		return propertyValue;
	}
	public static void captureScreenShot(WebDriver driver, String testcasename){

		try {
			Date d=new Date();
			String CurrenDate = d.toString().replaceAll(":", "_");
			TakesScreenshot ts=(TakesScreenshot)driver;
			File srcfile = ts.getScreenshotAs(OutputType.FILE);
			File dsfile = new File("./screenshot/"+testcasename+"    "+CurrenDate+".png");

			FileUtils.copyFile(srcfile, dsfile);
		} catch (Exception e) {

		}
	}

}
