package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSummaryPage {
	WebDriver driver;


	public OrderSummaryPage(WebDriver d)
	{
		this.driver = d;
		PageFactory.initElements(driver, this);

	}


	@FindBy(linkText = "Proceed to checkout")
	WebElement proceed;
	
	
	
	
	public void cickOnProceedToCheckout()
	{
		proceed.click();
	}
	
	

}
