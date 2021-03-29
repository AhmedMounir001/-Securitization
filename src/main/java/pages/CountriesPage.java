package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CountriesPage extends PageBase{

	public CountriesPage(WebDriver driver) {
		super(driver);		
	}

	CRUDPage CRUDObject;
	@FindBy(xpath = "/html/body/app/div[1]/div[2]/nav/ul/li[4]/span") WebElement geographicLink;
	@FindBy(xpath = "/html/body/app/div[1]/div[2]/nav/ul/li[4]/ul/li/a") WebElement countriesLink;
	@FindBy (xpath ="/html/body/app/div/div/div/div/div/form/div[2]/div[3]/div[2]/div/div[1]/input") WebElement arabicNameTxt;
	@FindBy (xpath="/html/body/app/div/div/div/div/div/form/div[2]/div[3]/div[2]/div/div[2]/input") WebElement englishNameTxt;
	@FindBy(name = "MajorCurrencyISO") WebElement majorCurrencyISOSelect;
	@FindBy(name = "MinorCurrencyISO") WebElement minorCurrencyISOSelect;
	@FindBy (id = "InternationalCode") WebElement internationalCodeTxt;
	@FindBy (id="CountryISO") WebElement countryISOTxt;
	@FindBy(id="OfficialWeekendId") WebElement officialWeekendIdSelect;
	
	
	public void openGeo() throws InterruptedException {
		Thread.sleep(100);
		click(geographicLink);
	}
	public void openCountriesScreen() {
		click(countriesLink);
	}
	
	
	public void addCountry() throws InterruptedException {
		CRUDObject.clickAddItem();
	}
	
	public void insertArabicName(String arabicNameValue) {
		setTextElement(arabicNameTxt, arabicNameValue);		
		
	}
	public void insertEnglishName(String englishNameValue) {		
		setTextElement(englishNameTxt, englishNameValue);
		
	}
	public void selectMajorCurrency(int majorIndex) {	
		
		DropListSelectByIndex(majorCurrencyISOSelect, majorIndex);
		
	}
	public void selectMinorCurrency(int minorIndex) {		
		DropListSelectByIndex(minorCurrencyISOSelect, minorIndex);
	}
	public void insertInternationalCode(String internationalCodeValue) {
		setTextElement(internationalCodeTxt, internationalCodeValue);
	}
	public void insertcountryISO(String countryISOValue) {
		setTextElement(countryISOTxt, countryISOValue);		
	}
	public void selectOfficialWeekendId(int OfficialWeekendIdValue) {
		DropListSelectByIndex(officialWeekendIdSelect, OfficialWeekendIdValue);
		
	}

}
