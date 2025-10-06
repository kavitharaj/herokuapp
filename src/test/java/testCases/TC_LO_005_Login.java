package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.setupClass;
import pageObjects.LoginPage;
import pageObjects.makeAppointment;

public class TC_LO_005_Login extends setupClass {
@Test(groups={"regression"})
	public void EmptyUserName_EmptyPassword() throws IOException {
		try {
			makeAppointment makeappoint = new makeAppointment(driver);
			makeappoint.click_makeappointment();

			LoginPage lp = new LoginPage(driver);
			// lp.send_username("kavitha");
			// lp.send_pasword("Password");
			lp.click_login();
			String invalidlogin = lp.invalidlogin();
			System.out.println(invalidlogin);

			if (invalidlogin.equals("Login failed! Please ensure the username and password are valid.")) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
