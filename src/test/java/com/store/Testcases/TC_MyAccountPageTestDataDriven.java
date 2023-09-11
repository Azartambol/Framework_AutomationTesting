package com.store.Testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.store.PageObject.AccountCreationPage;
import com.store.PageObject.IndexPage;
import com.store.PageObject.Loginpage;
import com.store.PageObject.MyAccount1;
import com.store.PageObject.MyaccountPage;
import com.strore.Utilities.ReadExcelFile;

public class TC_MyAccountPageTestDataDriven extends BaseClass {

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

	
	@Test(dataProvider="xxx")
	public void verifyLogin(String email,String pass,String expectedname) throws IOException
	{
		logg.info("***************TestCase VerifyLogin Started*****************"); 

		IndexPage ip=new IndexPage(driver);
		ip.Click();
		logg.info("Clicked on Sign in link");
		logg.info("My Account Page is open");


		Loginpage l=new Loginpage(driver);
		l.enterEmail(email);	
		l.enterPassword(pass);
		l.signin();
		
		logg.info("Email and Pass entered and click on sign in"); 
		
		MyAccount1 ma=new MyAccount1(driver);
		String name = ma.namechekker();
		
		logg.info("Checking correct username is displaying or not");
		
		if(name.equals(expectedname))
		{
			MyAccount1 ma1=new MyAccount1(driver);
			ma1.clickSignOut();
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
	
	@DataProvider(name="xxx")
		public String[][] dProvider() throws EncryptedDocumentException, IOException
		{
			ReadExcelFile re=new ReadExcelFile();
			String filepath="C:\\Users\\DELL\\Desktop\\NewEverything\\MyStore\\TestData\\logininfo.xlsx";
		    int x = re.getNoOfRow(filepath, 0)+1;
		int y=re.getNoOfcells(filepath, 0,1);
			String[][] data=new String[x-1][y];
			
			for(int i=1;i<x;i++)
			{
				for(int j=0;j<y;j++)
				{
					data[i-1][j]=re.valueProvide(filepath, 0, i, j);
				}
				
			}
			
			return data;
			
		}
	
}
