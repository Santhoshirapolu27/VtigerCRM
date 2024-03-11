package testScripts;

	import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.ICnstantPath;

	public class CreateOrgTest extends genericLibraries.BaseClass {
		@Test
		public void createNewOrgTest() throws InterruptedException {
			SoftAssert soft = new SoftAssert();
			home.clickOrganizations();
			soft.assertEquals(org.getPageHeader(), "Organizations");
			org.clickplusButton();
			soft.assertEquals(createOrg.getPageHeader(), "Creating New Organization");
			
			
			Map<String,String> map=excel.readFromExcel("Create Organization","OrganizationsTestData");
			String orgName=map.get("Organization Name")+jutil.generateRandomNum(100);
			createOrg.enterOrganizationName(orgName);
			createOrg.clickSave();
			
			Thread.sleep(3000);
			soft.assertTrue(newOrg.getPageHeader().contains(orgName));
			newOrg.clickOrgLink();
			
			if(org.getNewOrgName().equals(orgName)) {
				System.out.println("test pass");
				excel.updateTestStatus("Create Organization","Pass",ICnstantPath.EXCEL_PATH,"OrganizationsTestData");
			}
			else {
				System.out.println("test fail");
				excel.updateTestStatus("Create Organization","Fail",ICnstantPath.EXCEL_PATH,"OrganizationsTestData");
			}
			soft.assertEquals(org.getNewOrgName(), orgName);
			soft.assertAll();
		}

	
}
