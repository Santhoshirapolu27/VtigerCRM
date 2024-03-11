package testScripts;

import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import genericLibraries.ICnstantPath;
@Test

public class CreateLead extends BaseClass {

	public CreateLead() throws InterruptedException {
		home.clickLeads();
		lead.clickPlusButton();
		
		Map<String, String> map = excel.readFromExcel("Create Lead", "LeadTestData");
		String lastName=map.get("Last Name") + jutil.generateRandomNum(100);
		createLead.setLastName(lastName);
		createLead.clickSave();
		
		Thread.sleep(3000);
		newLead.getLeadsLink();
		
		if(lead.getNewLeadName().equals(lastName)) {
			System.out.println("Test Pass");
			excel.updateTestStatus("Create Lead", "Pass", ICnstantPath.EXCEL_PATH,"LeadsTestData");

		}else {
			System.out.println("Test Fail");
			excel.updateTestStatus("Create Lead", "Fail", ICnstantPath.EXCEL_PATH,"LeadsTestData");

		}
	}
}
