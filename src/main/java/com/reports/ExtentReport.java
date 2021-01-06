package com.reports;

import com.Utils.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	static ExtentReports e;
	public static ExtentReports extent() {
		ExtentSparkReporter report=new ExtentSparkReporter(Constants.reportspath);
		report.config().setDocumentTitle("DEMO BANK TEST");
		e=new ExtentReports();
		e.attachReporter(report);
		return e;
	}

}
