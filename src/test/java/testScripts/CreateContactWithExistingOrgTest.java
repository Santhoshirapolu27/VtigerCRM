package testScripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import genericLibraries.ICnstantPath;

public class CreateContactWithExistingOrgTest extends BaseClass {
	
	@Test	
	public void createContactWithExistingOrgTest() throws InterruptedException {
		home.clickContacts();
		soft.assertEquals(contact.getPageHeader(), "Contacts");
		contact.clickPlusButton();
		Thread.sleep(3000);
		soft.assertEquals(createContact.getPageHeader(), "Creating New Contact");
		
		Map<String, String> map = excel.readFromExcel("Create Contact With Organization", "ContactsTestData");
		String lastName = map.get("Last Name") + jutil.generateRandomNum(100);
		createContact.setLastName(lastName);
		createContact.selectExistingOrg(web, map.get("Organiztion Name"));
		
		Thread.sleep(3000);
		soft.assertTrue(newContact.getpageHeader().contains(lastName));
		newContact.clickContactsLink();
		
		if(contact.getNewContactName().equals(lastName)) {
			System.out.println("Test Pass");
			excel.updateTestStatus("Create Contact With Organization", "Pass", ICnstantPath.EXCEL_PATH, "ContactsTestData");
		}
		else {
			System.out.println("Test Fail");
			excel.updateTestStatus("Create Contact With Organization", "Fail", ICnstantPath.EXCEL_PATH, "ContactsTestData");
		}
		soft.assertEquals(contact.getNewContactName(), contact);
		soft.assertAll();
	}
	
	

}
