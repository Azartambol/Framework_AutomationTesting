package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	WebDriver driver;


	public OrderConfirmationPage(WebDriver d)
	{
		this.driver = d;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//button[@class='button btn btn-default button-medium']")
	WebElement confirmOrder;
	
	
	@FindBy(xpath="//p[@class='alert alert-success']")
	WebElement sucessAlert;

	@FindBy(linkText = "Sign out")
	WebElement signOut;
	
	public void clickOnSignOut()
	{
		signOut.click();
	}
	
	public void cickOnConfirmOrder()
	{
		confirmOrder.click();;
	}
	
	public String getOrderSucessMessage()
	{
		return(sucessAlert.getText());
	}
	
	
}
