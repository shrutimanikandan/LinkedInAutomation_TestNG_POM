package testcases;


import org.testng.annotations.Test;

import base.WrapperMethods;
import pages.LoginPage;

public class LoginAndLogout extends WrapperMethods {
	
	//@BeforeTest
	//public void setFile() {
	//	excelFileName = "DataSample";

	//}
	
	//@Test(dataProvider="fetchData")
	
	@Test
	public void loginAndLogout() throws InterruptedException {
		
		new LoginPage(driver)
		.enterUsername("USERNAME")
		.enterPassword("PASSWORD")
		.clickLogin()
		.searchJob()
		.clickOption()
		.scrollDown()
		.selectLoc()
		;
		
		
	}

}
