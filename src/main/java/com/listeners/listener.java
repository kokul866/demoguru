package com.listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.base.testbase;
import com.reports.ExtentReport;

public class listener extends testbase implements ITestListener {
        ExtentReports e=ExtentReport.extent();
        ExtentTest t;
        ThreadLocal<ExtentTest> tl=new ThreadLocal<ExtentTest>();
        WebDriver driver;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		t=e.createTest(result.getMethod().getMethodName());
		tl.set(t);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		tl.get().log(Status.PASS,"this method passed");
	}
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		tl.get().fail(result.getThrowable());
		WebDriver driver = null;
		String testcasename = result.getMethod().getMethodName();
		
			try {
				driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} catch (Exception e) {
				
			}
			try {
				tl.get().addScreenCaptureFromPath(utils.getscreenshot(testcasename,driver),result.getMethod().getMethodName());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		tl.get().log(Status.FAIL,"skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		e.flush();
	}
	

}
