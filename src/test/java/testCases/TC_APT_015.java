package testCases;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import BaseClass.setupClass;
import pageObjects.LoginPage;
import pageObjects.makeAppointment;

public class TC_APT_015 extends setupClass {
	@Test
	public void verify_Withreadmissionclick_withdate_Withoutcomment() {
try {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		makeAppointment makeappoint = new makeAppointment(driver);
		makeappoint.click_makeappointment();

		LoginPage lp = new LoginPage(driver);
		lp.send_username("John Doe");
		lp.send_pasword("ThisIsNotAPassword");
		lp.click_login();

		makeappoint.select_combo_facility(2);
		makeappoint.click_chk_readmission();
		// makeappoint.click_radio_healthecareprogram_medicare();
		makeappoint.pick_visitdateFuture();
		act.keyUp(Keys.ESCAPE).keyDown(Keys.ESCAPE).build().perform();

		//makeappoint.send_comment("I will arrived at 10 Am at mar 31 for medicare program in Seoul healthcare center");
		makeappoint.click_bookappointment();
		String Confirmappoint = makeappoint.confirmappointment();
		System.out.println(Confirmappoint);

		if (Confirmappoint.equals("Appointment Confirmation")) {
			System.out.println("Test is passed if  give visit date without comment ");
			Assert.assertTrue(true);
		} else {
			System.out.println("make appointment page not open");
			Assert.assertTrue(false);
		}
}
catch(Exception e) {
	System.out.println("The page not in Confirm appointment ");
	Assert.assertTrue(false);
	e.printStackTrace();
}
	}
}
