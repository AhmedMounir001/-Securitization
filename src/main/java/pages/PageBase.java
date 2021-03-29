package pages;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {
	protected WebDriver driver;
	public PageBase(WebDriver driver)

	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

	public void openNewTab(String url) {
		driver.switchTo().newWindow(WindowType.WINDOW.TAB);
		driver.get(url);
	}
	protected void goToFirstTab() {
		Set<String> handles=driver.getWindowHandles();
		List<String> lS = new ArrayList<String>(handles);
		String parentWindow= lS.get(0);
		String chiledWindo = lS.get(1);
		driver.switchTo().window(parentWindow);
	}
	protected void goToSecondtTab() {
		Set<String> handles=driver.getWindowHandles();
		List<String> lS = new ArrayList<String>(handles);
		String parentWindow= lS.get(0);
		String chiledWindo = lS.get(1);
		driver.switchTo().window(chiledWindo);
	}
	protected void goToThirdTab() {
		Set<String> handles=driver.getWindowHandles();
		List<String> lS = new ArrayList<String>(handles);
		String parentWindow= lS.get(0);
		String chiledWindo = lS.get(1);
		String thiredWindo = lS.get(2);
		driver.switchTo().window(thiredWindo);
	}

	protected void click(WebElement button) {
		button.click();
	}

	protected void setTextElement(WebElement textBox,String textValue) {
		textBox.clear();
		textBox.sendKeys(textValue);
	}
	protected static void DropListSelectByValue (WebElement dropList, String Value)
	{
		Select dropMenuSelect = new Select(dropList);
		dropMenuSelect.selectByValue(Value);		
	}
	protected static void DropListSelectByIndex (WebElement dropList,int indexValue)
	{
		Select dropMenuSelect = new Select(dropList);		
		dropMenuSelect.selectByIndex(indexValue);
	}
	protected void Checkingcheckbox (WebElement Checkbox)
	{
		Checkbox.click();
	}
	protected void waitMethod(int timeInSeconds)
	{
		driver.manage().timeouts().implicitlyWait(timeInSeconds, TimeUnit.SECONDS);

	}
	protected void ConfirmAlert()
	{
		driver.switchTo().alert().accept();
	}

	protected void deleteValueFromControl(WebElement element)
	{
		element.clear();
	}
	protected void switchFrame (String frameID) throws InterruptedException
	{
		//WebDriverWait wait = new WebDriverWait(driver1,3000);
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameID));
		driver.switchTo().frame(frameID);
	}

	protected void DoubleClickonElement(WebElement button)
	{
		Actions a = new Actions(driver);
		a.doubleClick(button).perform();

	}

	protected void EnterElement(WebElement SearchBoxEnter)
	{

		SearchBoxEnter.sendKeys(Keys.ENTER);
	}

	protected void TABElement(WebElement SearchBoxTAB)
	{

		SearchBoxTAB.sendKeys(Keys.TAB);

	}

	protected void submitlement(WebElement element)
	{

		element.submit();

	}

	protected void takeScreenShot() throws IOException {
		File scrFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scrFile, new File("ScreenShots/main_page.png"));

	}
}


