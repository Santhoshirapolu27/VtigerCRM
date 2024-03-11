package testScripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import genericLibraries.ICnstantPath;

public class CreateAndDuplicateLeadTest extends BaseClass {
	@Test
	
	public void createAndDuplicateLeadTest() throws InterruptedException {
		
		home.clickLeads();
		soft.assertEquals(lead.getPageHeader(), "Leads");
		lead.clickPlusButton();
		soft.assertEquals(createLead.getPageHeader(), "Creating New Lead");

		Map<String, String> map = excel.readFromExcel("Create And Duplicate Lead", "LeadTestData");
		String lastName=map.get("Last Name") + jutil.generateRandomNum(100);
		createLead.setLastName(lastName);
		createLead.setCompany(map.get("Company"));
		createLead.clickSave();
		
		Thread.sleep(3000);
		newLead.clickDuplicate();
		String newLastName = map.get("New Last Name")+jutil.generateRandomNum(100);
		duplicateLead.setNewLastname(newLastName);
		duplicateLead.clickSave();
		
		Thread.sleep(3000);
		soft.assertTrue(newLead.getPageHeader().contains(newLastName));
		newLead.clickDuplicate();
		
		if(lead.getNewLeadName().equals(newLastName)) {
			System.out.println("Test Pass");
			excel.updateTestStatus("Create And Duplicate Lead", "Pass", ICnstantPath.EXCEL_PATH,"LeadsTestData");

		}else {
			System.out.println("Test Fail");
			excel.updateTestStatus("Create And Duplicate Lead", "Fail", ICnstantPath.EXCEL_PATH,"LeadsTestData");

		}
		soft.assertEquals(lead.getNewLeadName(), newLastName);
		soft.assertAll();
		
		
	}
}
