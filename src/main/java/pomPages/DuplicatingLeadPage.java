package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DuplicatingLeadPage {
	//Declaration
	@FindBy(xpath="//spa[@class = 'lvtHeaderText']")
	private WebElement pageHeader;
	
	@FindBy(name = "lastname")
	private WebElement lastNameTF;
	
	@FindBy(xpath = "//input[normalize-pace(@value)='Save']")
	private WebElement saveButton;
	
	//Initialization
	public DuplicatingLeadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void setNewLastname(String newLastName) {
		lastNameTF.clear();
		lastNameTF.sendKeys(newLastName);
	}
	
	public void clickSave() {
		saveButton.click();	
	}

}
