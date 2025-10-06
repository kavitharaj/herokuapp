package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseClass.setupClass;
import pageObjects.LoginPage;
import pageObjects.makeAppointment;

public class homepage extends setupClass {
	@Test(groups= {"sanity","smoke","regression"})
	public void makeappointment() throws IOException {
		try {
		makeAppointment makeappoint=new makeAppointment(driver);
		makeappoint.click_makeappointment();
		LoginPage lp = new LoginPage(driver);
		lp.send_username("John Doe");
		lp.send_pasword("ThisIsNotAPassword");
		lp.click_login();
		Thread.sleep(5000);
		lp.click_menu();
		//lp.click_logout();
		Thread.sleep(3000);
		lp.click_home();
	}catch(Exception e) {
		e.printStackTrace();
	}
		
	}
	
	

}
