package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	public Loginpage(WebDriver d)
	{
		this.driver=d;
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="email") WebElement email;

	@FindBy(id="passwd") WebElement password;

	@FindBy(id="SubmitLogin") WebElement signin;
	
	
	public void enterEmail(String emaill)
	{
		email.sendKeys(emaill);
	}
	public void enterPassword(String pass)
	{
		password.sendKeys(pass);
	}
	public void signin()
	{
		signin.click();;
	}
	
	public String loginTitle()
	{
		String title = driver.getTitle();
		return title;
	}
	
}
