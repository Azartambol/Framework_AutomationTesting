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
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[2]/ul[1]/li[1]/div[1]/div[2]/h5[1]/a[1]")
	WebElement searchResultProduct ;
	
	@FindBy(linkText = "Sign out")
	WebElement signOut;
	
	@FindBy(xpath="//a[@title='Faded Short Sleeve T-shirts'][1]")
	WebElement tshirtProduct;
	
	@FindBy(xpath="//a[@title=\"View\"]")
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
