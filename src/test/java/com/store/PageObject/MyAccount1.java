package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount1 {
	WebDriver driver;
	public MyAccount1(WebDriver d)
	{
		this.driver=d;
		
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//a[@title=\"View my customer account\"]") WebElement namecheck;
@FindBy(linkText="Sign out") WebElement signout;

public String namechekker()
{
	return namecheck.getText();
}
public void clickSignOut()
{
	signout.click();
}
}
