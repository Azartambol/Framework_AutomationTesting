package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Productpage {
	WebDriver driver;
	public Productpage(WebDriver d)
	{
		this.driver=d;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="quantity_wanted")
	WebElement quantityWanted ;

	@FindBy(id="group_1")
	WebElement size;

	//button[@name='Submit']
	@FindBy(name="Submit")
	WebElement addToCart;
	
	@FindBy(linkText = "Proceed to checkout")
	WebElement proceed;


	public void setQuantity(String qty)
	{
		quantityWanted.clear();
		quantityWanted.sendKeys(qty);
	}

	//create actions methods for web elements
	public void setSize(String sizeType)
	{
		Select oSelect=new Select(size);
		oSelect.selectByVisibleText(sizeType);	
	}

	public void clickOnAddToCart()
	{
		addToCart.click();
	}
	public void clickOnProceedToCheckOut()
	{
		proceed.click();
	}
}
