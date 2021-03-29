package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SectorsPage extends PageBase{

	public SectorsPage(WebDriver driver) {
		super(driver);		
	}

	CRUDPage CRUDObject;
	@FindBy(xpath = "//div[1]/div[2]/nav/ul/li[3]/span") WebElement businessPartiesLink;
	@FindBy(xpath = "//div[1]/div[2]/nav/ul/li[3]/ul/li/a[1]") WebElement sectorLink;
	
		
	@FindBy (xpath ="//form/div[2]/div[3]/div[2]/div/div[1]/input") WebElement arabicNameTxt;
	@FindBy(xpath = "//form/div[2]/div[4]/div[2]/div/div[1]/input") WebElement arabicRefCodeTxt;
	@FindBy (xpath ="//form/div[2]/div[6]/div[2]/div/div[1]/input") WebElement arabicNoteTxt;
	
	@FindBy (xpath="//form/div[2]/div[3]/div[2]/div/div[2]/input") WebElement englishNameTxt;
	@FindBy (xpath="//form/div[2]/div[4]/div[2]/div/div[2]/input") WebElement englishRefCodeTxt;
	@FindBy (xpath="//form/div[2]/div[6]/div[2]/div/div[2]/input") WebElement englishNoteTxt;
	@FindBy(id = "ParentSectorIdText") WebElement parentSectorIdDropList;
	
	public void openbusinessParties() throws InterruptedException {
		Thread.sleep(100);
		click(businessPartiesLink);
	}
	public void openSectorScreen() {
		click(sectorLink);
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
	
	public void selectParentSectorIdDropList(int parentSectorIdDropListValue) {
		DropListSelectByIndex(parentSectorIdDropList, parentSectorIdDropListValue);
		
	}
	public void insertArabicNote(String arabicNoteValue) {
		setTextElement(arabicNoteTxt, arabicNoteValue);	
		
	}
	public void insertEnglishNote(String englishNoteValue) {		
		setTextElement(englishNoteTxt, englishNoteValue);		
	}
	
}
