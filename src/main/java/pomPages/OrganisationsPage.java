package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationsPage {
	//Declaration
	
	@FindBy(xpath = "//a[@class='hdrLink']")
	private WebElement PageHeader;
	
	@FindBy(xpath = "//img[@alt='Create Organization...']")
	private WebElement plusButton;
	
	@FindBy(xpath = "//table[@class='lvt small']/tbody/tr[last()]/td[3]/a")
	private WebElement newOrgLink;
	
	//Initialization
	public OrganisationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public String getPageHeader() {
		return PageHeader.getText();
	}
	
	public void clickplusButton() {
		plusButton.click();
	}
	
	public String getNewOrgName() {
		return newOrgLink.getText();
	}
	
	
	

}
