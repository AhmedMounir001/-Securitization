package tests;

//import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.CRUDPage;
import pages.CategoriesPage;

@Test (groups = { "CategoriesTest"})
public class CategoriesTest extends TestBase {
	CategoriesPage categoriesObject  ;
	CRUDPage CRUDObject;
	CRUDTest CRUDTestObject;

	@Test (dependsOnGroups = {"LoginTest"})
	public void openCategories() throws InterruptedException {
		categoriesObject = new CategoriesPage(driver);
		categoriesObject.openbusinessParties();
		categoriesObject.openCategoryScreen();
	}
	
	@Test (dependsOnMethods = "openCategories")
	public void clickAddNewCategory() throws InterruptedException {
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
	
	@Test (dependsOnMethods = "clickAddNewCategory")
	public void fillData() {
		categoriesObject = new CategoriesPage(driver);		
		categoriesObject.insertArabicName(arabicNameValue);
		categoriesObject.insertEnglishName(englishNameValue);	
		categoriesObject.insertArabicRefCode(arabicNameRefCodeValue);
		categoriesObject.insertEnglishRefCode(englishNameRefCodeValue);
		categoriesObject.selectParentSectorIdDropList(parentSectorIdDropListValue);
		categoriesObject.insertArabicNote(arabicNoteValue);
		categoriesObject.insertEnglishNote(englishNoteValue);
	}
	@Test (dependsOnMethods = "fillData")
	public void testCreateNewItem() throws InterruptedException {
		CRUDObject = new CRUDPage(driver);
		//CRUDObject.clickSaveButton();
		CRUDObject.clickBackButton();
		Thread.sleep(3000);

		CRUDObject.clickdownloadItem() ;
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
		categoriesObject.insertArabicName(arabicNameValueUpdate);
		categoriesObject.insertEnglishName(englishNameValueUpdate);
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
