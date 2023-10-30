package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderShippingPage {

	WebDriver driver;


	public OrderShippingPage(WebDriver d)
	{
		this.driver = d;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id="cgv")
	WebElement termOfServices;
	
	
	@FindBy(name = "processCarrier")
	WebElement proceedShipping;
	
	
	
	public void selectTermsOfServices()
	{
		termOfServices.click();
	}
	
	
	public void cickOnProceedToCheckout()
	{
		proceedShipping.click();
	}
}
