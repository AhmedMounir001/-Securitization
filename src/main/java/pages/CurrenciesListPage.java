package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CurrenciesListPage extends PageBase{

	public CurrenciesListPage(WebDriver driver) {
		super(driver);		
	}

	CRUDPage CRUDObject;
	@FindBy(xpath = "//div[1]/div[2]/nav/ul/li[2]/span") WebElement currenciesExchangecLink;
	@FindBy(xpath = "//nav/ul/li[2]/ul/li/a[1]") WebElement currenciesLink;
	
	@FindBy(id = "ISOCode") WebElement isoCodeTxt;
	@FindBy(id = "ISONumber") WebElement isoNumberTxt;
	@FindBy(id = "MinorUnit") WebElement minorUnitTxt;
	@FindBy (xpath ="//form/div[2]/div[5]/div[2]/div/div[1]/input") WebElement arabicNameTxt;	
	@FindBy (xpath="//form/div[2]/div[5]/div[2]/div/div[2]/input") WebElement englishNameTxt;
	
	
	public void openCurrencies() throws InterruptedException {
		Thread.sleep(100);
		click(currenciesExchangecLink);
	}
	public void openCurrencieScreen() {
		click(currenciesLink);
	}
	
	
	public void addCurrency() throws InterruptedException {
		CRUDObject.clickAddItem();
	}
	
	public void insertISOCode(String isoCodeValue) {
		setTextElement(isoCodeTxt, isoCodeValue);			
	}
	public void insertISONumber(String isoNumberValue) {
		setTextElement(isoNumberTxt, isoNumberValue);			
	}
	public void insertminorUnit(String minorUnitValue) {
		setTextElement(minorUnitTxt, minorUnitValue);		
	}
	
	public void insertArabicName(String arabicNameValue) {
		setTextElement(arabicNameTxt, arabicNameValue);	
		
	}
	public void insertEnglishName(String englishNameValue) {		
		setTextElement(englishNameTxt, englishNameValue);		
	}
	
}
