package org.testn;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.*;

public class SnapDealFunctionality extends BaseClass{
@BeforeClass
private void launch() {
	launchbrowser();
}
@Test
private void tc() throws IOException {
	passUrl("https://www.snapdeal.com/");
	Pojo p=new Pojo();
	fill(p.getInputsearch(),getData(1,0));
	click(p.getSearch());
}
@Test
private void tc1() {
	Pojo1 p1=new Pojo1();
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true)",p1.getItem());
	click(p1.getItem());
	windowHandle(1);
	Assert.assertTrue(driver.getCurrentUrl().contains("iPhone-6s-32GB-Silve"));
	click(p1.getBuy());

}




}
