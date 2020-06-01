package tests;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.markuputils.ExtentColor;
//import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EmappsTestReport {
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;


	@BeforeSuite
	public void beforeSuite() {
//In before suite we are creating HTML report template, adding basic information to it and load the extent-config.xml file

		extentReport = new ExtentReports(System.getProperty("user.dir") + "/test-output/extent-reports/EmappsTestReport.html", true);
		extentReport.addSystemInfo("Host Name", "QA Team4 Mitrais Bootcap Scrum");
		extentReport.loadConfig(new File(System.getProperty("user.dir") + "/report-config.xml"));
		
		
		
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
//In before method we are collecting the current running test case name
		String className = this.getClass().getSimpleName();
		extentTest = extentReport.startTest(className + "-" + method.getName());
		
	}

	@AfterMethod
	public void getResult(ITestResult result, Method method) throws Exception {
//In after method we are collecting the test execution status and based on that the information writing to HTML report
		
		

		
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(LogStatus.FAIL, "Test Case Failed is " + result.getName());
			extentTest.log(LogStatus.FAIL, "Error Details :- \n" + result.getThrowable().getMessage());
		}
		if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
			extentTest.log(LogStatus.SKIP, "Error Details :- \n" + result.getThrowable().getMessage());
		}

		if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(LogStatus.PASS, "Test Case Passed is " + result.getName());
		}

		extentReport.endTest(extentTest);
	}
	
	@AfterSuite
	public void endReport() {
//In after suite stopping the object of ExtentReports and ExtentTest
		extentReport.flush();
	}

}