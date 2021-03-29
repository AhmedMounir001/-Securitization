package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationsPage extends PageBase{

	public OrganizationsPage(WebDriver driver) {
		super(driver);		
	}

	CRUDPage CRUDObject;
	@FindBy(xpath = "//div[1]/div[2]/nav/ul/li[3]/span") WebElement businessPartiesLink;
	@FindBy(xpath = "//div[2]/nav/ul/li[3]/ul/li/a[3]") WebElement organizationsLink;
                    	                     	 
	@FindBy (xpath ="//form/div[2]/div[3]/div[2]/div/div[1]/input") WebElement arabicNameTxt;
	@FindBy(xpath = "//form/div[2]/div[4]/div[2]/div/div[1]/input") WebElement arabicRefCodeTxt;
	@FindBy (xpath ="//form/div[2]/div[15]/div[2]/div/div[1]/input") WebElement arabicNoteTxt;
	
	                
	@FindBy (xpath="//form/div[2]/div[3]/div[2]/div/div[2]/input") WebElement englishNameTxt;
	@FindBy (xpath="//form/div[2]/div[4]/div[2]/div/div[2]/input") WebElement englishRefCodeTxt;
	@FindBy (xpath="//form/div[2]/div[15]/div[2]/div/div[2]/input") WebElement englishNoteTxt;
	@FindBy(id = "BaseCurrencyId") WebElement baseCurrencyIdDropList;
	@FindBy(id = "OriginCountryId") WebElement originCountryIdDropList;
	@FindBy(id = "CategoryId") WebElement categoryIdDropList;
	@FindBy(id = "SectorId") WebElement sectorIdDropList;
	@FindBy(id = "FoundationDate") WebElement foundationDate;
	@FindBy(id = "FiscalYearStartMonth") WebElement fiscalYearStartMonthTxt;
	
	
	//Roles Checkbox options
	
	@FindBy(xpath = "//div/table/tr[1]/td[2]/input") WebElement CollectionAgentoption;
	
	
	
	
	
	
	//Roles
	public void clickcheckboxes()
	{
		click(CollectionAgentoption);
	
	}
	
	public void insertDateField(String Date) {		
		setTextElement(foundationDate, Date);		
	}
	
	
	
	public void openbusinessParties() throws InterruptedException {
		Thread.sleep(100);
		click(businessPartiesLink);
	}
	public void openCategoryScreen() {
		click(organizationsLink);
	}
	
	
	public void addNewSector() throws InterruptedException {
		CRUDObject.clickAddItem();
	}
	
	public void insertArabicName(String arabicNameValue) {
		setTextElement(arabicNameTxt, arabicNameValue);	
		
	}
	public void insertEnglishName(String englishNameValue) {		
		setTextElement(englishNameTxt, englishNameValue);		
	}
	
	public void insertArabicRefCode(String arabicNameRefCodeValue) {
		setTextElement(arabicRefCodeTxt, arabicNameRefCodeValue);	
		
	}
	public void insertEnglishRefCode(String englishNameRefCodeValue) {		
		setTextElement(englishRefCodeTxt, englishNameRefCodeValue);		
	}
	
	
	public void selectBaseCurrencyByIdDropList(int baseCurrencyIdDropListValue) {
		DropListSelectByIndex(baseCurrencyIdDropList, baseCurrencyIdDropListValue);		
	}
	
	public void selectCountryByIdDropList(int originCountryIdDropListValue) {
		DropListSelectByIndex(originCountryIdDropList, originCountryIdDropListValue);		
	}
	
	public void selectCategoryByIdDropList(int categoryIdDropListValue) {
		DropListSelectByIndex(categoryIdDropList, categoryIdDropListValue);		
	}
	public void selectSectorByIdDropList(int sectorIdDropListValue) {
		DropListSelectByIndex(sectorIdDropList, sectorIdDropListValue);		
	}
	public void insertfiscalYearStartMonth(String fiscalYearStartMonthTxtValue) {
		setTextElement(fiscalYearStartMonthTxt, fiscalYearStartMonthTxtValue);		
	}
	
	public void insertArabicNote(String arabicNoteValue)
	{
		setTextElement(arabicNoteTxt, arabicNoteValue);		
	}
	
	public void insertEnglishNote(String englishNoteValue) {		
		setTextElement(englishNoteTxt, englishNoteValue);		
	}
	
}
