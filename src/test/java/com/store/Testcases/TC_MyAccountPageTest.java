package com.store.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.PageObject.AccountCreationPage;
import com.store.PageObject.IndexPage;
import com.store.PageObject.Loginpage;
import com.store.PageObject.MyAccount1;
import com.store.PageObject.MyaccountPage;
import com.store.PageObject.SearchProduct;

public class TC_MyAccountPageTest extends BaseClass {

	@Test(enabled=false)
	public void verifyRegistrationLogin()
	{    
		logg.info("***************TestCase VerifyRegistrationLogin Started*****************"); 
		
		IndexPage ip=new IndexPage(driver);
		ip.Click();
		
		logg.info("Clicked on Sign in link");
		logg.info("My Account Page is open");
		
		MyaccountPage ma=new MyaccountPage(driver);
		ma.enterEmail(Email);
		ma.click();
		
		logg.info("Entered Email ID and clicked on create an account button");
		logg.info("Account Creation page is open");
		
		AccountCreationPage ac=new AccountCreationPage(driver);
		ac.clickOnRadio();
		ac.enterName("Azar");
		ac.enterlastName("tamboli");
		ac.enterpass(Pass);
	    ac.ticknewsletter();
		ac.clickOnRegisterBtn();
		
		logg.info(" After filling form Account is Created");
		
		MyAccount1 ma1=new MyAccount1(driver);
		Assert.assertEquals("Azar tamboli", ma1.namechekker());
		
		logg.info("***************TestCase VerifyRegistrationLogin Ends*****************"); 
}
	
	
	@Test
	public void verifyLogin() throws IOException
	{
		
		logg.info("***************TestCase VerifyLogin Started*****************"); 
		
        IndexPage ip=new IndexPage(driver);
		ip.Click();
		
		logg.info("Clicked on Sign in link");
		logg.info("My Account Page is open");

		Loginpage l=new Loginpage(driver);
		l.enterEmail(Email);	
		l.enterPassword(Pass);
		l.signin();
		
		logg.info("Email and Pass entered and click on sign in"); 
	
		MyAccount1 ma=new MyAccount1(driver);
		String name = ma.namechekker();
		
		SearchProduct sp=new SearchProduct(driver);
		
		logg.info("Checking correct username is displaying or not");
		
		if(name.equals("Azar tamboli"))
		{
			sp.clickOnSignOut();
			logg.info("Testcase VerifyLogin passed");
			Assert.assertTrue(true);
			
		}
		else
		{
			
			screenshotCapture("verifyLogin");
			logg.info("Testcase VerifyLogin failed Screenshot captured"); 
			Assert.assertTrue(false);
			
		}
		
		logg.info("***************TestCase VerifyLogin Ends*****************"); 	
	}
	
	@Test(priority=1)
	public void VerifySignOut() throws IOException
	{

		logg.info("***************TestCase Verify Sign out starts*****************"); 

		IndexPage pg = new IndexPage(driver);
        pg.Click();
		
        logg.info("Clicked on sign in link");

		Loginpage l=new Loginpage(driver);
        l.enterEmail(Email);
		logg.info("Entered email address");

		l.enterPassword(Pass);
		logg.info("Entered password");

		l.signin();
		logg.info("Clicked on sign in link..");

		SearchProduct sp=new SearchProduct(driver);
		sp.clickOnSignOut();
		logg.info("Clicked on sign out link..");
		
		if(l.loginTitle().equals("Login - My Shop"))
		{
			logg.info("user signed out from application");
			logg.info("Testcase VerifySignOut passed");
			Assert.assertTrue(true);
		}

		else
		{
			screenshotCapture("VerifySignOut");
			logg.info("Testcase VerifySignOut failed SS captured");
			Assert.assertTrue(false);
		}


		logg.info("***************TestCase Verify Sign out ends*****************"); 

	}






}
