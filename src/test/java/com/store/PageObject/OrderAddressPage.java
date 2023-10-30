package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderAddressPage {

	WebDriver driver;


	public OrderAddressPage(WebDriver d)
	{
		this.driver = d;
		PageFactory.initElements(driver, this);

	}



	@FindBy(name="processAddress")
	WebElement proceedfromAddressPage;
	
	public void cickOnProceedToCheckout()
	{
		proceedfromAddressPage.click();
	}
}
