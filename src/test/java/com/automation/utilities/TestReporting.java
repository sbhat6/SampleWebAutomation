package com.automation.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestReporting extends TestListenerAdapter {  //Using Java Inheritance & TestNG Listeners features
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extReporter;
	public ExtentTest logger;

	public void onStart(ITestContext tc) { //Using Java Runtime Polymorphism or method overriding
		
		//Listener method to design HTML based test report
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Test-Report-" + timeStamp + ".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/Test-reports/" + reportName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
		extReporter = new ExtentReports();
		extReporter.attachReporter(htmlReporter);
		extReporter.setSystemInfo("Host name", "localhost");
		extReporter.setSystemInfo("Environemnt", "QA");
		extReporter.setSystemInfo("user", "sbhat6");
		htmlReporter.config().setDocumentTitle("Dropbox Files Upload Test");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlReporter.config().setTheme(Theme.STANDARD);
	}

	public void onTestSuccess(ITestResult tr) {
		//Listener method to indicate passed tests in test report
		logger = extReporter.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult tr) {
		//Listener method to indicate failed tests in test report
		logger = extReporter.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		//Code to capture screenshot when a test fails can be added here.
	}

	public void onTestSkipped(ITestResult tr) {
		//Listener method to indicate skipped tests in test report
		logger = extReporter.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.YELLOW));
	}

	public void onFinish(ITestContext tc) {
		//Listener method to generate final test report
		extReporter.flush();
	}
}
