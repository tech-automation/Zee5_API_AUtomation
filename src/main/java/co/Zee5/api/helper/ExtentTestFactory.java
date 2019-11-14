package co.Zee5.api.helper;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestFactory {

	private static ThreadLocal<ExtentTest> extentPool = new ThreadLocal<ExtentTest>();

	public static ExtentTest getExtentTest() {
		return extentPool.get();
	}

	public static void setExtentTest(ExtentTest extentTest) {
		extentPool.set(extentTest);
	}
}