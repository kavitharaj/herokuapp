package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.setupClass;
import pageObjects.LoginPage;
import pageObjects.makeAppointment;

public class TC_LO_001_Login extends setupClass {
	@Test(groups= {"sanity","smoke","regression"})
	public void ValidUserName_ValidPassword() throws IOException {
		try {
			makeAppointment makeappoint = new makeAppointment(driver);
			makeappoint.click_makeappointment();

			LoginPage lp = new LoginPage(driver);
			lp.send_username("John Doe");
			lp.send_pasword("ThisIsNotAPassword");
			lp.click_login();
			String validlogin = lp.validlogin();
			System.out.println(validlogin);

			if (validlogin.equals("Make Appointment")) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
