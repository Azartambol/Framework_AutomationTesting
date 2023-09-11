package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPaymentPage {
	WebDriver driver;

	//2. Create constructor
	public OrderPaymentPage(WebDriver d)
	{
		driver = d;
		PageFactory.initElements(driver, this);//driver that will be used to lookup the web element

	}


	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")
	WebElement payByCheque;
	
	

	

	public void clickOnPayByCheque()
	{
		payByCheque.click();
	}


	}

	

