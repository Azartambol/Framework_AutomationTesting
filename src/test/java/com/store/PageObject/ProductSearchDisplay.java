package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductSearchDisplay {
WebDriver driver;
	
	public ProductSearchDisplay(WebDriver d)
	{
		this.driver=d;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/h5/a")
	WebElement searchResultProduct ;
	
	@FindBy(linkText = "Sign out")
	WebElement signOut;
	
	@FindBy(xpath="(//a[@title='Faded Short Sleeve T-shirts'])[1]")
	WebElement tshirtProduct;
	
	@FindBy(xpath="//a[@title='View']")
	WebElement more;
	
	public String getSearchResultProductName()
	{
		return(searchResultProduct.getText());
	}
	public void clickOnSignOut()
	{
		signOut.click();
	}
	
	public void ClickOnMoreLink()
	{
		more.click();

	}
	
	public void mouseOverOnTshirtProduct()
	{
		Actions actionobj = new Actions(driver);
		actionobj.moveToElement(tshirtProduct).build().perform();
	}
}
