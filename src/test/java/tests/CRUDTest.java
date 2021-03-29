package tests;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

//import org.openqa.selenium.By;
import org.testng.annotations.Test;

import pages.CRUDPage;
//import pages.CRUDPage.CRUDMode;
import pages.CountriesPage;

@Test (groups = { "CRUDTest"})
public class CRUDTest extends TestBase {
	CountriesPage countriesObject  ;
	CRUDPage CRUDObject;

	@Test (dependsOnGroups = {"LoginTest"})
	public void openScreen() throws InterruptedException {
		countriesObject = new CountriesPage(driver);
		countriesObject.openGeo();		
		countriesObject.openCountriesScreen();
	}

	@Test (dependsOnMethods = "openScreen")
	public void testAddItem() throws InterruptedException {		
		countriesObject = new CountriesPage(driver);
		CRUDObject = new CRUDPage(driver);			
		Thread.sleep(1000);
		CRUDObject.switchToFrame(CRUDPage.contentFrameValue);
		Thread.sleep(2000);
		CRUDObject.clickAddItem();
		Thread.sleep(4000);
		assertEquals(CRUDObject.addScreenHeader.getText(), "Add");
		System.out.println("Add Item Screen Open Successfully");
	}

	@Test (dependsOnMethods = "testAddItem")
	public void testBackButton() throws InterruptedException, AWTException {
		Thread.sleep(400);
		CRUDObject = new CRUDPage(driver);	
		CRUDObject.clickBackButton();
		System.out.println("Back Click Done");
		Thread.sleep(2000);
		
		//test import
		CRUDObject.clickImportBtn();
		Thread.sleep(400);
		CRUDObject.readItem();
		System.out.println("Click Read Done");
		Thread.sleep(4000);
		assertEquals(CRUDObject.addScreenHeader.getText(), "View");
		System.out.println("View Item Screen Open Successfully");
		Thread.sleep(500);
		CRUDObject.clickBackButton();
		System.out.println("Back Click Done");
		Thread.sleep(4000);
		CRUDObject.updateItem();
		System.out.println("Click Update Done");
		Thread.sleep(4000);
		assertEquals(CRUDObject.addScreenHeader.getText(), "Edit");
		System.out.println("Edit Item Screen Open Successfully");

		CRUDObject.clickBackButton();
		System.out.println("Back Click Done");
		Thread.sleep(4000);
		/*CRUDObject.deleteItem();
		System.out.println("Click Delete Done");
		Thread.sleep(400);
		assertEquals(CRUDObject.addScreenHeader.getText(), "Delete");
		System.out.println("Delete Item Screen Open Successfully");*/

	}

	@Test (dependsOnMethods = "testBackButton")
	public void testSaveButton() throws InterruptedException {
		Thread.sleep(400);
		CRUDObject = new CRUDPage(driver);	
		CRUDObject.clickAddItem();
		Thread.sleep(400);
		CRUDObject.clickSaveButton();
		CRUDObject.clickBackButton();
	}
	

	@Test (dependsOnMethods = "testSaveButton")
	public void testUpdateButton() throws InterruptedException {
		Thread.sleep(400);
		CRUDObject = new CRUDPage(driver);	
		CRUDObject.updateItem();
		Thread.sleep(400);
		CRUDObject.clickSaveButton();
		Thread.sleep(400);
		
	}
	
	@Test (dependsOnMethods = "testUpdateButton")
	public void testDeleteButton() throws InterruptedException {
		Thread.sleep(400);
		CRUDObject = new CRUDPage(driver);	
		Thread.sleep(600);
		CRUDObject.deleteItem();
		//CRUDObject.deleteItem();
		Thread.sleep(400);
		//CRUDObject.clickDeleteButton();
		
	}
}
