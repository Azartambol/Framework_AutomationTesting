package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
	
	WebDriver driver;
	
	public IndexPage(WebDriver d)
	{
		this.driver=d;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(linkText="Sign in") WebElement Signin;
	@FindBy(linkText="T-shirts") WebElement Tshirt;
	public void Click()
	{
		Signin.click();
	}
	
	public void tshirtClick()
	{
		Tshirt.click();
	}
}
