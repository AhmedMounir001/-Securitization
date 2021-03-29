package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (css="a.nav-link") WebElement loginLink;
	@FindBy (id="Email") WebElement emailTxt;
	@FindBy (id="Password") WebElement passwordTxt;
	@FindBy (xpath = "/html/body/div/div[2]/div/div/section/form/div[5]/button") WebElement loginBtn;
	
	public void openLoginPage() {
		click(loginLink);
	}
	
	public void login(String emaiValue,String passwordValue) {
		setTextElement(emailTxt, emaiValue);
		setTextElement(passwordTxt, passwordValue);
		click(loginBtn);
	}

}
