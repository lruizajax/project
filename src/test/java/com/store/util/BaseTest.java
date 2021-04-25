package com.store.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.store.utils.Constants;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest {

	public ThreadLocal<WebDriver> driver = new ThreadLocal<>();

	public ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}

	public WebDriver getDriver() {
		return this.driver.get();
	}

	public void setupDriver(String browserName) {
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			setDriver(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			setDriver(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("opera")) {
			setDriver(new OperaDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			setDriver(new InternetExplorerDriver());
		}
		
	}

	@BeforeTest
	public void setupReport() {

		reporter = new ExtentHtmlReporter("./reports/HtmlReport.html");
		reporter.config().setEncoding("utf-8");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Automation Test Result");
		reporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Automation Tester", "Luis Ruiz");

	}

	@BeforeMethod
	@Parameters(value = { "browserName" })
	public void setupBrowser(String browserName, Method testMethod) {

		logger = extent.createTest(testMethod.getName());
		setupDriver(browserName);
		getDriver().manage().window().maximize();
		getDriver().get(Constants.url);
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void createLogReport(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			String methodName = result.getMethod().getMethodName();
			String logText = "Test Case: " + methodName + " Passed";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			logger.log(Status.PASS, m);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			String methodName = result.getMethod().getMethodName();
			String logText = "Test Case: " + methodName + " Failed";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			logger.log(Status.FAIL, m);
		} else if (result.getStatus() == ITestResult.SKIP) {
			String methodName = result.getMethod().getMethodName();
			String logText = "Test Case: " + methodName + " Skipped";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
			logger.log(Status.SKIP, m);
		}

		getDriver().quit();

	}

	@AfterTest
	public void makeFinalReport() {

		extent.flush();

	}

}
