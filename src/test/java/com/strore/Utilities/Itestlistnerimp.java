package com.strore.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Itestlistnerimp implements ITestListener {
	ExtentSparkReporter a;
	ExtentReports report;
	ExtentTest test;
	public void onStart(ITestContext context) {
		SimpleDateFormat format= new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss");
		String timestamp = format.format(new Date());
	   
	    a=new ExtentSparkReporter("C:\\Users\\DELL\\Desktop\\NewEverything\\MyStore\\Reports\\MyStoreTestReport"+timestamp+".html");
	    report=new ExtentReports();
	    report.attachReporter(a);
	    
	    a.config().setDocumentTitle("Azars ER");
	    a.config().setReportName("Azar repo");
	    a.config().setTheme(Theme.STANDARD);
	    
	    ReadConfig rc=new ReadConfig();
	    
		report.setSystemInfo("Hardware", "Dell");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Browser", rc.getBrowser());
		report.setSystemInfo("User", "Azar");
	    
	    
	  }
	
	public void onFinish(ITestContext context)
	{
	report.flush();
    }
	
	public void onTestStart(ITestResult result) {
	    // not implemented

	  }
	public void onTestSuccess(ITestResult result) {
	    
		test=report.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Testcase "+result.getName()+" is Pass.", ExtentColor.GREEN));
	  }
	 public void onTestFailure(ITestResult result) {
		  
			test=report.createTest(result.getName());
			test.log(Status.FAIL, MarkupHelper.createLabel("Testcase "+result.getName()+" is Fail.", ExtentColor.RED));
			test.addScreenCaptureFromPath("C:\\Users\\DELL\\Desktop\\NewEverything\\MyStore\\ScreenShot\\"+result.getName()+".png");
		  }
	 
	 public void onTestSkipped(ITestResult result)
	     {
		    test=report.createTest(result.getName());
			test.log(Status.SKIP, MarkupHelper.createLabel("Testcase "+result.getName()+" is Skip.", ExtentColor.YELLOW));
		  }
	 
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
		  }
}
