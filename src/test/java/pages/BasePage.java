package pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utility.BrowserFactory;
import utility.ConfigDataProvider;
import utility.Helper;

public class BasePage {
	
	public WebDriver driver;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite()
	public void suiteSetUp() {
		config = new ConfigDataProvider();
		ExtentSparkReporter extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Report.html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeClass
	public void setUp() {
		driver = BrowserFactory.startApplication(driver, config.getDataFromConfig("Browser"), config.getDataFromConfig("url"));
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
		report.flush();
	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
		}
	}

}
