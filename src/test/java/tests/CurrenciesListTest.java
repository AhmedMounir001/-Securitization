package tests;

//import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.CRUDPage;
//import pages.CRUDPage.CRUDMode;
import pages.CurrenciesListPage;

@Test (groups = { "CurrenciesListTest"})
public class CurrenciesListTest extends TestBase {
	CurrenciesListPage currenciesListObject  ;
	CRUDPage CRUDObject;
	CRUDTest CRUDTestObject;

	@Test (dependsOnGroups = {"LoginTest"})
	public void openCurrencieList() throws InterruptedException {
		currenciesListObject = new CurrenciesListPage(driver);
		currenciesListObject.openCurrencies();	
		currenciesListObject.openCurrencieScreen();
	}
	
	@Test (dependsOnMethods = "openCurrencieList")
	public void clickAddNewCountry() throws InterruptedException {
		CRUDTestObject = new CRUDTest();
		CRUDTestObject.testAddItem();
		Thread.sleep(1000);
	}
	
	String arabicNameValue="Arabic Name";
	String englishNameValue="English Name";
	
	String isoCodeValue ="5454";
	String isoNumberValue ="741";
	String minorUnitValue="4";
	@Test (dependsOnMethods = "clickAddNewCountry")
	public void fillData() {
		currenciesListObject = new CurrenciesListPage(driver);
		currenciesListObject.insertISOCode(isoCodeValue);
		currenciesListObject.insertISONumber(isoNumberValue);
		currenciesListObject.insertminorUnit(minorUnitValue);
		currenciesListObject.insertArabicName(arabicNameValue);
		currenciesListObject.insertEnglishName(englishNameValue);		
	}
	@Test (dependsOnMethods = "fillData")
	public void testCreateNewItem() throws InterruptedException {
		CRUDObject = new CRUDPage(driver);
		//CRUDObject.clickSaveButton();
		CRUDObject.clickBackButton();
		Thread.sleep(1000);
		//Boolean checkAddItemDisplay = CRUDObject.addItemBtn.isDisplayed();
	}
	String arabicNameValueUpdate="Update Arabic Name";
	String englishNameValueUpdate="Update English Name";
	@Test (dependsOnMethods = "testCreateNewItem")
	public void testUpdateItem() throws InterruptedException {
		CRUDObject = new CRUDPage(driver);
		Thread.sleep(1000);
		CRUDObject.updateItem();
		Thread.sleep(500);
		currenciesListObject.insertArabicName(arabicNameValueUpdate);
		currenciesListObject.insertEnglishName(englishNameValueUpdate);
		CRUDObject.clickSaveButton();
		Thread.sleep(1500);
	}
	@Test (dependsOnMethods = "testUpdateItem")
	public void testViewItem() throws InterruptedException {
		CRUDObject = new CRUDPage(driver);
		Thread.sleep(1000);
		CRUDObject.readItem();
		Thread.sleep(500);
		CRUDObject.clickBackButton();
		Thread.sleep(500);		
	}
	@Test (dependsOnMethods = "testViewItem")
	public void testDeleteItem() throws InterruptedException {
		CRUDObject = new CRUDPage(driver);
		Thread.sleep(1000);
		CRUDObject.deleteItem();
		Thread.sleep(500);		
		//CRUDObject.clickDeleteButton();
		Thread.sleep(200);
	}
	

}
