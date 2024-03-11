package testScripts;

import java.util.Map;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.ICnstantPath;
public class CreateOrgWithTypeAndIndustryTest extends BaseClass {
	
	@Test
	public void createOrgWithTypeAndIndustryTest() throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		home.clickOrganizations();
		soft.assertEquals(org.getPageHeader(), "Organizations");
		org.clickplusButton();
		soft.assertEquals(createOrg.getPageHeader(), "Creating New Organization");

		
		Map<String, String> map = excel.readFromExcel("Create Organization With Industry And Type", "OrganizationsTestData");
		String OrgName=map.get("Organization Name") + jutil.generateRandomNum(100);
		createOrg.enterOrganizationName(OrgName);
		createOrg.selectIndustry(web, map.get("Industry"));
		createOrg.selectType(web, map.get("Type"));
		createOrg.clickSave();
		
		Thread.sleep(3000);
		soft.assertTrue(newOrg.getPageHeader().contains(OrgName));
		newOrg.clickOrgLink();
		if(org.getNewOrgName().equals(OrgName)) {
			System.out.println("test pass");
			excel.updateTestStatus("Create Organization With Industry And type", "Pass", ICnstantPath.EXCEL_PATH,"OrganizationsTestData");
			
		}else {
			System.out.println("test fail");
			excel.updateTestStatus("Create Organization With Industry And type", "Fail", ICnstantPath.EXCEL_PATH,"OrganizationsTestData");
		}
		soft.assertEquals(org.getNewOrgName(), OrgName);
		soft.assertAll();
	}

}
