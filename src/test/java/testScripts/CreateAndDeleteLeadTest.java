package testScripts;

import java.util.Map;


import org.testng.annotations.Test;

import genericLibraries.BaseClass;
//import genericLibraries.ICnstantPath;

//changes are made

public class CreateAndDeleteLeadTest extends BaseClass{
	
	public class createAndDeleteLeadTest extends BaseClass {
		@Test
		public void CreateLeadTest() throws InterruptedException {
			home.clickLeads();
			soft.assertEquals(lead.getPageHeader(), "Leads");
			lead.clickPlusButton();
			soft.assertEquals(createLead.getPageHeader(), "Creating New Lead");
			
			Map<String, String> map = excel.readFromExcel("Delete lead", "LeadsTestData");
			String lastName = map.get("Last Name") + jutil.generateRandomNum(100);
			createLead.setLastName(lastName);
			createLead.setCompany(map.get("Company"));
			createLead.clickSave();

			Thread.sleep(4000);
			soft.assertTrue(newLead.getPageHeader().contains(lastName));
			newLead.getLeadsLink();
			
			Thread.sleep(4000);
			lead.deleteLead(web, lastName);
			web.handleAlert("OK");
			
			Thread.sleep(5000);
			soft.assertFalse(lead.searchLead(lastName));
			soft.assertAll();
		}
	}
}
