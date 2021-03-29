package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
	public static WebDriver driver;


	@BeforeTest
	public void setup() {

		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://host.docker.internal:5110/");

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
	@AfterMethod
	public void ScreenshotonFailure(ITestResult Result) 
	{
		if(Result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Taking Screenshot.....");
			utilitiez.HelperClass.Capturescreenshot(driver, Result.getName());		}
	}



}
