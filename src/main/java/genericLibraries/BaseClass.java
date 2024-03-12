package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import pomPages.ContactsPage;
import pomPages.CreateNewContacts;
import pomPages.CreateNewEventPage;
import pomPages.CreateNewLeadPage;
import pomPages.CreateNewOrganizationPage;
import pomPages.DuplicatingLeadPage;
import pomPages.HomePage;
import pomPages.LeadsPage;
import pomPages.LoginPage;
import pomPages.NewContactsDetailPage;
import pomPages.NewEventDetailsPage;
import pomPages.NewLeadDetailsPage;
import pomPages.NewOrgdetailsPage;
import pomPages.OrganisationsPage;
//This Sccript is edited
public class BaseClass {
	
	//@BeforeSuite
		//@BeforeTest
		
		protected PropertiesUtility property;
		protected ExcelUtility excel;
		protected WebDriverUtility web;
		protected JavaUtility jutil;
		
		protected WebDriver driver;
		protected SoftAssert soft;
		
		protected LoginPage login;
		protected HomePage home;
		protected OrganisationsPage org;
		protected ContactsPage contact;
		protected LeadsPage lead;
		protected CreateNewOrganizationPage createOrg;
		protected CreateNewContacts createContact;
		protected CreateNewLeadPage createLead;
		protected CreateNewEventPage createEvent;
		protected DuplicatingLeadPage duplicateLead;
		protected NewOrgdetailsPage newOrg;
		protected NewContactsDetailPage newContact;
		protected NewLeadDetailsPage newLead;
		protected NewEventDetailsPage newEvent;
		
		
		@BeforeClass
		public void classSetup() {
			property=new PropertiesUtility();
			excel=new ExcelUtility();
			web=new WebDriverUtility();
			jutil=new JavaUtility();
			
			property.propertiesInit(ICnstantPath.PROPERTIES_PATH);
			driver = web.launchBrowserAndMaximize(property.readFromProperties("browser"));
			web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));
			
		}
		@BeforeMethod
		public void methodSetup() {
			login=new LoginPage(driver);
			home=new HomePage(driver);
			org=new OrganisationsPage(driver);
			contact=new ContactsPage(driver);
			lead=new LeadsPage(driver);
			createOrg=new CreateNewOrganizationPage(driver);
			createContact=new CreateNewContacts(driver);
			createLead=new CreateNewLeadPage(driver);
			createEvent=new CreateNewEventPage(driver);
			newOrg=new NewOrgdetailsPage(driver);
			newContact=new NewContactsDetailPage(driver);
			newLead=new NewLeadDetailsPage(driver);
			newEvent=new NewEventDetailsPage(driver);
			duplicateLead=new DuplicatingLeadPage(driver);
			soft = new SoftAssert();
			
			excel.excelInit(ICnstantPath.EXCEL_PATH);
			web.navigateToApp(property.readFromProperties("url"));
			Assert.assertEquals(login.getPageHeder(), "vtiger");
			login.loinToVtiger(property.readFromProperties("username"),
					            property.readFromProperties("password"));
			
			Assert.assertTrue(home.getPageHeader().contains("Home"));
			
		}
		
		
		@AfterMethod
		public void methodTearDown() {
			home.signOutOfApp(web);
			excel.closeExcel();
		}
		@AfterClass
		public void classTeardown() {
			web.quitAllWindows();
			
			
		}
		//@AfterTest
		//@AfterSuite

	

}
