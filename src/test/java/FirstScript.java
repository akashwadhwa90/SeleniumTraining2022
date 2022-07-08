import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstScript {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\AKAWADHW\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.sugarcrm.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll")).click();
		Thread.sleep(5000);
		
		
		List<WebElement> socialMediaLinks = driver.findElements(By.xpath("//div[@class='site-social-networks']//li"));
		
		String parentWinHandle = driver.getWindowHandle();
		
		for(int i =0; i<socialMediaLinks.size(); i++) {
			socialMediaLinks.get(i).click();
			Set<String> winHandles = driver.getWindowHandles();
			Iterator<String> it = winHandles.iterator();
			while(it.hasNext()) {
				String childwindow = it.next();
				if(!parentWinHandle.equals(childwindow)) {
					driver.switchTo().window(childwindow);
					Thread.sleep(2000);
					driver.close();
				}
			}
			Thread.sleep(2000);
			driver.switchTo().window(parentWinHandle);
		}
		
		driver.quit();
	}

}
