package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPaymentPage {
	WebDriver driver;

	
	public OrderPaymentPage(WebDriver d)
	{
		driver = d;
		PageFactory.initElements(driver, this);

	}


	@FindBy(xpath = "//a[@title='Pay by check.']")
	WebElement payByCheque;
	
	

	

	public void clickOnPayByCheque()
	{
		payByCheque.click();
	}


	}

	

