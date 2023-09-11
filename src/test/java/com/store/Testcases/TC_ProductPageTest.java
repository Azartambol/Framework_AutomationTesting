package com.store.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.PageObject.IndexPage;
import com.store.PageObject.Loginpage;
import com.store.PageObject.ProductSearchDisplay;
import com.store.PageObject.Productpage;
import com.store.PageObject.SearchProduct;

public class TC_ProductPageTest extends BaseClass {

	@Test(enabled=true)
	public void VerifySearchProduct() throws IOException
	{
		String searchKey = "T-shirts";
	
		logg.info("***************TestCase Search Product started*****************"); 

		//Sign in 
		IndexPage indexPg = new IndexPage(driver);
		indexPg.Click();

		logg.info("Clicked on Sign in link");
		logg.info("My Account Page is open");


		//Enter account details- email and password
		Loginpage l=new Loginpage(driver); 
		l.enterEmail(Email);
		l.enterPassword(Pass);
		l.signin();
		
		logg.info("Email and Pass entered and click on sign in"); 

		//Enter searchkey in search box
		SearchProduct pg = new SearchProduct(driver);
		pg.EnterDataInSearchBox(searchKey);
		pg.ClickOnSearchButton();
		
		logg.info("Product Search page open"); 
		logg.info("In Search box added search key and clicked search button"); 

		// Get Name of Searched Product
		ProductSearchDisplay resultPg = new ProductSearchDisplay(driver);
        String SearchResultProductname=resultPg.getSearchResultProductName();
        
		logg.info("In result page get name of the product which is diplayed "); 

		//Verify that correct Product is displaying after search
		logg.info("Verifying that correct Product is displaying after search"); 
		if(SearchResultProductname.contains(searchKey))
		{
			logg.info("Search Product testcase - Passed"); 
		    resultPg.clickOnSignOut();
			Assert.assertTrue(true);
		}
		else
		{
			logg.info("Search Product testcase - Failed SS captured");
			screenshotCapture("VerifySearchProduct");
			Assert.assertTrue(false);

		} 

		logg.info("***************TestCase Search Product ends*****************"); 

	}
	
	@Test(enabled=false)
	public void VerifyBuyProduct() throws IOException
	{

		logg.info("\n***************TestCase Buy Product started*****************"); 

		/*	driver.get(url);
		logger.info("Url opened");*/

		//Sign in 
		IndexPage indexPg = new IndexPage(driver);
		indexPg.Click();


		//Enter account details- email and password
		Loginpage l=new Loginpage(driver); 
		l.enterEmail(Email);
		l.enterPassword(Pass);
		l.signin();

		SearchProduct pg = new SearchProduct(driver);
		pg.EnterDataInSearchBox("T-shirts");
		
		logg.info("T-shirt entered in search box");

		pg.ClickOnSearchButton();
		logg.info("clicked on search button");

		ProductSearchDisplay searchResultPg = new ProductSearchDisplay(driver);
		searchResultPg .mouseOverOnTshirtProduct();
		searchResultPg.ClickOnMoreLink();
		logg.info("Clicked on more button");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//

		Productpage prodPg = new Productpage(driver);
		prodPg.setQuantity("2");
		logg.info("quantity 2 entereed");

		prodPg.setSize("M");
		logg.info("size M entered");

		prodPg.clickOnAddToCart();
		logg.info("Clicked on add to cart");

		prodPg.clickOnProceedToCheckOut();
		logg.info("Clicked on proceed to checkout on product page");


		com.store.PageObject.OrderSummaryPage orderSumPg = new com.store.PageObject.OrderSummaryPage(driver);
		orderSumPg.cickOnProceedToCheckout(); 
		logg.info("Clicked on proceed to checkout on order summary page");

		com.store.PageObject.OrderAddressPage orderAddPg = new com.store.PageObject.OrderAddressPage(driver);
		orderAddPg.cickOnProceedToCheckout();
		logg.info("Clicked on proceed to checkout on order address page");

		com.store.PageObject.OrderShippingPage orderShippingPg = new com.store.PageObject.OrderShippingPage(driver);
		orderShippingPg.selectTermsOfServices();
		logg.info("selecged term of service check box");

		orderShippingPg.cickOnProceedToCheckout();
		logg.info("Clicked on proceed to checkout on order shipping page");

		com.store.PageObject.OrderPaymentPage orderPaymentPg = new com.store.PageObject.OrderPaymentPage(driver);
		logg.info("order payment page open");

		orderPaymentPg.clickOnPayByCheque();
		logg.info("Clicked on pay by cheque");

		com.store.PageObject.OrderConfirmationPage orderConfirmPg = new com.store.PageObject.OrderConfirmationPage(driver);
		orderConfirmPg.cickOnConfirmOrder();

		logg.info("Clicked on confirmed order");

		String sucessMsg = orderConfirmPg.getOrderSucessMessage();

		//	Assert.assertEquals(sucessMsg, "Your order on My Store is complete.");

		if(sucessMsg.equals("Your order on My Store is complete."))
		{
			logg.info("VerifyBuyProduct - Passed"); 
			Assert.assertTrue(true);

			orderConfirmPg.clickOnSignOut();

		}
		else
		{
			logg.info("VerifyBuyProduct - Failed");
			screenshotCapture("VerifyBuyProduct");
			Assert.assertTrue(false);

		} 

		logg.info("***************TestCase BuyProduct ends*****************"); 

	}
}
