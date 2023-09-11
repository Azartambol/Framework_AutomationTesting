package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyaccountPage {
	
WebDriver driver;

public MyaccountPage (WebDriver d)
{
	this.driver=d;
	
	PageFactory.initElements(driver, this);
}


@FindBy(id="email_create") WebElement enamiltextfield ;
@FindBy(id="SubmitCreate")  WebElement createaccountbtn;

public void enterEmail(String s)
{
	 enamiltextfield.sendKeys(s);	
}

public void click()
{
	 createaccountbtn.click();
}






}
