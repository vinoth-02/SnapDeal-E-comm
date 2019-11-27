package org.testn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pojo extends BaseClass{
	
public Pojo() {
	PageFactory.initElements(driver,this);
}
@FindBy(id="inputValEnter")
private WebElement inputsearch;
public WebElement getInputsearch() {
	return inputsearch;
}
public WebElement getSearch() {
	return search;
}
@FindBy(xpath="//button[@class='searchformButton col-xs-4 rippleGrey']")
private WebElement search;




}

