package co.Zee5.api.helper;

import java.io.File;
import java.lang.reflect.Method;

import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class RestListener {

	public static ExtentTestFactory extentTestFactory;
	public File WORKING_DIRECTORY;
	private static ExtentReports extent;
	public static String filePath = "C:/Users/Qualitrix/Desktop/Automation/Automation/Reports/ExtentReport.html";

	public RestListener() {
		extentTestFactory = new ExtentTestFactory();
	}
	
	/**
	 * Load Extent Config xml file
	 */
	public static void loadExtentFile() {
		new File(filePath);
		extent = new ExtentReports();
		extent.attachReporter(getHtmlReporter());

	}

	/**
	 *
	 * @return ExtentHtmlReporter Instance
	 */
	private static ExtentHtmlReporter getHtmlReporter() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(filePath);
		htmlReporter.config().setDocumentTitle("Zee5-Automation");
		htmlReporter.config().setReportName("Zee5 API Automation");
		htmlReporter.config().setTheme(Theme.DARK);
		return htmlReporter;
	}

	public static void configExtenTest(String className) {

		ExtentTest parent = extent.createTest(className);
		ExtentTestFactory.setExtentTest(parent);
	}

	public void childMethods(Method name, String className, String testDataName) {

		// Extent Report Configuration

		ExtentTest child = ExtentTestFactoryParent.getExtentTest().createNode(testDataName);
		ExtentTestFactory.setExtentTest(child);

	}

	/**
	 * Flush the report
	 */
	public void flushReport() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
		}
		extent.flush();
	}

	/**
	 * Result Status Capture
	 * 
	 * @param result
	 */
	public void testResultCapture(ITestResult result) {

		/**
		 * Success Block
		 */
		if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentTestFactory.getExtentTest().log(Status.PASS, result.getMethod().getMethodName() + " Passed");
		}

		/**
		 * Failure Block
		 */
		if (result.getStatus() == ITestResult.FAILURE) {
			ExtentTestFactory.getExtentTest().fail(result.getThrowable().getMessage());

		}
	}

}
