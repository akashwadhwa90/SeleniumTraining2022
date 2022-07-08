package sample;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest2 {
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("Runs after every method");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Runs before every method");
	}
	
	@Test
	public void sample() {
		System.out.println("Test");
		Assert.assertEquals(true, false, "Values does not match");
		System.out.println("Test12345");
	}
	
	@Test
	public void newsample() {
		System.out.println("Testnew");
	}

	

}
