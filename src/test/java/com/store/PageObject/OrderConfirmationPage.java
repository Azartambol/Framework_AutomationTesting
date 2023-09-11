package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
	WebDriver driver;

	//2. Create constructor
	public OrderConfirmationPage(WebDriver d)
	{
		this.driver = d;
		PageFactory.initElements(driver, this);//driver that will be used to lookup the web element

	}

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")
	WebElement confirmOrder;
	
	
	@FindBy(xpath="//div[@id='center_column']/p[@class='alert alert-success']")
	WebElement sucessAlert;

	@FindBy(linkText = "Sign out")
	WebElement signOut;
	
	public void clickOnSignOut()
	{
		signOut.click();
	}
	
	public void cickOnConfirmOrder()
	{
		confirmOrder.click();
	}
	
	public String getOrderSucessMessage()
	{
		return(sucessAlert.getText());
	}
	
	
}
