package co.Zee5.api.helper;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.logging.Logger;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;

import co.Zee5.api.config.Constants;
import io.restassured.filter.log.RequestLoggingFilter;

/**
 * RestBaseClass contains TestNG general annotation methods and variables used
 * through out the test run.
 * 
 * @author Prasad
 *
 */
public class RestBaseClass extends RestListener implements Constants {

	public static String baseURI;
	public static String targetResource;
	public ExtentTest loggerReport;
	public static RequestLoggingFilter req;
	String testCaseName = "";

	protected Logger LOGGER;
	protected String sourceClass;
	protected String sourceMethod;

	private static String restBaseSourceClass = RestBaseClass.class.getName();
	private static String restBaseSourceMethod;

	static Logger restBaseLogger = Logger.getLogger(restBaseSourceClass);

	/**
	 * Before Method: Initialises extent report
	 * 
	 * @author Ooviya
	 * @param method
	 * @param details
	 * @param ctx
	 */
	@BeforeMethod
	public void init(Method method, Object[] details, ITestContext ctx) {
		restBaseSourceMethod = "init";
		restBaseLogger.entering(restBaseSourceClass, restBaseSourceMethod);
		sourceMethod = method.getName();
	
		if (details.length > 0) {
			if (details[0] instanceof String) {
				restBaseLogger.info("TestData is instance of String");
				testCaseName = "-" + details[0].toString();
			} else {
				restBaseLogger.info("TestData is instance of Map");

				@SuppressWarnings("unchecked")
				Map<String, String> map[] = (Map<String, String>[]) details[0];
				if (map[0].containsKey("Test case")) {
					testCaseName = "-" + map[0].get("Test case");
				} else {
					System.out.println("Please add \"Test case\" column in your data provider excel sheet. "
							+ "\n This will be appended to the method name in the extent report");
				}
			}
		}
		restBaseLogger.info("Test case name is " + testCaseName);
		configExtenTest(sourceClass + testCaseName);
		ctx.setAttribute("testName", sourceMethod + testCaseName);

		loggerReport = ExtentTestFactory.getExtentTest();
		restBaseLogger.exiting(restBaseSourceClass, restBaseSourceMethod);

		LOGGER.entering(sourceClass, sourceMethod);
	}

	/**
	 * After method: captures the result
	 * 
	 * @author Ooviya
	 * @param method
	 * @param details
	 * @param ctx
	 * @param result
	 */
	@AfterMethod
	public void close(Method method, Object[] details, ITestContext ctx, ITestResult result) {
		LOGGER.exiting(sourceClass, sourceMethod);
		restBaseSourceMethod = "close";
		restBaseLogger.entering(restBaseSourceClass, restBaseSourceMethod);

		ctx.setAttribute("testName", sourceMethod + testCaseName);
		testResultCapture(result);

		restBaseLogger.exiting(restBaseSourceClass, restBaseSourceMethod);
	}

	/**
	 * Before Class: loads the extent file
	 * 
	 * @author Ooviya
	 */
	@BeforeClass
	public void initLogger() {
		restBaseSourceMethod = "initLogger";
		restBaseLogger.entering(restBaseSourceClass, restBaseSourceMethod);

		sourceClass = getClass().getName().substring(getClass().getName().lastIndexOf('.') + 1);
		LOGGER = Logger.getLogger(sourceClass);

		restBaseLogger.exiting(restBaseSourceClass, restBaseSourceMethod);
	}

	/**
	 * Before Suite: loads the extent file
	 * 
	 * @author Prasad
	 */
	@BeforeSuite
	public void generateToken() {
		restBaseSourceMethod = "generateToken";
		restBaseLogger.entering(restBaseSourceClass, restBaseSourceMethod);

		loadExtentFile();

		restBaseLogger.exiting(restBaseSourceClass, restBaseSourceMethod);
	}

	/**
	 * After suite: flushes the report
	 * 
	 * @author Prasad
	 */
	@AfterSuite
	public void afterSuite() {
		restBaseSourceMethod = "afterSuite";
		restBaseLogger.entering(restBaseSourceClass, restBaseSourceMethod);

		flushReport();

		restBaseLogger.exiting(restBaseSourceClass, restBaseSourceMethod);
	}
}
