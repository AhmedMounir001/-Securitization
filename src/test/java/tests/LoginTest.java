package tests;

import org.testng.annotations.Test;

import pages.LoginPage;

@Test (groups = { "LoginTest"})
public class LoginTest extends TestBase {
	
	String emailValue= "demouser@microsoft.com";
	String passwordValue= "Pass@word1";
	LoginPage loginObject;
	
	@Test 
	public void login() throws InterruptedException {
		loginObject = new LoginPage(driver);
		Thread.sleep(300);
		loginObject.openLoginPage();
		Thread.sleep(100);
		loginObject.login(emailValue, passwordValue);
	}

}
