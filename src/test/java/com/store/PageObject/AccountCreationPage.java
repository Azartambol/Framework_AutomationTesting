package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AccountCreationPage {

	WebDriver driver;
	public AccountCreationPage(WebDriver d)
	{
		this.driver=d;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="id_gender1") WebElement radiobtn;
	@FindBy(id="customer_firstname") WebElement firstname;
	@FindBy(id="customer_lastname") WebElement lasttname;
	@FindBy(id="email") WebElement email;
	@FindBy(id="passwd") WebElement password;
	@FindBy(id="newsletter") WebElement newsletter;
	@FindBy(id="days") WebElement d;
	@FindBy(id="months") WebElement m;
	@FindBy(id="years") WebElement y;
	@FindBy(id="submitAccount") WebElement registerbtn;
	
	public void day(String da) {
		Select s= new Select(d);
		s.selectByVisibleText(da);
	}
	public void month(String mo) {
		Select s= new Select(m);
		s.selectByValue(mo);
	}
	public void year(int ye) {
		Select s= new Select(y);
		s.selectByIndex(ye);
	}
	public void clickOnRadio()
	{
		radiobtn.click();
	}
	public void enterName(String n)
	{
		firstname.sendKeys(n);
	}
	public void enterlastName(String l)
	{
		lasttname.sendKeys(l);;
	}
	public void enteremail(String e)
	{
		email.sendKeys(e);
	}
	public void enterpass(String p)
	{
	   password.sendKeys(p);
	}
	public void ticknewsletter()
	{
		newsletter.click();
	}
	public void clickOnRegisterBtn()
	{
		registerbtn.click();
	}
	
}
