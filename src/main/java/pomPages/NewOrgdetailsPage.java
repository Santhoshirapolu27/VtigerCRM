package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewOrgdetailsPage {
	
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement pageHeader;
	
	@FindBy(xpath = "//a[@class = 'hdrLink']")
	private WebElement orgLink;
	
	//Initialization
	public NewOrgdetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public void clickOrgLink() {
		orgLink.click();
	}
	

}
