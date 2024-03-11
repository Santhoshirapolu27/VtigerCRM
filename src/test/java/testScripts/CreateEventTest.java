package testScripts;


import java.util.Map;

import org.testng.annotations.Test;

import genericLibraries.BaseClass;
import genericLibraries.ICnstantPath;

//import genercLibraries.BaseClass;
//import genercLibraries.IConstantPath;

public class CreateEventTest extends BaseClass {
@Test
public void createEventTest() throws InterruptedException {
	Map<String, String>map=excel.readFromExcel("Create New Event","EventsTestData");
	home.selectFromQuickCreate(web, map.get("Quick Create"));
	String subject=map.get("Subject")+jutil.generateRandomNum(100);
	createEvent.setSubjectTF(subject);
	createEvent.setStartDate(map.get("Start Date"));
	createEvent.setEndDate(map.get("Due Date"));
	Thread.sleep(3000);
	createEvent.clickSave(); 
	if(newEvent.getPageHeader().contains(subject)) {
		System.out.println("Test Pass");
		excel.updateTestStatus("Create New Event", "Pass", ICnstantPath.EXCEL_PATH, "EventsTestData");
	}
	else {
		System.out.println("Test Fail");
		excel.updateTestStatus("Create New Event", "Fail", ICnstantPath.EXCEL_PATH, "EventsTestData");
	}
}
}