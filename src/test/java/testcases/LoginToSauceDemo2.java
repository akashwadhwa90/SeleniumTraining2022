package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.LoginPage;
import utility.BrowserFactory;

public class LoginToSauceDemo2 extends BasePage{
	
	WebDriver driver;
	
	@Test
	public void login() {
		LoginPage lPage = PageFactory.initElements(driver, LoginPage.class);
		lPage.loginToSauceDemo("standard_user", "secret_sauce");
	}
	

}
