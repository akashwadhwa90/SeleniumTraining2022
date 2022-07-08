package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button123")
	WebElement loginBtn;
	
	public void loginToSauceDemo(String name, String pass) {
		username.sendKeys(name);
		password.sendKeys(pass);
		loginBtn.click();
	}

}
