package testScripts;

import java.util.Map;

//import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.ICnstantPath;

public class CreateContactTest extends BaseClass {
	
	public void createNewContactTest() throws InterruptedException {
		//SoftAssert soft = new SoftAssert();
		home.clickContacts();
		soft.assertEquals(contact.getPageHeader(), "Contacts");
		contact.clickPlusButton();
		soft.assertEquals(createContact.getPageHeader(), "Creating New Contact");
		
		Map<String, String> map = excel.readFromExcel("Crete Contact", "ContactTestData");
		String lastName=map.get("Last Name") + jutil.generateRandomNum(100);
		createContact.setLastName(lastName);
		createContact.clickSave();
		
		Thread.sleep(3000);
		soft.assertTrue(newContact.getpageHeader().contains(lastName));
		newContact.clickContactsLink();
		
		if(contact.getNewContactName().equals(lastName)) {
			System.out.println("Test Pass");
			excel.updateTestStatus("Create Contact", "Pass", ICnstantPath.EXCEL_PATH,"ContactsTestData");
		}else {
			System.out.println("Test Fail");
			excel.updateTestStatus("Create Contact", "Fail", ICnstantPath.EXCEL_PATH,"ContactsTestData");
		}
		soft.assertEquals(contact.getNewContactName(), contact);
		soft.assertAll();
	}

}
