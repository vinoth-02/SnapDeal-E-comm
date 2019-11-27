package org.testn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojo1 extends BaseClass {
	public Pojo1() {
		PageFactory.initElements(driver,this);
	}
@FindBy(xpath="//img[@src='https://n1.sdlcdn.com/imgs/d/p/x/230X258_sharpened/Apple-iPhone-6s-32GB-Silver-SDL770488775-1-4409b.webp']")
private WebElement item;
@FindBy(xpath="//div[@id='buy-button-id']")
private WebElement buy;
public WebElement getBuy() {
	return buy;
}
public WebElement getItem() {
	return item;
}
}
