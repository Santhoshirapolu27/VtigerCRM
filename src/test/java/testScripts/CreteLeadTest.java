package testScripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import genericLibraries.ICnstantPath;

public class CreteLeadTest extends BaseClass {
	@Test
	
	public void CreteNewLeadTest() throws InterruptedException {
		home.clickLeads();
		soft.assertEquals(lead.getPageHeader(), "Leads");
		lead.clickPlusButton();
		soft.assertEquals(createLead.getPageHeader(), "Creating New Lead");
		
		Map<String, String> map = excel.readFromExcel("Create lead", "LeadsTestData");
		String lastName = map.get("Last Name")+jutil.generateRandomNum(100);
		createLead.setLastName(lastName);
		createLead.setCompany(map.get("Company"));
		createLead.clickSave();
		
		Thread.sleep(3000);
		soft.assertTrue(newLead.getPageHeader().contains(lastName));
		newLead.getLeadsLink();
		
		if(lead.getNewLeadName().equals(lastName)) {
			System.out.println("Test Pass");
			excel.updateTestStatus("Create lead", "Pass", ICnstantPath.EXCEL_PATH, "LeadsTestData");
		}
		else {
			System.out.println("Test Fail");
			excel.updateTestStatus("Create lead", "Fail", ICnstantPath.EXCEL_PATH, "LeadsTestData");
		}
		soft.assertEquals(lead.getNewLeadName(), lead);
		soft.assertAll();
		
	}

}
