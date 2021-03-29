package tests;

//import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.CRUDPage;
import pages.OrganizationsPage;

@Test (groups = { "OrganizationTest"})
public class OrganizationTest extends TestBase 
{
	OrganizationsPage Organizobj;
	CRUDPage CRUDObject;
	CRUDTest CRUDTestObject;



	@Test (dependsOnGroups = {"LoginTest"})
	public void openCategories() throws InterruptedException {
		Organizobj = new OrganizationsPage(driver);
		Organizobj.openbusinessParties();
		Organizobj.openCategoryScreen();
	}

	@Test (dependsOnMethods = "openCategories")
	public void clickAddNewCategory() throws InterruptedException 
	{
		CRUDTestObject = new CRUDTest();
		CRUDTestObject.testAddItem();
		Thread.sleep(1000);
	}

	String arabicNameValue="Arabic Name";
	String englishNameValue="English Name";

	String arabicNameRefCodeValue= "ARef500";
	String englishNameRefCodeValue="ERef600";

	int basecurrencyindex=0;
	int Countryindex=0;
	int categoryindex=0;
	int sectorindex=0;

	String Date="01062021";

	String arabicNoteValue = "ArabicNote";
	String englishNoteValue = "EnglishNote";
	String fiscalYearStartMonthTxtValue="4";

	@Test (dependsOnMethods = "clickAddNewCategory")
	public void fillData() throws InterruptedException {
		Organizobj = new OrganizationsPage(driver);		
		Organizobj.insertArabicName(arabicNameValue);
		Organizobj.insertEnglishName(englishNameValue);	

		Organizobj.insertArabicRefCode(arabicNameRefCodeValue);
		Organizobj.insertEnglishRefCode(englishNameRefCodeValue);

		Organizobj.selectBaseCurrencyByIdDropList(basecurrencyindex);
		Organizobj.selectCountryByIdDropList(Countryindex);
		Organizobj.selectCategoryByIdDropList(categoryindex);
		Organizobj.selectSectorByIdDropList(sectorindex);

		Organizobj.insertDateField(Date);

		Organizobj.insertfiscalYearStartMonth(fiscalYearStartMonthTxtValue);
		Thread.sleep(1000);

		Organizobj.insertArabicNote(arabicNoteValue);
		
		Thread.sleep(1000);
		Organizobj.insertEnglishNote(englishNoteValue);

		Organizobj.clickcheckboxes();
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
		Organizobj.insertArabicName(arabicNameValueUpdate);
		Organizobj.insertEnglishName(englishNameValueUpdate);
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
