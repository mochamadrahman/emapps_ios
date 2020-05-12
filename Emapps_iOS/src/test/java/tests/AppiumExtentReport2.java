package tests;

import java.io.File;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AppiumExtentReport2 {
	public static ExtentSparkReporter sparkReporter;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	

	@BeforeSuite
	public void beforeSuite() {
//In before suite we are creating HTML report template, adding basic information to it and load the extent-config.xml file

		
//		public static ExtentReports extentReport;
		String reportPath = System.getProperty("user.dir") + "/AutomationReport/";

		sparkReporter = new ExtentSparkReporter(reportPath);
		sparkReporter.config().setDocumentTitle("Appium Automation");
		sparkReporter.config().setReportName("Automation Test Report of EMAPSS for iOS");
		sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);
		extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Application Name", "EMAPPS");
		extentReport.setSystemInfo("Platform", System.getProperty("os.name"));
		extentReport.setSystemInfo("Environment", "QA");
		
		
	}

	@BeforeMethod
	public void beforeMethod(Method method) {
//In before method we are collecting the current running test case name
		String className = this.getClass().getSimpleName();
		extentTest = extentReport.createTest(className + "-" + method.getName());
		
	}

	@AfterMethod
	public void getResult(ITestResult result, Method method) throws Exception {
//In after method we are collecting the test execution status and based on that the information writing to HTML report
		
		

		String methodName = result.getName();
		extentTest.createNode(methodName);
		if (result.getStatus() == ITestResult.FAILURE) {
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(methodName + " – Test Case Failed", ExtentColor.RED));
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " – Test Case Failed", ExtentColor.RED));
		// Here you can add screenshot in the report for fail case
		extentTest.fail(methodName + "Test Step Failed");
		}
		if (result.getStatus() == ITestResult.SKIP) {
		extentTest.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " – Test Case Skipped", ExtentColor.ORANGE));
		extentTest.skip(methodName + "Test Step Skipped");
		}
		if (result.getStatus() == ITestResult.SUCCESS) {
		extentTest.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Test Case PASSED", ExtentColor.GREEN));
		extentTest.pass(methodName + "Test Step Passed");
		
		}
	}
	
	@AfterSuite
	public void endReport() {
//In after suite stopping the object of ExtentReports and ExtentTest
		String reportPath = System.getProperty("user.dir") + "/AutomationReport/";
		extentReport.flush();
		DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ss");
		Date date = new Date();
		String filePathdate = dateFormat.format(date).toString();
		String actualReportPath = reportPath + "index.html";
		new File(actualReportPath).renameTo(new File(
		System.getProperty("user.dir") + "/AutomationReport/" + "AutomationReportQA_" + filePathdate + ".html"));
	}

}