package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CRUDPage extends PageBase {

	public CRUDPage(WebDriver driver) {
		super(driver);
	}

	//Frame
	@FindBy (id="iframeContent") WebElement contentFrame;
	public static String contentFrameValue= "iframeContent";

	@FindBy (xpath = "//button[@title='Create item']") public WebElement addItemBtn;
	@FindBy (className = "grid-crud-header") public WebElement addScreenHeader;

	public void switchToFrame(String contentFrameValue) throws InterruptedException {
		Thread.sleep(1500);
		switchFrame(contentFrameValue);
	}

	public void clickAddItem() throws InterruptedException {
		Thread.sleep(500);		
		click(addItemBtn);
	}

	@FindBy (xpath = "//tbody/tr[last()]//td//button[@title='Read item']") WebElement readItemBtn;

	public void readItem() throws InterruptedException {		
		click(readItemBtn);
	}

	@FindBy (xpath = "//tbody/tr[last()]//td/button[@title='Update item']") WebElement updateBtn;

	public void updateItem() {
		click(updateBtn);
	}
	public void doubleClickupdateItem() {
		DoubleClickonElement(updateBtn);
	}


	@FindBy (xpath = "//button[@type='button']") WebElement backBtn;
	public void clickBackButton() throws InterruptedException {
		Thread.sleep(1000);
		click(backBtn);

	}
	@FindBy (xpath = "//button[@type='submit']") WebElement saveBtn;
	public void clickSaveButton() {
		click(saveBtn);
	}

	@FindBy (xpath = "//tbody/tr[last()]//td//button[@title='Delete item']") WebElement deleteItemBtn;
	public void deleteItem() {
		click(deleteItemBtn);
	}
	@FindBy(xpath = "//button[@type='submit']")	WebElement deleteBtn;
	public void clickDeleteButton() {
		click(deleteBtn);
	}	

	String fileUpload = "countryGrid.xlsx";
	String filePath = System.getProperty("user.dir")+"\\UploadFiles\\"+fileUpload;
	@FindBy (xpath = "//label") WebElement importBtn;

	public void clickImportBtn() throws AWTException, InterruptedException {
		click(importBtn);
		Thread.sleep(3000);
		Robot robotObject = new Robot();
		StringSelection selectionObject = new StringSelection(filePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(selectionObject, null);
		robotObject.keyPress(KeyEvent.VK_ENTER);
		robotObject.keyRelease(KeyEvent.VK_ENTER);
		robotObject.delay(2000);
		// Click on CTRL + V 
		robotObject.keyPress(KeyEvent.VK_CONTROL);
		robotObject.keyPress(KeyEvent.VK_V);
		robotObject.keyRelease(KeyEvent.VK_V);
		robotObject.keyRelease(KeyEvent.VK_CONTROL);
		robotObject.delay(2000);
		robotObject.keyPress(KeyEvent.VK_ENTER);
		robotObject.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);	
	}
	//download
	@FindBy (xpath ="//button[@title='Excel']") WebElement dbtn;

	public void clickdownloadItem() 
	{
		click(dbtn);
	}

}