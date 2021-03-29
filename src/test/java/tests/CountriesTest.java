package tests;

//import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.CRUDPage;
//import pages.CRUDPage.CRUDMode;
import pages.CountriesPage;

@Test (groups = { "CountriesTest"})
public class CountriesTest extends TestBase {
	CountriesPage countriesObject  ;
	CRUDPage CRUDObject;
	CRUDTest CRUDTestObject;

	@Test (dependsOnGroups = {"LoginTest"})
	public void openCountries() throws InterruptedException {
		countriesObject = new CountriesPage(driver);
		countriesObject.openGeo();		
		countriesObject.openCountriesScreen();
		Thread.sleep(3000);
	}
	
	@Test (dependsOnMethods = "openCountries")
	public void clickAddNewCountry() throws InterruptedException {
		CRUDTestObject = new CRUDTest();
		CRUDTestObject.testAddItem();
		Thread.sleep(3000);
	}
	
	String arabicNameValue="Arabic Name";
	String englishNameValue="English Name";
	int majorIndex=1;
	int minorIndex= 1;
	String internationalCodeValue="2454";
	String countryISOValue="987";
	int OfficialWeekendIdValue=1;
	int OfficialWeekendIdValue2=2;
	@Test (dependsOnMethods = "clickAddNewCountry")
	public void fillData() throws InterruptedException {
		countriesObject = new CountriesPage(driver);
		countriesObject.insertArabicName(arabicNameValue);
		countriesObject.insertEnglishName(englishNameValue);
		countriesObject.selectMajorCurrency(majorIndex);
		countriesObject.selectMinorCurrency(minorIndex);
		countriesObject.insertInternationalCode(internationalCodeValue);
		countriesObject.insertcountryISO(countryISOValue);
		countriesObject.selectOfficialWeekendId(OfficialWeekendIdValue);
		countriesObject.selectOfficialWeekendId(OfficialWeekendIdValue2);
		Thread.sleep(3000);
	}
	@Test (dependsOnMethods = "fillData")
	public void testCreateNewItem() throws InterruptedException {
		CRUDObject = new CRUDPage(driver);
		//CRUDObject.clickSaveButton();
		CRUDObject.clickBackButton();
		Thread.sleep(3000);
		//Boolean checkAddItemDisplay = CRUDObject.addItemBtn.isDisplayed();
	}
	String arabicNameValueUpdate="Update Arabic Name";
	String englishNameValueUpdate="Update English Name";
	@Test (dependsOnMethods = "testCreateNewItem")
	public void testUpdateItem() throws InterruptedException {
		CRUDObject = new CRUDPage(driver);
		Thread.sleep(3000);
		CRUDObject.updateItem();
		Thread.sleep(2500);
		countriesObject.insertArabicName(arabicNameValueUpdate);
		countriesObject.insertEnglishName(englishNameValueUpdate);
		CRUDObject.clickSaveButton();
		Thread.sleep(3300);
	}
	@Test (dependsOnMethods = "testUpdateItem")
	public void testViewItem() throws InterruptedException {
		CRUDObject = new CRUDPage(driver);
		Thread.sleep(3000);
		CRUDObject.readItem();
		Thread.sleep(3300);
		CRUDObject.clickBackButton();
		Thread.sleep(2300);		
	}
	@Test (dependsOnMethods = "testViewItem")
	public void testDeleteItem() throws InterruptedException {
		CRUDObject = new CRUDPage(driver);
		Thread.sleep(3000);
		CRUDObject.deleteItem();
		Thread.sleep(2500);		
		//CRUDObject.clickDeleteButton();
		Thread.sleep(200);
	}
	

}
