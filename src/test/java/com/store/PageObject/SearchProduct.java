package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct {

WebDriver driver;
	
	public SearchProduct(WebDriver d)
	{
		this.driver=d;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name ="search_query")
	WebElement searchBox;

	@FindBy(name ="submit_search")
	WebElement submit_search;
	
	@FindBy(linkText="Sign out") WebElement signout;
	
	public void EnterDataInSearchBox(String searchKey)
	{
		searchBox.sendKeys(searchKey);
	}

	public void ClickOnSearchButton()
	{
		submit_search.click();

	}
	
	public void clickOnSignOut()
	{
		signout.click();
	}
}
