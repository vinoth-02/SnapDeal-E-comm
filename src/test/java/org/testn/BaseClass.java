package org.testn;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClass {
	static WebDriver driver;
	public static void launchbrowser() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Vinoth\\eclipse-workspace\\TestN\\driver\\chromedriver.exe");
	 driver=new ChromeDriver();
	}
	public static void passUrl(String url) {
		driver.get(url);
	}
	public static void fill(WebElement e,String value) {
		e.sendKeys(value);
	}
	public static void click(WebElement e) {
		e.click();
	}
	public static void attributeValue(WebElement e) {
		String attribute = e.getAttribute("value");
		System.out.println(attribute);
	}
	public static void quit() {
		driver.quit();

	}
	public static void down(int e) throws AWTException {
		Robot r=new Robot();
		for(int i=1;i<=e;i++) {
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		}
	}
	public static void enter(int e) throws AWTException {
		Robot r=new Robot();
		for(int i=1;i<=e;i++) {
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		}
	}
	public static String getData(int rowno,int cellno) throws IOException {
		String values =null;
		File loc = new File("C:\\Users\\Vinoth\\eclipse-workspace\\TestN\\Excel\\data.xlsx");
		FileInputStream st=new FileInputStream(loc);
		Workbook w=new XSSFWorkbook(st);
		Sheet s=w.getSheet("Sheet1");
		Row r=s.getRow(rowno);
		Cell c=r.getCell(cellno);
		int type=c.getCellType();
		if(type==1) {
			values=c.getStringCellValue();
		}
		else if(type==0) {
			if(DateUtil.isCellDateFormatted(c)) {
				Date d = c.getDateCellValue();
				SimpleDateFormat sim=new SimpleDateFormat("dd-mmm-yyyy");
				values=sim.format(d);
			}
			else {
				double n = c.getNumericCellValue();
				long l=(long)n;
				values=String.valueOf(l);
			
			
			}
		}
		return values;
	}
	public static void windowHandle(int e) {
		String parid=driver.getWindowHandle();
		System.out.println(parid);
		Set<String> s=driver.getWindowHandles();
		System.out.println(s);
		List<String> l=new ArrayList<String>();
		l.addAll(s);
		System.out.println(l);
		driver.switchTo().window(l.get(e));
	}
}
