package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import pages.BasePage;
import pages.LoginPage;
import utility.BrowserFactory;
import utility.ExcelDataProvider;
import utility.Helper;

public class LoginToSauceDemo extends BasePage {
	public ExtentTest logger;
	
	@Test
	public void login() {
		
		logger = report.createTest("Login to Sauce demo");
		ExcelDataProvider excel = new ExcelDataProvider();
		LoginPage lPage = PageFactory.initElements(driver, LoginPage.class);
		lPage.loginToSauceDemo(excel.getCellData("Login", 1, 0), excel.getCellData("Login", 1, 1));
		logger.pass("Login success");
		Helper.captureScreenshot(driver);
	}
	
}
