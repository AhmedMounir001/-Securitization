package tests;

//import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.CRUDPage;
//import pages.CRUDPage.CRUDMode;
import pages.SectorsPage;

@Test (groups = { "SectorsTest"})
public class SectorsTest extends TestBase {
	SectorsPage sectorsObject  ;
	CRUDPage CRUDObject;
	CRUDTest CRUDTestObject;

	@Test (dependsOnGroups = {"LoginTest"})
	public void openSectors() throws InterruptedException {
		sectorsObject = new SectorsPage(driver);
		sectorsObject.openbusinessParties();
		sectorsObject.openSectorScreen();
	}
	
	@Test (dependsOnMethods = "openSectors")
	public void clickAddNewSector() throws InterruptedException {
		CRUDTestObject = new CRUDTest();
		CRUDTestObject.testAddItem();
		Thread.sleep(1000);
	}
	
	String arabicNameValue="Arabic Name";
	String englishNameValue="English Name";
	
	String arabicNameRefCodeValue= "ARef500";
	String englishNameRefCodeValue="ERef600";
	int parentSectorIdDropListValue= 1;
	String arabicNoteValue = "Arabic Note";
	String englishNoteValue= "English Note";
	@Test (dependsOnMethods = "clickAddNewSector")
	public void fillData() {
		sectorsObject = new SectorsPage(driver);		
		sectorsObject.insertArabicName(arabicNameValue);
		sectorsObject.insertEnglishName(englishNameValue);	
		sectorsObject.insertArabicRefCode(arabicNameRefCodeValue);
		sectorsObject.insertEnglishRefCode(englishNameRefCodeValue);
		sectorsObject.selectParentSectorIdDropList(parentSectorIdDropListValue);
		sectorsObject.insertArabicNote(arabicNoteValue);
		sectorsObject.insertEnglishNote(englishNoteValue);
	}
	@Test (dependsOnMethods = "fillData")
	public void testCreateNewItem() throws InterruptedException {
		CRUDObject = new CRUDPage(driver);
		//CRUDObject.clickSaveButton();
		CRUDObject.clickBackButton();
		Thread.sleep(1200);
		//Boolean checkAddItemDisplay = CRUDObject.addItemBtn.isDisplayed();
	}
	String arabicNameValueUpdate="Update Arabic Name";
	String englishNameValueUpdate="Update English Name";
	@Test (dependsOnMethods = "testCreateNewItem")
	public void testUpdateItem() throws InterruptedException {
		CRUDObject = new CRUDPage(driver);
		Thread.sleep(1000);
		CRUDObject.updateItem();
		Thread.sleep(1500);
		sectorsObject.insertArabicName(arabicNameValueUpdate);
		sectorsObject.insertEnglishName(englishNameValueUpdate);
		CRUDObject.clickSaveButton();
		Thread.sleep(2500);
	}
	@Test (dependsOnMethods = "testUpdateItem")
	public void testViewItem() throws InterruptedException {
		CRUDObject = new CRUDPage(driver);
		Thread.sleep(2000);
		CRUDObject.readItem();
		Thread.sleep(600);
		CRUDObject.clickBackButton();
		Thread.sleep(600);		
	}
	@Test (dependsOnMethods = "testViewItem")
	public void testDeleteItem() throws InterruptedException {
		CRUDObject = new CRUDPage(driver);
		Thread.sleep(1500);
		CRUDObject.deleteItem();
		Thread.sleep(1500);		
		//CRUDObject.clickDeleteButton();
		Thread.sleep(200);
	}
	

}
